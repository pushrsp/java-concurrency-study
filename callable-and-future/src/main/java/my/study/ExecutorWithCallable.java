package my.study;

import java.util.concurrent.*;

public class ExecutorWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        while (!future.isDone()) {
            System.out.println("Task is not done yet");
            Thread.sleep(200);
        }

        System.out.println(future.get());

        executorService.shutdown();
    }
}
