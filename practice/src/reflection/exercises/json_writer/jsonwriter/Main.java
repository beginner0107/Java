package reflection.exercises.json_writer.jsonwriter;

import reflection.exercises.json_writer.data.*;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Address address = new Address("Main Street", (short) 1);
        Company company = new Company("Happy", "San Francisco", new Address("Harrison Street", (short) 600));
        Person person = new Person("John", true, 29, 100.555f, address, company);

        String json = objectToJson(person, 0);

        System.out.println(json);

        Actor actor1 = new Actor("Elijah Wood", new String[]{"Lord of Rings", "The Good Son"});
        Actor actor2 = new Actor("홍길동", new String[]{"Lord of Rings", "The Good Son"});
        Actor actor3 = new Actor("김철수", new String[]{"Lord of Rings", "The Good Son"});

        Movie movie = new Movie("Lord of the Rings", 8.8f, new String[]{"Action", "Adventure", "Drama"}
                , new Actor[]{actor1, actor2, actor3}
                , new String[][]{{"하하", "호호"}, {"히히", "쿠쿠"}});

        String json1 = objectToJson(movie, 0);
        System.out.println(json1);
    }

    public static String objectToJson(Object instance, int indentSize) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(indent(indentSize));
        stringBuilder.append("{");
        stringBuilder.append("\n");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (field.isSynthetic()) {
                continue;
            }

            stringBuilder.append(indent(indentSize + 1));
            stringBuilder.append(formatStringValue(field.getName()));

            stringBuilder.append(":");

            if (field.getType().isPrimitive()) {
                stringBuilder.append(formatPrimitiveValue(field.get(instance), field.getType()));
            } else if (field.getType().equals(String.class)) {
                stringBuilder.append(formatStringValue(field.get(instance).toString()));
            } else if (field.getType().isArray()) {
                stringBuilder.append(arrayToJson(field.get(instance), indentSize + 1));
            } else {
                stringBuilder.append(objectToJson(field.get(instance), indentSize));
            }

            if (i != fields.length - 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(indent(indentSize));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static String arrayToJson(Object arrayInstance, int indentSize) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();

        int arrayLength = Array.getLength(arrayInstance);

        Class<?> componentType = arrayInstance.getClass().getComponentType();

        stringBuilder.append(indent(indentSize));
        stringBuilder.append("[");
        stringBuilder.append("\n");

        for (int i = 0; i < arrayLength; i++) {
            Object element = Array.get(arrayInstance, i);

            if (componentType.isPrimitive()) {
                stringBuilder.append(indent(indentSize + 1));
                stringBuilder.append(formatPrimitiveValue(element, componentType));
            } else if (componentType.isArray()) {
              stringBuilder.append(arrayToJson(element, indentSize + 1));
            } else if (componentType.equals(String.class)) {
                stringBuilder.append(indent(indentSize + 1));
                stringBuilder.append(formatStringValue(element.toString()));
            } else {
                stringBuilder.append(objectToJson(element, indentSize + 1));
            }

            if (i != arrayLength - 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(indent(indentSize));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String indent(int indentSize) {
        return "\t".repeat(Math.max(0, indentSize));
    }

    private static String formatPrimitiveValue(Object instance, Class<?> type) throws IllegalAccessException {
        if (type.equals(boolean.class)
                || type.equals(int.class)
                || type.equals(long.class)
                || type.equals(short.class)) {
            return instance.toString();
        } else if (type.equals(double.class) || type.equals(float.class)){
            return String.format("%.02f", instance);
        }
        throw new RuntimeException(String.format("Type : %s is unsupported", type.getTypeName()));
    }

    private static String formatStringValue(String value) {
        return String.format("\"%s\"", value);
    }
}
