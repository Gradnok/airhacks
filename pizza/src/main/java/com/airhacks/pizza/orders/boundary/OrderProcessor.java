
package com.airhacks.pizza.orders.boundary;

import com.airhacks.pizza.orders.control.OrderValidator;
import com.airhacks.pizza.orders.entity.Order;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
public class OrderProcessor {

    @PersistenceContext
    EntityManager em;

    @Inject
    OrderValidator validator;

    public List<Order> all() {
        return this.em.
                createNamedQuery(Order.findAll, Order.class).
                getResultList();
    }

    public void save(Order order) {
        if (!validator.check(order)) {
            throw new IllegalStateException("Crazy order");
        }
        this.em.merge(order);
    }

}
