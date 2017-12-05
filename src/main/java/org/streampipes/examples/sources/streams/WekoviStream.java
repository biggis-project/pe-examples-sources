package org.streampipes.examples.sources.streams;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.examples.sources.config.ExampleSourcesConfig;
import org.streampipes.model.SpDataStream;
import org.streampipes.model.graph.DataSourceDescription;
import org.streampipes.sdk.builder.DataStreamBuilder;
import org.streampipes.sdk.helpers.EpProperties;
import org.streampipes.sdk.helpers.Formats;
import org.streampipes.sdk.helpers.Protocols;

public class WekoviStream implements EventStreamDeclarer {

    @Override
    public SpDataStream declareModel(DataSourceDescription sep) {
        return DataStreamBuilder.create("wekovi_stream", "Wekovi Stream", "Generic stream for the StreamConnect adapter")
                .property(EpProperties.timestampProperty("timestamp"))
                .format(Formats.jsonFormat())
                .protocol(Protocols.kafka(ExampleSourcesConfig.INSTANCE.getKafkaHost(), ExampleSourcesConfig.INSTANCE.getKafkaPort(),
                        ExampleSourcesConfig.INSTANCE.getStreamConnectTopic()))
                .build();
    }

    @Override
    public void executeStream() {

    }

    @Override
    public boolean isExecutable() {
        return false;
    }
}
