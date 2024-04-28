package reflection.exercises.fields_introduction.init.quiz;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Field[] declaredFields = Class.forName("reflection.exercises.fields_introduction.init.quiz.Employee$Builder$EmployeeImpl").getDeclaredFields();
        System.out.println("quiz!");
    }
}
