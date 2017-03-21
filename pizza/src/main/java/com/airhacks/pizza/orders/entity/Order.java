
package com.airhacks.pizza.orders.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author airhacks.com
 */
@Table(name = "pizza_order")
@Entity
@NamedQuery(name = Order.findAll, query = "SELECT o FROM Order o")
public class Order {

    public final static String findAll = "com.airhacks.pizza.orders.entity.Order.findAll";

    @Id
    @GeneratedValue
    private long orderId;
    @Column(name = "description")
    private String desc;
    private int amount;


    public Order(String desc, int amount) {
        this.desc = desc;
        this.amount = amount;
    }

    public Order(JsonObject input) {
        this.desc = input.getString("desc");
        this.amount = input.getInt("amount");
    }

    public Order() {
    }

    public String getDesc() {
        return desc;
    }

    public int getAmount() {
        return amount;
    }


    public JsonObject toJson() {
        return Json.createObjectBuilder().
                add("desc", this.desc).
                add("amount", this.amount).
                build();
    }


}
