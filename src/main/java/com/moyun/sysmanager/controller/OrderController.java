package com.moyun.sysmanager.controller;


import com.moyun.sysmanager.common.pojo.OrderDto;
import com.moyun.sysmanager.common.result.VueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author dzh
 */
@RestController
@RequestMapping("order")
public class OrderController {
    private static final String QY="http://dictapi.quming.tech/qiyename1/qiyeOrderId?orderId=";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("qy")
    public VueResult findOrderByQY(@RequestParam(value = "orderId",defaultValue = "QY2020082416483116433") String orderId){
        String id=orderId.trim();
        String orderUrl=QY+id;
        OrderDto orderDto = restTemplate.getForObject(orderUrl, OrderDto.class);
        ArrayList<Object> list = new ArrayList<>();
        list.add(orderDto.getData());
        return VueResult.success(list);
    }
}
