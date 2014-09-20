/**
 * This code was generated from {@link net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package net.adamsmolnik.exercise.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClient;

public interface ExerciseDataProcessingWorkflowClient extends WorkflowClient
{
    Promise<Void> launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations);
    Promise<Void> launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, Promise<?>... waitFor);
    Promise<Void> launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
    Promise<Void> launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations);
    Promise<Void> launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, Promise<?>... waitFor);
    Promise<Void> launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
}