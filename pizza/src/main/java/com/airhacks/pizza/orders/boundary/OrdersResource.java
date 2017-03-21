
package com.airhacks.pizza.orders.boundary;

import com.airhacks.pizza.orders.entity.Order;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("orders")
public class OrdersResource {

    @Inject
    OrderProcessor processor;

    @PostConstruct
    public void init() {
        System.out.println("--- OrdersResource initialized");
    }

    @POST
    public void save(JsonObject order) {
        this.processor.save(new Order(order));
    }


    @GET
    public JsonArray all() {
        JsonArrayBuilder retVal = Json.createArrayBuilder();
        List<Order> orders = this.processor.all();
        orders.stream().
                map(Order::toJson).
                forEach(j -> retVal.add(j));
        return retVal.build();
    }


}
