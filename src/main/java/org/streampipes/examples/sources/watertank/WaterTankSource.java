package org.streampipes.examples.sources.watertank;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.container.declarer.SemanticEventProducerDeclarer;
import org.streampipes.examples.sources.watertank.streams.*;
import org.streampipes.model.graph.DataSourceDescription;
import org.streampipes.sdk.builder.DataSourceBuilder;


import java.util.Arrays;
import java.util.List;

public class WaterTankSource  implements SemanticEventProducerDeclarer {

  public DataSourceDescription declareModel() {
    return DataSourceBuilder.create("water-tank", "Water Tank Source", "A data source that " +
            "holds event streams produces by a water tank system.")
            .build();
  }

  public List<EventStreamDeclarer> getEventStreams() {
    return Arrays.asList(new WaterLevel1Stream(),
            new WaterLevel2Stream(),
            new FlowRate1Stream(),
            new PressureTankStream(),
            new FlowRate2Stream());
  }
}
