/*
 */
package com.airhacks.pizza.orders.boundary;

import com.airhacks.pizza.orders.control.OrderValidator;
import com.airhacks.pizza.orders.entity.Order;
import javax.persistence.EntityManager;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author airhacks.com
 */
public class OrderProcessorTest {

    private OrderProcessor cut;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void init() {
        this.cut = new OrderProcessor();
        this.cut.em = mock(EntityManager.class);
        this.cut.validator = mock(OrderValidator.class);
    }

    @Test
    public void saveValid() {
        Order actual = new Order("duke", 6);
        when(this.cut.validator.check(actual)).thenReturn(true);
        this.cut.save(actual);
        verify(this.cut.em, times(1)).merge(actual);
    }

    @Test
    public void saveInvalidValid() {
        expected.expect(IllegalStateException.class);
        expected.expectMessage(CoreMatchers.containsString("Crazy"));

        when(this.cut.validator.check(null)).thenReturn(false);
        this.cut.save(null);

    }

}
