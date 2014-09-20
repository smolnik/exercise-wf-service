/**
 * This code was generated from {@link net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package net.adamsmolnik.exercise.workflow;

import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientFactoryBase;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClient;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecution;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

public class ExerciseDataProcessingWorkflowClientFactoryImpl extends WorkflowClientFactoryBase<ExerciseDataProcessingWorkflowClient> implements ExerciseDataProcessingWorkflowClientFactory {
    
    public ExerciseDataProcessingWorkflowClientFactoryImpl() {
        this(null, null, null);
    }

    public ExerciseDataProcessingWorkflowClientFactoryImpl(StartWorkflowOptions startWorkflowOptions) {
        this(startWorkflowOptions, null, null);
    }

    public ExerciseDataProcessingWorkflowClientFactoryImpl(StartWorkflowOptions startWorkflowOptions, DataConverter dataConverter) {
        this(startWorkflowOptions, dataConverter, null);
    }

    public ExerciseDataProcessingWorkflowClientFactoryImpl(StartWorkflowOptions startWorkflowOptions, DataConverter dataConverter,
            GenericWorkflowClient genericClient) {
        super(startWorkflowOptions, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), genericClient);
    }
    
    @Override
    protected ExerciseDataProcessingWorkflowClient createClientInstance(WorkflowExecution execution,
            StartWorkflowOptions options, DataConverter dataConverter, GenericWorkflowClient genericClient) {
        WorkflowType workflowType = new WorkflowType();
        workflowType.setName("ExerciseDataProcessingWorkflow.launch");
        workflowType.setVersion("1.0.0");
        return new ExerciseDataProcessingWorkflowClientImpl(execution, workflowType, options, dataConverter, genericClient);
    }
   
}