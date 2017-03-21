
package com.airhacks.ms.patterns.boundary;

import com.airhacks.ms.patterns.control.PizzaOven;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class PizzaCatalog {

    @Inject
    PizzaOven oven;

    @Inject
    Event<String> pizzaListeners;

    public String all() {
        String message = "sweet,green,pink";
        pizzaListeners.fire(message);
        return message + oven.fire();
    }

}
