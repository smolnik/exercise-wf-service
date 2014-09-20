/**
 * This code was generated from {@link net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package net.adamsmolnik.exercise.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowSelfClient;

public interface ExerciseDataProcessingWorkflowSelfClient extends WorkflowSelfClient
{
    void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations);
    void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, Promise<?>... waitFor);
    void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
    void launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations);
    void launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, Promise<?>... waitFor);
    void launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
}