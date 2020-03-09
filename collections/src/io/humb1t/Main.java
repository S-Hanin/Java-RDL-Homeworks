package io.humb1t;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> c = Collections.EMPTY_LIST;
        List<String> list = new ArrayList<>(c);

        List<Order> orders = Collections.singletonList(new Order(OrderStatus.COMPLETED, 50));
        orders.stream()
                .filter(order -> order.status == OrderStatus.COMPLETED)
                .forEach(order -> System.out.println(order.toString()));


        for (Order order : orders) {
            System.out.println(order.toString());
        }


        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next().toString());
        }


        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));

    }


    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public final OrderStatus status;

        private Integer quantity;

        public Order(OrderStatus status, Integer quantity) {
            this.status = status;
            this.quantity = quantity;
        }

        public Order(OrderStatus status){
            this(status, 0);
        }

        // TODO task2: Modify your Order class, create method which would return boolean
        //  depends on the value of numeric field (which was added in previous task)

        public boolean quantityMoreThan(int quantity){
            return this.quantity > quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public OrderStatus getStatus() {
            return status;
        }
    }
}
