package my.study;

public class MyThread {
    static class ThreadExample extends java.lang.Thread {
        ThreadExample() {
            super("ThreadExample");
        }

        @Override
        public void run() {
            System.out.println("Inside: " + java.lang.Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("Inside: " + java.lang.Thread.currentThread().getName());

        System.out.println("Creating thread...");
        java.lang.Thread thread = new ThreadExample();

        System.out.println("Starting thread...");
        thread.start();
    }
}
