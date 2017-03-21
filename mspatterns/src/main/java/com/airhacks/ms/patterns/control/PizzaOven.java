
package com.airhacks.ms.patterns.control;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Singleton
@Interceptors(Sicherung.class)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class PizzaOven {

    public String fire() {
        throw new IllegalStateException("oven exploded");
    }


}
