package reflection.exercises.annotation_init_example.app.http;

import reflection.exercises.annotation_init_example.annotations.InitializerClass;
import reflection.exercises.annotation_init_example.annotations.InitializerMethod;

@InitializerClass
public class ServiceRegistry {

    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }
}
