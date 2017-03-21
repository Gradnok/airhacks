
package com.airhacks.ms.patterns.boundary;

import com.airhacks.ms.patterns.control.PizzaOven;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class PizzaCatalog {

    @Inject
    PizzaOven oven;

    public String all() {

        return "sweet,green,pink" + oven.fire();
    }

}
