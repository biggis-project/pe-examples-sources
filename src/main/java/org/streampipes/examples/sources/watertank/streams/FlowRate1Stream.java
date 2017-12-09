package org.streampipes.examples.sources.watertank.streams;

import org.streampipes.examples.sources.config.ExampleSourcesConfig;
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

import java.net.URI;

public class FlowRate1Stream extends AbstractAlreadyExistingStream {

  @Override
  public SpDataStream declareModel(DataSourceDescription sep) {
    return DataStreamBuilder.create("flowrate_1", "Flow Rate Sensor 1", "")
            .iconUrl(ExampleSourcesConfig.iconBaseUrl + "/Flowrate-Festo.png")
            .property(EpProperties.timestampProperty("timestamp"))
            .property(PrimitivePropertyBuilder
                    .create(Datatypes.String, "sensorId")
                    .label("Sensor ID")
                    .description("The ID of the sensor")
                    .domainProperty(WaterTankVocabulary.HAS_SENSOR_ID)
                    .scope(PropertyScope.DIMENSION_PROPERTY)
                    .build())
            .property(PrimitivePropertyBuilder
                    .create(Datatypes.Float, "mass_flow")
                    .label("Mass Flow")
                    .description("Denotes the current mass flow in the sensor")
                    .domainProperty(WaterTankVocabulary.HAS_MASS_FLOW)
                    .scope(PropertyScope.MEASUREMENT_PROPERTY)
                    .build())
            .property(PrimitivePropertyBuilder
                    .create(Datatypes.Float, "temperature")
                    .label("Temperature")
                    .description("Denotes the current temperature in degrees celsius")
                    .domainProperty(WaterTankVocabulary.HAS_TEMPERATURE)
                    .scope(PropertyScope.MEASUREMENT_PROPERTY)
                    .measurementUnit(URI.create("http://codes.wmo.int/common/unit/degC"))
                    .valueSpecification(0.0f, 100.0f, 0.1f)
                    .build())
            .format(Formats.jsonFormat())
            .protocol(Protocols.kafka(ExampleSourcesConfig.INSTANCE.getKafkaHost(), ExampleSourcesConfig.INSTANCE.getKafkaPort(),
                    "org.streampipes.examples.flowrate_1"))
            .build();
  }
}