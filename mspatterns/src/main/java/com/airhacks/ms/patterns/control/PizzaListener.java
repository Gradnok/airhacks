
package com.airhacks.ms.patterns.control;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author airhacks.com
 */
public class PizzaListener {

    public void onNewOrder(@Observes(during = TransactionPhase.AFTER_SUCCESS) String pizza) {
        System.out.println("-- thanks");
    }

    public void onFailedOrder(@Observes(during = TransactionPhase.AFTER_FAILURE) String pizza) {
        System.out.println("-- where is my pizza");
    }


}
