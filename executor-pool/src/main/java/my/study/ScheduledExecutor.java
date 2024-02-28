package my.study;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable t1 = () -> System.out.println("Executing task at " + System.nanoTime());

        System.out.println("Submitting task at " + System.nanoTime());
        scheduledExecutorService.scheduleAtFixedRate(t1, 0, 2, TimeUnit.SECONDS);
    }
}
