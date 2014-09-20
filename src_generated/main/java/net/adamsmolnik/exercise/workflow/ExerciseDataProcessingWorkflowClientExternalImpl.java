/**
 * This code was generated from {@link net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package net.adamsmolnik.exercise.workflow;

import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientExternalBase;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClientExternal;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecution;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

class ExerciseDataProcessingWorkflowClientExternalImpl extends WorkflowClientExternalBase implements ExerciseDataProcessingWorkflowClientExternal {

    public ExerciseDataProcessingWorkflowClientExternalImpl(WorkflowExecution workflowExecution, WorkflowType workflowType, 
            StartWorkflowOptions options, DataConverter dataConverter, GenericWorkflowClientExternal genericClient) {
        super(workflowExecution, workflowType, options, dataConverter, genericClient);
    }

    @Override
    public void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations) { 
        launch(bucketName, srcObjectKey, operations, null);
    }

    @Override
    public void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, StartWorkflowOptions startOptionsOverride) {
    
        Object[] _arguments_ = new Object[3]; 
        _arguments_[0] = bucketName;
        _arguments_[1] = srcObjectKey;
        _arguments_[2] = operations;
        dynamicWorkflowClient.startWorkflowExecution(_arguments_, startOptionsOverride);
    }


    @Override
    public java.lang.String getState()  {
        java.lang.String _state_ = null;
        try {
            _state_ = dynamicWorkflowClient.getWorkflowExecutionState(java.lang.String.class);
        } catch (Throwable _failure_) {
            if (_failure_ instanceof RuntimeException) {
                throw (RuntimeException) _failure_;
            } else if (_failure_ instanceof Error) {
                throw (Error) _failure_;
            } else {
                throw new RuntimeException("Unknown exception.", _failure_);
            }
        }

        return _state_;
    }
}