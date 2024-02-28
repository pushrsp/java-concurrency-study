package my.study;

public class JoinThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Entered Thread 1");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Exiting Thread 1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Entered Thread 2");

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Exiting Thread 2");
        });

        System.out.println("Starting Thread 1");
        t1.start();

        System.out.println("Waiting for Thread 1 to complete");
        try {
            t1.join(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("String Thread 2");
        t2.start();
    }
}
