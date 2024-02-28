package my.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleJob {
    public static void main(String[] args) {
        System.out.println("Inside: " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with 2 threads");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable t1 = () -> {
            System.out.println("Executing t1 inside: " + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable t2 = () -> {
            System.out.println("Executing t2 inside: " + Thread.currentThread().getName());

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable t3 = () -> {
            System.out.println("Executing t3 inside: " + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        System.out.println("Submitting tasks");
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);

        executorService.shutdown();
    }
}
