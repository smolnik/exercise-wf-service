package net.adamsmolnik.exercise.workflow.local;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.adamsmolnik.exercise.workflow.ExerciseActionType;
import net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflowClientExternal;
import net.adamsmolnik.exercise.workflow.ExerciseDataProcessingWorkflowClientExternalFactoryImpl;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

/**
 * @author ASmolnik
 *
 */
public class ExerciseWorkflowClient {

    public static void main(String[] args) throws Exception {
        AmazonS3Client s3Client = new AmazonS3Client();
        String bucketName = "student100";
        String srcObjectKey = "external/awsugpl.zip";
        s3Client.putObject(bucketName, srcObjectKey, new File("C:/temp/awsugpl.zip"));

        ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70 * 1000);
        AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(config);
        service.setEndpoint("https://swf.us-east-1.amazonaws.com");
        String domain = "student100";
        ExerciseDataProcessingWorkflowClientExternal client = new ExerciseDataProcessingWorkflowClientExternalFactoryImpl(service, domain)
                .getClient();
        Set<ExerciseActionType> actionTypes = new HashSet<>();
        actionTypes.add(ExerciseActionType.IMPORT);
        actionTypes.add(ExerciseActionType.DIGEST);
        actionTypes.add(ExerciseActionType.EXTRACT);
        client.launch(bucketName, srcObjectKey, actionTypes);
        TimeUnit.SECONDS.sleep(20);
        System.out.println("state = " + client.getState());
        TimeUnit.SECONDS.sleep(300);
    }

}