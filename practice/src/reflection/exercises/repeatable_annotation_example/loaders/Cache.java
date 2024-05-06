package reflection.exercises.repeatable_annotation_example.loaders;


import reflection.exercises.repeatable_annotation_example.annotations.Annotations;

@Annotations.ScheduledExecutorClass
public class Cache {

    @Annotations.ExecuteOnSchedule(periodSeconds = 5)
    @Annotations.ExecuteOnSchedule(delaySeconds = 10, periodSeconds = 1)
    public static void reloadCache() {
        System.out.println("Reloading cache");
    }
}
