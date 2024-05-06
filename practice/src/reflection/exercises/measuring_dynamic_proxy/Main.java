package reflection.exercises.measuring_dynamic_proxy;

import reflection.exercises.measuring_dynamic_proxy.external.DatabaseReader;
import reflection.exercises.measuring_dynamic_proxy.external.HttpClient;
import reflection.exercises.measuring_dynamic_proxy.external.impl.DatabaseReaderImpl;
import reflection.exercises.measuring_dynamic_proxy.external.impl.HttpClientImpl;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = createProxy(new HttpClientImpl());
        DatabaseReader databaseReader = createProxy(new DatabaseReaderImpl());

//        useHttpClient(httpClient);
        useDatabasesReader(databaseReader);
    }

    public static void useHttpClient(HttpClient httpClient) {
        httpClient.initialize();
        String response = httpClient.sendRequest("some request");

        System.out.println(String.format("Http response is : %s", response));
    }

    public static void useDatabasesReader(DatabaseReader databaseReader) throws InterruptedException {
        int rowsInGamesTable = 0;
        try {
            rowsInGamesTable = databaseReader.countRowsInTable("GamesTable");
        } catch (IOException e) {
            System.out.println("Catching exception " + e);
            return;
        }

        System.out.println(String.format("There are %s rows in GamesTable", rowsInGamesTable));

        String[] data = databaseReader.readRow("SELECT * FROM GamesTable");

        System.out.println(String.format("Received %s", String.join(" , ", data)));
    }

    public static <T> T createProxy(Object originalObject) {
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();

        TimeMeasuringProxyHandler timeMeasuringProxyHandler = new TimeMeasuringProxyHandler(originalObject);

        return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
    }

    public static class TimeMeasuringProxyHandler implements InvocationHandler {
        private final Object originalObject;

        public TimeMeasuringProxyHandler(Object originalObject) {
            this.originalObject = originalObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;
            System.out.println(String.format("Measuring Proxy - Before Executing method : %s()", method.getName()));

            long startTime = System.currentTimeMillis();
            try {
                result = method.invoke(originalObject, args);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            }
            long endTime = System.currentTimeMillis();

            System.out.println();
            System.out.println(String.format("Measuring Proxy - Execution of %s() took %dms \n", method.getName(), endTime - startTime));

            return result;
        }
    }
}
