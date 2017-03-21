
package com.airhacks.ms.patterns.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("pizzas")
public class PizzasResource {

    @Inject
    PizzaCatalog catalog;

    @GET
    public String all() {
        return catalog.all();
    }


}
