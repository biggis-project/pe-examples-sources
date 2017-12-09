package org.streampipes.examples.sources.watertank.streams;

import org.streampipes.examples.sources.AbstractDemonstratorStream;
import org.streampipes.examples.sources.config.ExampleSourcesConfig;
import org.streampipes.examples.sources.config.ExampleSourcesVariables;
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

public class WaterLevel2Stream extends AbstractDemonstratorStream {

	public WaterLevel2Stream() {
		super(ExampleSourcesVariables.WATER_LEVEL_2);
	}

	@Override
	public SpDataStream declareModel(DataSourceDescription sep) {
		return DataStreamBuilder.create(id(), name(), description())
						.iconUrl(icon())
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
										.create(Datatypes.Boolean, "underflow")
										.label("Underflow")
										.description("Indicates whether the tank underflows")
										.domainProperty(WaterTankVocabulary.IS_UNDERFLOW)
										.scope(PropertyScope.MEASUREMENT_PROPERTY)
										.build())
						.format(Formats.jsonFormat())
						.protocol(Protocols.kafka(ExampleSourcesConfig.INSTANCE.getKafkaHost(), ExampleSourcesConfig.INSTANCE.getKafkaPort(),
										topic()))
						.build();
	}
}