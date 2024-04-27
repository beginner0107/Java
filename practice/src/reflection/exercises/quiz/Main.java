package reflection.exercises.quiz;

import java.util.HashMap;

// 연습
public class Main {
    public static void main(String[] args) {
        Class<String> stringObject = String.class;
        Class<?> mapObject = HashMap.class;
        Class<?> booleanObject = boolean.class;

        Class<? extends Class> stringClass = stringObject.getClass();
        System.out.println(stringClass.isPrimitive());
        System.out.println(booleanObject.isPrimitive());
        for (Class<?> clazz : stringClass.getInterfaces()) {
            System.out.println(clazz.getSimpleName());

        }
    }
}
