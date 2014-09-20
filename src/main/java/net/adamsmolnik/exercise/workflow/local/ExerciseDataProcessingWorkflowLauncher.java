package net.adamsmolnik.exercise.workflow.local;

import java.util.concurrent.TimeUnit;
import net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflowImpl;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

/**
 * @author ASmolnik
 *
 */
public class ExerciseDataProcessingWorkflowLauncher {

    public static void main(String[] args) throws Exception {
        ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70 * 1000);
        AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(config);
        service.setEndpoint("https://swf.us-east-1.amazonaws.com");
        String domain = "student100";
        String taskListToPoll = "student100ExerciseWorkflowTasks";
        WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
        wfw.addWorkflowImplementationType(ExerciseDataProcessingWorkflowImpl.class);
        wfw.start();
        TimeUnit.SECONDS.sleep(300);
    }

}
