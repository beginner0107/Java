package reflection.exercises.database_model.init;

import reflection.exercises.database_model.game.Game;
import reflection.exercises.database_model.game.internal.TicTacToeGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Game game = createObjectRecursively(TicTacToeGame.class);
        game.startGame();
    }

    public static <T> T createObjectRecursively(Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = getFirstConstructor(clazz);

        List<Object> constructorArguments = new ArrayList<>();

        for (Class<?> argumentType : constructor.getParameterTypes()) {
            Object argumentValue = createObjectRecursively(argumentType);
            constructorArguments.add(argumentValue);
        }

        constructor.setAccessible(true);
        return (T) constructor.newInstance(constructorArguments.toArray());
    }

    public static Constructor<?> getFirstConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors(); // 생성자 목록이 넘어온다
        if (constructors.length == 0) {
            throw new IllegalStateException("No constructor has been found for class %s".formatted(clazz.getName()));
        }
        return constructors[0];
    }
}