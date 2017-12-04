package org.streampipes.examples.sources;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.container.declarer.SemanticEventProducerDeclarer;
import org.streampipes.examples.sources.streams.FestoContainerB101Stream;
import org.streampipes.examples.sources.streams.FestoContainerB102Stream;
import org.streampipes.examples.sources.streams.FestoFlowRateStream;
import org.streampipes.examples.sources.streams.FestoPressureTankStream;
import org.streampipes.examples.sources.streams.SiemensFlowRateSensorStream;
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
    return Arrays.asList(new FestoContainerB101Stream(),
            new FestoContainerB102Stream(),
            new FestoFlowRateStream(),
            new FestoFlowRateStream(),
            new FestoPressureTankStream(),
            new SiemensFlowRateSensorStream());
  }
}
