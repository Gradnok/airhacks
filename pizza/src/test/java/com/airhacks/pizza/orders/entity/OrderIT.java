/*
 */
package com.airhacks.pizza.orders.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class OrderIT {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void initEM() {
        this.emf = Persistence.createEntityManagerFactory("it");
        this.em = this.emf.createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @Test
    public void crud() {
        this.tx.begin();
        this.em.merge(new Order("hugo", 2));
        this.tx.commit();
    }

}
