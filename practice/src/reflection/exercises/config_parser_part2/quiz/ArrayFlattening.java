package reflection.exercises.config_parser_part2.quiz;
import java.util.*;
import java.lang.reflect.*;

public class ArrayFlattening {

    public static void main(String[] args) {
        ArrayFlattening flattening = new ArrayFlattening();
        String [] result = flattening.concat(String.class, new String[]{"a", "b"}, "c", new String[] {"d", "e"});
        System.out.println(Arrays.toString(result));
    }

    public <T> T concat(Class<?> type, Object... arguments) {

        if (arguments.length == 0) {
            return null;
        }

        ArrayList<T> result = new ArrayList<>();
        for (Object argument : arguments) {
            if (argument.getClass().isArray()) {
                for (int i = 0; i < Array.getLength(argument); i++) {
                    result.add((T) Array.get(argument, i));
                }
            } else {
                result.add((T) argument);
            }
        }

        Object arrayObject = Array.newInstance(type, result.size());
        for (int i = 0; i < result.size(); i++) {
            Array.set(arrayObject, i, result.get(i));
        }
        return (T) arrayObject;
    }
}
