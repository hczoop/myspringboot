package com.example.demo.service;

import com.example.demo.bean.Order;

import java.util.List;

/**
 * Created by zhuxl on 2017/11/6.
 */
public interface OrderService {
    Order create(Order order);

    Order findById(Long id);

    void deleteById(Long id);

    void delete(Order order);

    List<Order> findAll();
}
