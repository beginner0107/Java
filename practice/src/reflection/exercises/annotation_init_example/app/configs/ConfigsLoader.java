package reflection.exercises.annotation_init_example.app.configs;


import reflection.exercises.annotation_init_example.annotations.InitializerClass;
import reflection.exercises.annotation_init_example.annotations.InitializerMethod;

@InitializerClass
public class ConfigsLoader {

    @InitializerMethod
    public void loadAllConfigs() {
        System.out.println("Loading all configuration files");
    }
}
