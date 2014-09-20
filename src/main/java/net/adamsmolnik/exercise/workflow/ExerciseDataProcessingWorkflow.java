package net.adamsmolnik.exercise.workflow;

import java.util.Set;
import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.GetState;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

/**
 * @author ASmolnik
 *
 */
@Workflow
@WorkflowRegistrationOptions(defaultExecutionStartToCloseTimeoutSeconds = 3600)
public interface ExerciseDataProcessingWorkflow {

    @Execute(version = "1.0.0")
    public void launch(String bucketName, String srcObjectKey, Set<ExerciseActionType> operations);

    @GetState
    public String getState();
}
