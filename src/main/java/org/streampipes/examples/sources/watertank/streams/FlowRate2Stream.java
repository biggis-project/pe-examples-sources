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

public class FlowRate2Stream extends AbstractAlreadyExistingStream {


	@Override
	public SpDataStream declareModel(DataSourceDescription sep) {
		return DataStreamBuilder.create("flowrate_2", "Flow Rate Sensor 2", "")
						.iconUrl(ExampleSourcesConfig.iconBaseUrl + "/icon-flowrate-1.png")
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
										.create(Datatypes.Float, "volume_flow")
										.label("Volume Flow")
										.description("Denotes the current volume flow")
										.domainProperty(WaterTankVocabulary.HAS_VOLUME_FLOW)
										.scope(PropertyScope.MEASUREMENT_PROPERTY)
										.build())
						.property(PrimitivePropertyBuilder
										.create(Datatypes.Float, "density")
										.label("Density")
										.description("Denotes the current density of the fluid")
										.domainProperty(WaterTankVocabulary.HAS_DENSITY)
										.scope(PropertyScope.MEASUREMENT_PROPERTY)
										.build())
						.property(PrimitivePropertyBuilder
										.create(Datatypes.Float, "fluid_temperature")
										.label("Fluid Temperature")
										.description("Denotes the current temperature of the fluid")
										.domainProperty(WaterTankVocabulary.HAS_TEMPERATURE)
										.scope(PropertyScope.MEASUREMENT_PROPERTY)
										.build())
						.property(PrimitivePropertyBuilder
										.create(Datatypes.Float, "sensor_fault_flags")
										.label("Sensor Fault Flags")
										.description("Any fault flags of the sensors")
										.domainProperty(WaterTankVocabulary.HAS_SENSOR_FAULT_FLAGS)
										.scope(PropertyScope.MEASUREMENT_PROPERTY)
										.build())
						.format(Formats.jsonFormat())
						.protocol(Protocols.kafka(ExampleSourcesConfig.INSTANCE.getKafkaHost(), ExampleSourcesConfig.INSTANCE.getKafkaPort(),
										"org.streampipes.examples.flowrate_2"))
						.build();
	}

}
