package reflection.exercises.polymorphism.quiz;

import java.util.*;
import java.lang.reflect.*;

public class TestingFramework {
    public void runTestSuite(Class<?> testClass) throws Throwable {
        Method[] methods = testClass.getMethods();

        Method beforeClassMethod = findMethodByName(methods, "beforeClass");

        if (beforeClassMethod != null) {
            beforeClassMethod.invoke(null);
        }

        Method setupTestMethod = findMethodByName(methods, "setupTest");

        List<Method> testMethods = findMethodsByPrefix(methods, "test");

        for (Method test : testMethods) {
            Object testObject = testClass.getDeclaredConstructor().newInstance();

            if (setupTestMethod != null) {
                setupTestMethod.invoke(testObject);
            }
            test.invoke(testObject);
        }

        Method afterClassMethod = findMethodByName(methods, "afterClass");
        if (afterClassMethod != null) {
            afterClassMethod.invoke(null);
        }
    }

    /**
     * Helper method to find a method by name
     * Returns null if a method with the given name does not exist
     */
    private Method findMethodByName(Method[] methods, String name) {
        for (Method method : methods) {
            if (method.getName().equals(name)
                    && method.getParameterCount() == 0
                    &&  method.getReturnType() == void.class) {

                return method;
            }
        }
        return null;
    }

    /**
     * Helper method to find all the methods that start with the given prefix
     */
    private List<Method> findMethodsByPrefix(Method[] methods, String prefix) {
        List<Method> matchedMethods = new ArrayList<>();

        for (Method method : methods){
            if (method.getName().startsWith(prefix)
                    && method.getParameterCount() == 0
                    &&  method.getReturnType() == void.class) {

                matchedMethods.add(method);
            }
        }
        return matchedMethods;
    }
}
