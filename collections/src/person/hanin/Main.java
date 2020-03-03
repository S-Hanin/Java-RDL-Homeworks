package person.hanin;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import io.humb1t.Main.Order;
import io.humb1t.Main.OrderStatus;


public class Main {
    public static void main(String[] args) {
        task5();
    }

    private void task2(){
        List<io.humb1t.Main.Order> orders = Arrays.asList(
                new Order(OrderStatus.COMPLETED, 50),
                new Order(OrderStatus.PROCESSING, 40),
                new Order(OrderStatus.COMPLETED, 30));

        List<io.humb1t.Main.Order> ordersTopCount = orders.stream()
                .filter(order -> order.getQuantity() > 40)
                .collect(Collectors.toList());

        ordersTopCount.forEach(System.out::println);
    }

    private void task3(){

    }

    private void task4(){
        Collection<String> words = Arrays.asList("hello", "hello", "world");
        Collection<String> unique = words.stream().distinct().collect(Collectors.toList());
        unique.forEach(System.out::println);
    }

    private static void task5(){
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

    private void task6(){

    }

    private static void timeIt(Consumer<Integer> action, int count, String name){
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            action.accept(i);
        }
        System.out.println(String.format("%-20.20s %10.10s ms", name, System.currentTimeMillis() - start));

    }


}
