
package com.airhacks.pizza.orders.boundary;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("orders")
public class OrdersResource {

    @GET
    public JsonArray all() {
        System.out.println("--- request!");
        try (JsonReader jsonReader = Json.createReader(this.getClass().getResourceAsStream("/orders.json"))) {
            return jsonReader.readArray();
        }
    }


}
