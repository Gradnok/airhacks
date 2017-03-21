
package com.airhacks.pizza.orders.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.GET;
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


    @GET
    public JsonArray all() {
        System.out.println("--- requested!");
        try (JsonReader jsonReader = Json.createReader(this.getClass().getResourceAsStream("/orders.json"))) {
            return jsonReader.readArray();
        }
    }


}
