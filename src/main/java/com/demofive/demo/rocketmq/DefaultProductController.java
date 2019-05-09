package com.demofive.demo.rocketmq;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.client.producer.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Martin on 2019/4/13.
 */

@RestController
@RequestMapping(value = "/rocketTest")
public class DefaultProductController {
    private static final Logger logger = LoggerFactory.getLogger(DefaultProductController.class);

    /**使用RocketMq的生产者*/
//    private DefaultMQProducer defaultMQProducer;

    /**
     * 发送消息
     *
     *
     * @throws Exception
     */

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public void send() throws Exception{
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer();
        String msg = "demo msg test";
        logger.info("开始发送消息："+msg);
        Message message = new Message("DemoTopic","DemoTag",msg.getBytes());
        SendResult result = defaultMQProducer.send(message);

        //默认3秒超时
        logger.info("消息发送响应信息："+result.toString());
    }
}
