package com.example.demo.rabbitmq;

import com.example.demo.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送者
 * 点对点模式，先设置Queue队列
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String str) {
        this.rabbitTemplate.convertAndSend("hello", "hello " + str);
    }

    //发送对象
    public void sendObject(User user) {
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend("object", user);
    }

    //发送集合
    public void sendList() {
        List list = new ArrayList();
        list.add("12121");
        list.add("sfsdfdsfsdf");
        list.add("rabbitmq 测试消息");
        this.rabbitTemplate.convertAndSend("object", list);
    }

}
