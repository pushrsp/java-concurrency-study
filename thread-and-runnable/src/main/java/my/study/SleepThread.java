package my.study;

public class SleepThread {
    public static void main(String[] args) {
        System.out.println("Inside: " + java.lang.Thread.currentThread().getName());
        String[] messages = {"If I can stop one heart from breaking,",
                "I shall not live in vain.",
                "If I can ease one life the aching,",
                "Or cool one pain,",
                "Or help one fainting robin",
                "Unto his nest again,",
                "I shall not live in vain"};

        Runnable runnable = () -> {
            System.out.println("Inside: " + java.lang.Thread.currentThread().getName());
            for (String m : messages) {
                System.out.println(m);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
