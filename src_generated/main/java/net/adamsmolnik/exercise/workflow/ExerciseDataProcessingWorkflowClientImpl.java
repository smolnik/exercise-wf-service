/**
 * This code was generated from {@link net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package net.adamsmolnik.exercise.workflow;

import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientBase;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClient;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecution;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

class ExerciseDataProcessingWorkflowClientImpl extends WorkflowClientBase implements ExerciseDataProcessingWorkflowClient {

    public ExerciseDataProcessingWorkflowClientImpl(WorkflowExecution workflowExecution, WorkflowType workflowType,  
            StartWorkflowOptions options, DataConverter dataConverter, GenericWorkflowClient genericClient) {
        super(workflowExecution, workflowType, options, dataConverter, genericClient);
    }
    
    @Override
    public final Promise<Void> launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations) { 
        return launch(Promise.asPromise(bucketName), Promise.asPromise(srcObjectKey), Promise.asPromise(operations), (StartWorkflowOptions)null);
    }
    
    @Override
    public final Promise<Void> launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, Promise<?>... waitFor) {
        return launch(Promise.asPromise(bucketName), Promise.asPromise(srcObjectKey), Promise.asPromise(operations), (StartWorkflowOptions)null, waitFor);
    }
    
    
    @Override
    
    public final Promise<Void> launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        return launch(Promise.asPromise(bucketName), Promise.asPromise(srcObjectKey), Promise.asPromise(operations), optionsOverride, waitFor);
    }

    @Override
    public final Promise<Void> launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations) {
        return launch(bucketName, srcObjectKey, operations, (StartWorkflowOptions)null);
    }

    @Override
    public final Promise<Void> launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, Promise<?>... waitFor) {
        return launch(bucketName, srcObjectKey, operations, (StartWorkflowOptions)null, waitFor);
    }

    @Override
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final Promise<Void> launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        Promise[] _input_ = new Promise[3];
        _input_[0] = bucketName;
        _input_[1] = srcObjectKey;
        _input_[2] = operations;
        return (Promise) startWorkflowExecution(_input_, optionsOverride, Void.class, waitFor);
    }
    	

}