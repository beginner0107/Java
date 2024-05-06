package reflection.exercises.annotation_retry_example.app.databases;

import reflection.exercises.annotation_retry_example.annotations.InitializerClass;
import reflection.exercises.annotation_retry_example.annotations.InitializerMethod;
import reflection.exercises.annotation_retry_example.annotations.RetryOperation;

import java.io.IOException;

@InitializerClass
public class DatabaseConnection {
    private int failCounter = 5;

    @RetryOperation(
            numberOfRetries = 10,
            retryExceptions = IOException.class,
            durationBetweenRetriesMs = 1000,
            failureMessage = "Connection to database 1 failed after retries"
    )
    @InitializerMethod
    public void connectToDatabase1() throws IOException {
        System.out.println("Connecting to database 1");
        if (failCounter > 0) {
            failCounter --;
            throw new IOException("Connection failed");
        }
        System.out.println("Connection to database 1 succeeded");
    }

    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("Connecting to database 2");
    }
}
