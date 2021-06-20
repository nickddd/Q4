package com.example.demo.controller;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.ServiceMapper;
import com.example.demo.mapper.SubscriptionMapper;
import com.example.demo.model.SubscriptionExample;
import com.example.demo.model.SubscriptionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class SubscribeController {
    @Autowired
    private SubscriptionMapper subscriptionMapper;

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public String subscribe(int customer_id, int service_id) {
        SubscriptionKey subscription = new SubscriptionKey()
                .withCustomerId(customer_id)
                .withServiceId(service_id);
        int res = 0;
        try {
            res = subscriptionMapper.insert(subscription);
        } catch (Exception e) {

        }

        if (res > 0) {
            return "Customer " + customer_id + " subscribe service " + service_id + " successfully";
        }
        return "Customer " + customer_id + " failed subscribing service " + service_id;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/unsubscribe", method = RequestMethod.POST)
    public String unsubscribe(int customer_id, int service_id) {

        SubscriptionKey subscription = new SubscriptionKey().withServiceId(service_id).withCustomerId(customer_id);
        int res = 0;
        try {
            res = subscriptionMapper.deleteByPrimaryKey(subscription);
        } catch (Exception e) {

        }
        if (res > 0) {
            return "Customer " + customer_id + " unsubscribe service " + service_id + " successfully";
        }
        return "Customer " + customer_id + " failed unsubscribing service " + service_id;
    }

}
