package my.study;

import java.util.concurrent.Callable;

public class CallableEx {
    public static void main(String[] args) {
        Callable<String> callable = () -> {
            Thread.sleep(2000);
            return "Return result";
        };
    }
}
