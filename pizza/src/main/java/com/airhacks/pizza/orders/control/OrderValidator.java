
package com.airhacks.pizza.orders.control;

import com.airhacks.pizza.orders.entity.Order;

public class OrderValidator {

    public boolean check(Order order) {
        return (order.getAmount() > 5);
    }


}
