package org.streampipes.examples.sources;

import org.streampipes.container.declarer.EventStreamDeclarer;
import org.streampipes.examples.sources.config.ExampleSourcesVariables;
import org.streampipes.sources.AbstractAlreadyExistingStream;

public abstract class AbstractDemonstratorStream extends AbstractAlreadyExistingStream implements EventStreamDeclarer {

	protected ExampleSourcesVariables variables;
	
	public AbstractDemonstratorStream(ExampleSourcesVariables variables) {
		this.variables = variables;
	}

	protected String id() {
		return variables.tagNumber();
	}

	protected String name() {
		return variables.eventName();
	}

	protected String description() {
		return variables.description();
	}

	protected String icon() {
		return variables.icon();
	}

	protected String topic() {
		return variables.topic();
	}
}
