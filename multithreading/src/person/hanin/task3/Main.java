package person.hanin.task3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // Special value to mark the end of producer work, cause
        // we should stop consumer work when data stream ends.
        // This technique good only with known consumers amount
        int POISON = -1;

        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    queue.put(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            try {
                queue.put(POISON);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int value = queue.take();
                    if (value == POISON) break;
                    System.out.println(value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        pool.execute(producer);
        pool.execute(consumer);
        pool.shutdown();
    }
}
