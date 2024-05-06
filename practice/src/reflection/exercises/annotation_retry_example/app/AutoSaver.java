package reflection.exercises.annotation_retry_example.app;


import reflection.exercises.annotation_retry_example.annotations.InitializerClass;
import reflection.exercises.annotation_retry_example.annotations.InitializerMethod;

@InitializerClass
public class AutoSaver {

    @InitializerMethod
    public void startAutoSavingThreads() {
        System.out.println("Start automatic data saving to disk");
    }
}
