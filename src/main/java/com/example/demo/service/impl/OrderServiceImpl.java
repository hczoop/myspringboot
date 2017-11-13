package com.example.demo.service.impl;

import com.example.demo.bean.Order;
import com.example.demo.repository.OrderEsRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxl on 2017/11/6.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderEsRepository orderEsRepository;

    @Override
    public Order create(Order order) {
        if (null == order){
            return null;
        }
        return orderEsRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderEsRepository.findOne(id);
    }

    @Override
    public void deleteById(Long id) {
        orderEsRepository.delete(id);
    }

    @Override
    public void delete(Order order) {
        orderEsRepository.delete(order);
    }

    @Override
    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        orderEsRepository.findAll().forEach(item->list.add(item));
        return list;
    }
}
