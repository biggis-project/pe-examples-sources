package org.streampipes.examples.sources.watertank.streams;

import org.streampipes.examples.sources.config.ExampleSourcesConfig;
import org.streampipes.examples.sources.simulator.ExampleSourceDataSimulator;
import org.streampipes.examples.sources.vocabulary.WaterTankVocabulary;
import org.streampipes.model.SpDataStream;
import org.streampipes.model.graph.DataSourceDescription;
import org.streampipes.model.schema.PropertyScope;
import org.streampipes.sdk.builder.DataStreamBuilder;
import org.streampipes.sdk.builder.PrimitivePropertyBuilder;
import org.streampipes.sdk.helpers.EpProperties;
import org.streampipes.sdk.helpers.Formats;
import org.streampipes.sdk.helpers.Protocols;
import org.streampipes.sdk.utils.Datatypes;
import org.streampipes.sources.AbstractAlreadyExistingStream;

public class WaterLevel1Stream extends AbstractAlreadyExistingStream {

  @Override
  public SpDataStream declareModel(DataSourceDescription sep) {
    return DataStreamBuilder.create("water_level_1", "Water Level 1", "")
            .iconUrl(ExampleSourcesConfig.iconBaseUrl + "/icon-water-level.png")
            .property(EpProperties.timestampProperty("timestamp"))
            .property(PrimitivePropertyBuilder
                    .create(Datatypes.String, "sensorId")
                    .label("Sensor ID")
                    .description("The ID of the sensor")
                    .domainProperty(WaterTankVocabulary.HAS_SENSOR_ID)
                    .scope(PropertyScope.DIMENSION_PROPERTY)
                    .build())
            .property(PrimitivePropertyBuilder
                    .create(Datatypes.Float, "level")
                    .label("Water Level")
                    .description("Denotes the current water level in the container")
                    .domainProperty(WaterTankVocabulary.HAS_WATER_LEVEL)
                    .scope(PropertyScope.MEASUREMENT_PROPERTY)
                    .build())
            .property(PrimitivePropertyBuilder
                    .create(Datatypes.Boolean, "overflow")
                    .label("Overflow")
                    .description("Indicates whether the tank overflows")
                    .domainProperty(WaterTankVocabulary.IS_OVERFLOW)
                    .scope(PropertyScope.MEASUREMENT_PROPERTY)
                    .build())
            .property(PrimitivePropertyBuilder
                    .create(Datatypes.Boolean, "underflow")
                    .label("Underflow")
                    .description("Indicates whether the tank underflows")
                    .domainProperty(WaterTankVocabulary.IS_UNDERFLOW)
                    .scope(PropertyScope.MEASUREMENT_PROPERTY)
                    .build())
            .format(Formats.jsonFormat())
            .protocol(Protocols.kafka(ExampleSourcesConfig.INSTANCE.getKafkaHost(), ExampleSourcesConfig.INSTANCE.getKafkaPort(),
                    "org.streampipes.examples.waterlevel"))
            .build();
  }

  @Override
  public void executeStream() {
    Thread thread = new Thread(new ExampleSourceDataSimulator());
    thread.start();
  }
}
