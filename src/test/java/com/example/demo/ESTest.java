package com.example.demo;

import com.example.demo.bean.Order;
import com.example.demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhuxl on 2017/11/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ESTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
        Order order = new Order();
        order.setId(System.currentTimeMillis());
        order.setName("order ES 测试");
        order.setOrderNum(2333);
        order.setRemark("sffds水电费递四方速递");
        orderService.create(order);
    }

}
