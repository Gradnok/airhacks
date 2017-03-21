
package com.airhacks.ms.patterns.boundary;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Stateless
@Path("pizzas")
public class PizzasResource {

    @Inject
    PizzaCatalog catalog;

    @Resource
    ManagedExecutorService mes;

    @GET
    public void all(@Suspended AsyncResponse response) {
        response.setTimeout(2, TimeUnit.SECONDS);
        supplyAsync(this.catalog::all, mes).
                thenApply(this::decorate).
                thenAccept(response::resume);
    }

    String decorate(String input) {
        return "+++ " + input + "++++";
    }


}
