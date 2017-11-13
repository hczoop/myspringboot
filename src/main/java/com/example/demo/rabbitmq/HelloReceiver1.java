package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者1,自动监听消息
 */
@Component
@RabbitListener(queues = "hello") //当对应的队列中有消息的时候，该注解修饰下的方法会被执行
public class HelloReceiver1 {

    //接收者可以监听多个队列，
    //不同的队列消息的类型可能不同，该注解可以使得不同的消息让不同方法来响应。
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
}
