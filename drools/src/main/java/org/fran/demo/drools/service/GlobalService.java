package org.fran.demo.drools.service;

import org.fran.demo.drools.fact.Order;

import java.util.UUID;

/**
 * @author qiushi
 * @date 2023/3/16
 */
public class GlobalService {
    public String getOrder(Order order){
        int id = order.getAmount() + order.getScore();
        return "orderId:" + UUID.randomUUID().toString() + id;
    }
}
