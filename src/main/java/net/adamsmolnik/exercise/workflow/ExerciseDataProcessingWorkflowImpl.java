package net.adamsmolnik.exercise.workflow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.adamsmolnik.boundary.dataimport.ImportActivityClient;
import net.adamsmolnik.boundary.dataimport.ImportActivityClientImpl;
import net.adamsmolnik.boundary.detection.DetectionActivityClient;
import net.adamsmolnik.boundary.detection.DetectionActivityClientImpl;
import net.adamsmolnik.boundary.digest.DigestActivityClient;
import net.adamsmolnik.boundary.digest.DigestActivityClientImpl;
import net.adamsmolnik.boundary.extraction.ExtractionActivityClient;
import net.adamsmolnik.boundary.extraction.ExtractionActivityClientImpl;
import net.adamsmolnik.boundary.notification.NotificationActivityClient;
import net.adamsmolnik.boundary.notification.NotificationActivityClientImpl;
import net.adamsmolnik.model.detection.DetectionRequest;
import net.adamsmolnik.model.detection.DetectionResponse;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;

/**
 * @author ASmolnik *
 */
public class ExerciseDataProcessingWorkflowImpl implements ExerciseDataProcessingWorkflow {

    private volatile String state = "Exercise just launched";

    private final ImportActivityClient imAC = new ImportActivityClientImpl();

    private final NotificationActivityClient nAC = new NotificationActivityClientImpl();

    private final DetectionActivityClient detectionAC = new DetectionActivityClientImpl();

    private final DigestActivityClient digestAC = new DigestActivityClientImpl();

    private final ExtractionActivityClient extractionAC = new ExtractionActivityClientImpl();

    private final Map<String, String> outcomeMetadata = new HashMap<>();

    private final AmazonS3Client s3Client = new AmazonS3Client();

    private String destObjectKey;

    private String bucketName;

    @Override
    public void launch(String bucketName, String srcObjectKey, Set<ExerciseActionType> actionTypes) {
        this.bucketName = bucketName;
        this.destObjectKey = srcObjectKey;
        Promise<DetectionResponse> detectionResponse = detectionAC.detect(new DetectionRequest(srcObjectKey));
        Promise<Void> waitForFinish = processDetectionResponse(detectionResponse);
        persistOutcomeMetadata(waitForFinish);
    }

    @Asynchronous
    private void setState(String state, Promise<?>... waitFor) {
        this.state = state;
    }

    @Override
    public String getState() {
        return state;
    }

    @Asynchronous
    private Promise<Void> processDetectionResponse(Promise<DetectionResponse> detectionResponse) {
        DetectionResponse dr = detectionResponse.get();
        setState("Exercise just detected");
        outcomeMetadata.put("mediaType", dr.type + "/" + dr.subType);
        return Promise.Void();
    }

    private void persistOutcomeMetadata(Promise<?> waitForFinish) {
        CopyObjectRequest cor = new CopyObjectRequest(bucketName, destObjectKey, bucketName, destObjectKey);
        ObjectMetadata omd = s3Client.getObjectMetadata(bucketName, destObjectKey);
        omd.setUserMetadata(outcomeMetadata);
        cor.setNewObjectMetadata(omd);
        s3Client.copyObject(cor);
    }

}
