package person.hanin;

import io.humb1t.Main.Order;
import io.humb1t.Main.OrderStatus;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        task5();
    }

    private static void task1() {
        List<Order> orders = Collections.singletonList(new Order(OrderStatus.COMPLETED, 50));
        /*
         * Наиболее очевидное решение, просто читать,
         * легко понять намерения автора.
         * Все паттерны перебора коллекции скрыты "под капотом",
         * остаются только операции, которые нужно провести над коллекцией
         */
        orders.stream()
                .filter(order -> order.status == OrderStatus.COMPLETED)
                .forEach(order -> System.out.println(order.toString()));

        /*
         * Тоже простое решение для перебора, паттерн "итератор" скрыт
         * конструкцией цикла.
         * Однако, если бы нужно было отфильтровать коллекцию, пришлось бы
         * создать новую коллекцию и использовать условия if или switch.
         * Решение получилось бы более громоздким по сравнению с решением через stream
         */
        for (Order order : orders) {
            System.out.println(order.toString());
        }

        /*
         * Явная логика получения следующего элемента
         */
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next().toString());
        }


        /*
         * Очень здорово, что для таких операций сделали stream api.
         * Для реализации группировки через цикл пришлось бы написать
         * в несколько раз больше кода.
         */
        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }

    private static void task2() {
        List<io.humb1t.Main.Order> orders = Arrays.asList(
                new Order(OrderStatus.COMPLETED, 50),
                new Order(OrderStatus.PROCESSING, 40),
                new Order(OrderStatus.COMPLETED, 30));

        List<io.humb1t.Main.Order> ordersTopCount = orders.stream()
                .filter(order -> order.getQuantity() > 40)
                .collect(Collectors.toList());

        ordersTopCount.forEach(System.out::println);
    }

    private static void task3() {
        /*
         * For training purposes only
         */
        Queue<Integer> requestQueue = new ConcurrentLinkedQueue<>();
        Queue<Integer> responseQueue = new ConcurrentLinkedQueue<>();

        ExecutorService exec = Executors.newCachedThreadPool();

        // request producers
        Stream.of(1, 2, 3, 4, 5).forEach(client -> exec.execute(() ->
                IntStream.range(1, 100).parallel().forEach(requestQueue::add))
        );

        // request processors
        Stream.of(1, 2, 3).forEach(processor -> exec.execute(() -> {
                    while (true) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(500L);
                            Optional<Integer> request = Optional.ofNullable(requestQueue.poll());
                            request.ifPresent(item -> responseQueue.offer(item * 2));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                })
        );

        // response printer
        exec.execute(() -> {
            while (true) {
                Optional<Integer> response = Optional.ofNullable(responseQueue.poll());
                response.ifPresent(System.out::println);
            }
        });

        // kill 'em all
        Timer timer = new Timer("Exit timer");
        long delay = 30000L;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, delay);
    }

    private static void task4() {
        Collection<String> words = Arrays.asList("hello", "hello", "world");
        Collection<String> unique = words.stream().distinct().collect(Collectors.toList());
        unique.forEach(System.out::println);
    }

    private static void task5() {
        List<Integer> collection1 = new ArrayList<>();
        timeIt(collection1::add, 1_000_000, "ArrayList::add");
        timeIt(collection1::contains, 10_000, "ArrayList::contains");
        timeIt(collection1::get, 10_000, "ArrayList::get");
        timeIt(collection1::remove, 10_000, "ArrayList::remove");

        System.out.println();

        List<Integer> collection2 = new LinkedList<>();
        timeIt(collection2::add, 1_000_000, "LinkedList::add");
        timeIt(collection2::contains, 10_000, "LinkedList::contains");
        timeIt(collection2::get, 10_000, "LinkedList::get");
        timeIt(collection2::remove, 10_000, "LinkedList::remove");
    }

    private static void task6() {
        //TODO
        Map<Long, Long> cache;
    }

    private static void timeIt(IntConsumer action, int count, String name) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            action.accept(i);
        }
        System.out.println(String.format("%-20.20s %10.10s ms", name, System.currentTimeMillis() - start));

    }


}
