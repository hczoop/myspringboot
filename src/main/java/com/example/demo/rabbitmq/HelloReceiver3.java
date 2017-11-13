package com.example.demo.rabbitmq;

import com.example.demo.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接收者对象,自动监听消息
 */
@Component
@RabbitListener(queues = "object")
public class HelloReceiver3 {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object : " + user);
    }

    @RabbitHandler
    public void process(List<String> list) {
        if(list != null){
            for(String str:list){
                System.out.println("Receiver List : " + str);
            }
        }
    }

}
