/**
 * This code was generated from {@link net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package net.adamsmolnik.exercise.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.AndPromise;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.core.Task;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowSelfClientBase;
import com.amazonaws.services.simpleworkflow.flow.generic.ContinueAsNewWorkflowExecutionParameters;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClient;

public class ExerciseDataProcessingWorkflowSelfClientImpl extends WorkflowSelfClientBase implements ExerciseDataProcessingWorkflowSelfClient {

    public ExerciseDataProcessingWorkflowSelfClientImpl() {
        this(null, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public ExerciseDataProcessingWorkflowSelfClientImpl(GenericWorkflowClient genericClient) {
        this(genericClient, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public ExerciseDataProcessingWorkflowSelfClientImpl(GenericWorkflowClient genericClient, 
            DataConverter dataConverter, StartWorkflowOptions schedulingOptions) {
            
        super(genericClient, dataConverter, schedulingOptions);
    }

    @Override
    public final void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations) { 
        launchImpl(Promise.asPromise(bucketName), Promise.asPromise(srcObjectKey), Promise.asPromise(operations), (StartWorkflowOptions)null);
    }

    @Override
    public final void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, Promise<?>... waitFor) { 
        launchImpl(Promise.asPromise(bucketName), Promise.asPromise(srcObjectKey), Promise.asPromise(operations), (StartWorkflowOptions)null, waitFor);
    }
    
    @Override
    public final void launch(java.lang.String bucketName, java.lang.String srcObjectKey, java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        launchImpl(Promise.asPromise(bucketName), Promise.asPromise(srcObjectKey), Promise.asPromise(operations), optionsOverride, waitFor);
    }
    
    @Override
    public final void launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations) {
        launchImpl(bucketName, srcObjectKey, operations, (StartWorkflowOptions)null);
    }

    @Override
    public final void launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, Promise<?>... waitFor) {
        launchImpl(bucketName, srcObjectKey, operations, (StartWorkflowOptions)null, waitFor);
    }

    @Override
    public final void launch(Promise<java.lang.String> bucketName, Promise<java.lang.String> srcObjectKey, Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        launchImpl(bucketName, srcObjectKey, operations, optionsOverride, waitFor);
    }
    
    protected void launchImpl(final Promise<java.lang.String> bucketName, final Promise<java.lang.String> srcObjectKey, final Promise<java.util.Set<net.adamsmolnik.exercise.workflow.ExerciseActionType>> operations, final StartWorkflowOptions schedulingOptionsOverride, Promise<?>... waitFor) {
        new Task(new Promise[] { bucketName, srcObjectKey, operations, new AndPromise(waitFor) }) {
    		@Override
			protected void doExecute() throws Throwable {
                ContinueAsNewWorkflowExecutionParameters _parameters_ = new ContinueAsNewWorkflowExecutionParameters();
                Object[] _input_ = new Object[3];
                _input_[0] = bucketName.get();
                _input_[1] = srcObjectKey.get();
                _input_[2] = operations.get();
                String _stringInput_ = dataConverter.toData(_input_);
				_parameters_.setInput(_stringInput_);
				_parameters_ = _parameters_.createContinueAsNewParametersFromOptions(schedulingOptions, schedulingOptionsOverride);
                
                if (genericClient == null) {
                    genericClient = decisionContextProvider.getDecisionContext().getWorkflowClient();
                }
                genericClient.continueAsNewOnCompletion(_parameters_);
			}
		};
    }
}