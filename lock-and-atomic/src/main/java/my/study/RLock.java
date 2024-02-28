package my.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RLock {
    static class Counter {
        private int count = 0;
        private Lock lock = new ReentrantLock();

        void increment() {
            lock.lock();
            try {
                count += 1;
            } finally {
                lock.unlock();
            }
        }

        int count() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(counter::increment);
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(counter.count());
    }
}
