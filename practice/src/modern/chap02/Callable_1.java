package modern.chap02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable 을 결과로 반환하기
 *
 * 자바 5부터 지원하는 ExecutorService
 * ExecutorService : 태스크를 스레드 풀로 보내고 결과를 Future 로 저장할 수 있음
 * Runnable 의 업그레이드 버전
 */
public class Callable_1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());
    }
}
