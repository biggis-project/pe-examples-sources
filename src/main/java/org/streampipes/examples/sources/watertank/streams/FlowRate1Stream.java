/*
 * Copyright 2017 FZI Forschungszentrum Informatik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import org.streampipes.sources.AbstractAdapterIncludedStream;

import java.net.URI;

public class FlowRate1Stream extends AbstractAdapterIncludedStream {

  @Override
  public SpDataStream declareModel(DataSourceDescription sep) {
    return DataStreamBuilder.create("flowrate-1", "Flow Rate Sensor 1", "")
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
                    "org.streampipes.examples.flowrate-1"))
            .build();
  }

  @Override
  public void executeStream() {
    Thread thread = new Thread(new ExampleSourceDataSimulator());
    thread.start();
  }

}