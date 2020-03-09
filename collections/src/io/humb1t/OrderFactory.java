package io.humb1t;

import io.humb1t.Main.Order;
import io.humb1t.Main.OrderStatus;

// TODO task3: Create new interface called OrderFactory.
//  Interface should provide methods for creation of Orders
//  with different OrderStatuses.
//  For each status create default method.
//  What method should provide implementation of this interface?
//  Write your own implementation.
public interface OrderFactory {
    default Order createOrderNotStarted(){
        return new Order(OrderStatus.NOT_STARTED);
    }

    default Order createOrderProcessing(){
        return new Order(OrderStatus.PROCESSING);
    }

    default Order createOrderCompleted(){
        return new Order(OrderStatus.COMPLETED);
    }
}
