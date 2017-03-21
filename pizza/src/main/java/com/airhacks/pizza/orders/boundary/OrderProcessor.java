
package com.airhacks.pizza.orders.boundary;

import com.airhacks.pizza.orders.entity.Order;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
public class OrderProcessor {

    @PersistenceContext
    EntityManager em;

    public List<Order> all() {
        return this.em.
                createNamedQuery(Order.findAll, Order.class).
                getResultList();
    }

    public void save(Order order) {
        this.em.merge(order);
    }

}
