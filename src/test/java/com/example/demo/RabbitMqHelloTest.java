package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.rabbitmq.HelloSender;
import com.example.demo.rabbitmq.fanout.FanoutSender;
import com.example.demo.rabbitmq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xing on 2017/7/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void helloSenderTest() throws Exception {
        helloSender.send("测试rabbitmq的消息");
        /*while (true){
        }*/
    }

    /**
     * 一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
     * @throws Exception
     */
    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            helloSender.send(i+"");
        }
    }


    /**
     * 测试发送对象
     * @throws Exception
     */
    @Test
    public void senderObjectTest() throws Exception {
        User user = new User(12l,"rabbitmq object",33);
        helloSender.sendObject(user);
        /*while (true){
        }*/
    }

    /**
     * 测试发送集合
     * @throws Exception
     */
    @Test
    public void senderListTest() throws Exception {
        helloSender.sendList();
        /*while (true){
        }*/
    }

    /**
     * 测试topic
     * @throws Exception
     */
    @Test
    public void senderTopicTest() throws Exception {
        //只有Receiver2监听到消息，但topic.1不存在也可以匹配到，因为topic.#
        topicSender.send();
        //会匹配到topic.#和topic.message 两个Receiver都可以收到消息
        topicSender.send1();
        //只有topic.#可以匹配所有只有Receiver2监听到消息
        topicSender.send2();
    }

    /**
     * 测试Fanout
     * 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * @throws Exception
     */
    @Test
    public void senderFanoutTest() throws Exception {
        fanoutSender.send();
    }



}
