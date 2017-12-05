package org.streampipes.examples.sources.simulator;

import net.acesinc.data.json.generator.DataSimulator;
import net.acesinc.data.json.generator.JsonDataGenerator;
import net.acesinc.data.json.generator.SimulationUtils;
import net.acesinc.data.json.generator.config.JSONConfigReader;
import net.acesinc.data.json.generator.config.SimulationConfig;
import net.acesinc.data.json.generator.config.WorkflowConfig;
import net.acesinc.data.json.generator.workflow.Workflow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExampleSourceDataSimulator implements Runnable {

  private static final String EXAMPLES_CONFIG_FILE = "streampipesDemoConfig.json";

  private void initSimulation() {
    SimulationConfig config = null;
    try {
      config = buildSimulationConfig();
      Map<String, Workflow> workflows = buildSimWorkflows(config);
      JsonDataGenerator generator = new JsonDataGenerator(config, workflows);

      new DataSimulator().runSimulation(generator);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private SimulationConfig buildSimulationConfig() throws IOException {
    return JSONConfigReader.readConfig(SimulationUtils.class.getClassLoader().getResourceAsStream(EXAMPLES_CONFIG_FILE),
            SimulationConfig.class);
  }

  private Map<String, Workflow> buildSimWorkflows(SimulationConfig config) throws IOException {
    Map<String, Workflow> workflows = new HashMap<>();
    for(WorkflowConfig workflowConfig : config.getWorkflows()) {
      workflows.put(workflowConfig.getWorkflowFilename(), JSONConfigReader.readConfig(SimulationUtils.class
                      .getClassLoader().getResourceAsStream(workflowConfig.getWorkflowFilename()),
              Workflow.class));
    }

    return workflows;
  }

  @Override
  public void run() {
    initSimulation();
  }
}
