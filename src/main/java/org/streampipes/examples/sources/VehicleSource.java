package org.streampipes.examples.sources;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.container.declarer.SemanticEventProducerDeclarer;
import org.streampipes.examples.sources.streams.VehicleStream;
import org.streampipes.model.graph.DataSourceDescription;
import org.streampipes.sdk.builder.DataSourceBuilder;

import java.util.Arrays;
import java.util.List;


public class VehicleSource implements SemanticEventProducerDeclarer {

  public DataSourceDescription declareModel() {
    return DataSourceBuilder.create("source-vehicle", "Vehicle Source", "A data source that " +
            "holds event streams produced by vehicles.")
            .build();
  }

  public List<EventStreamDeclarer> getEventStreams() {
    return Arrays.asList(new VehicleStream());
  }
}