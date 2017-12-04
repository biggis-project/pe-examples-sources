package org.streampipes.examples.sources.streams;


import org.streampipes.examples.sources.config.ExampleSourcesConfig;
import org.streampipes.model.SpDataStream;
import org.streampipes.model.graph.DataSourceDescription;
import org.streampipes.sdk.builder.DataStreamBuilder;
import org.streampipes.sdk.helpers.EpProperties;
import org.streampipes.sdk.helpers.Formats;
import org.streampipes.sdk.helpers.Labels;
import org.streampipes.sdk.helpers.Protocols;
import org.streampipes.sources.AbstractAlreadyExistingStream;
import org.streampipes.vocabulary.Geo;

public class VehicleStream extends AbstractAlreadyExistingStream {

  @Override
  public SpDataStream declareModel(DataSourceDescription sep) {
    return DataStreamBuilder.create("vehicle-position", "Vehicle Position", "An event stream " +
            "that produces current vehicle positions")
            .property(EpProperties.timestampProperty("timestamp"))
            .property(EpProperties.stringEp(Labels.from("plate-number", "Plate Number", "Denotes the " +
                    "plate number of the vehicle"), "plateNumber", "http://my.company/plateNumber"))
            .property(EpProperties.doubleEp(Labels.from("latitude", "Latitude", "Denotes the latitude " +
                    "value of the vehicle's position"), "latitude", Geo
                    .lat))
            .property(EpProperties.doubleEp(Labels.from("longitude", "Longitude", "Denotes the longitude " +
                    "value of the vehicle's position"), "longitude", Geo.lng))
            .format(Formats.jsonFormat())
            .protocol(Protocols.kafka(ExampleSourcesConfig.INSTANCE.getKafkaHost(), ExampleSourcesConfig.INSTANCE.getKafkaPort(),
                    "org.streampipes.examples.sources.vehicle"))
            .build();
  }
}
