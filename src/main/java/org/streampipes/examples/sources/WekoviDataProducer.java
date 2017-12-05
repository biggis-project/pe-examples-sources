package org.streampipes.examples.sources;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.container.declarer.SemanticEventProducerDeclarer;
import org.streampipes.examples.sources.streams.WekoviStream;
import org.streampipes.model.graph.DataSourceDescription;

import java.util.ArrayList;
import java.util.List;

public class WekoviDataProducer implements SemanticEventProducerDeclarer {
	
	@Override
	public DataSourceDescription declareModel() {
		DataSourceDescription sep = new DataSourceDescription("wekovi_producer", "Wekovi Producer", "Producer for StreamConnect Adapters");
		return sep;
	}

	
	@Override
	public List<EventStreamDeclarer> getEventStreams() {
		
		List<EventStreamDeclarer> streams = new ArrayList<EventStreamDeclarer>();
		
		streams.add(new WekoviStream());

	
		return streams;
	}

}
