
package com.airhacks.pizza.orders.boundary;

import com.airhacks.pizza.orders.entity.Order;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author airhacks.com
 */
public class OrderProcessor {

    @PostConstruct
    public void init() {
        System.out.println("-------order processor.init");
    }


    public List<Order> all() {
        return Arrays.asList(new Order("hot", 1), new Order("sweet", 2));
    }

}
