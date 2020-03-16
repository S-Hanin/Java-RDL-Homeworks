package person.hanin.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Runnable task1 = () -> {
            EagerInitSingleton s = EagerInitSingleton.instance;
            System.out.println(s);
        };
        IntStream.range(0, 3).forEach(x -> pool.execute(task1));

        TimeUnit.MILLISECONDS.sleep(10);

        Runnable task2 = () -> {
            LazyInitSingleton s = LazyInitSingleton.getInstance();
            System.out.println(s);
        };
        IntStream.range(0, 3).forEach(x -> pool.execute(task2));
        pool.shutdown();
    }
}
