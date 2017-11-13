package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xing on 2017/7/5.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queueone() {
        return new Queue("hello");
    }

    @Bean
    public Queue queuetwo() {
        return new Queue("object");
    }

}
