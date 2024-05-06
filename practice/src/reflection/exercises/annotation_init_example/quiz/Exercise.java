package reflection.exercises.annotation_init_example.quiz;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class Exercise {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface OpenResources {
    }

    public Set<Method> getAllAnnotatedMethods(Object input) {
        Set<Method> annotatedMethods = new HashSet<>();

        Method[] methods = input.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(OpenResources.class)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
