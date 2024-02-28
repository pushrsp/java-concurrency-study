package my.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVar {
    static class Counter {
        private AtomicInteger count = new AtomicInteger();

        void increment() {
            count.incrementAndGet();
        }

        int count() {
            return count.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(counter::increment);
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(counter.count());
    }
}
