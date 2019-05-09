package com.demofive.demo.rocketmq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
/**
 * Created by Martin on 2019/4/13.
 */
//@SpringBootConfiguration
@PropertySource( "classpath:application.properties" )
@Component
public class MQProducerConfiguration {
    public static final Logger LOGGER = LoggerFactory.getLogger(MQProducerConfiguration.class);
    /**
     * 发送同一类消息的设置为同一个group，保证唯一,默认不需要设置，rocketmq会使用ip@pid(pid代表jvm名字)作为唯一标示
     */
//    @Value("${application:apache.rocketmq.producer.producerGroup}")
    private String groupName ="Producer";
//    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
    /**
     * 消息最大大小，默认4M
     */
//    @Value("rocketmq.producer.maxMessageSize")
    private int maxMessageSize =4096;
    /**
     * 消息发送超时时间，默认3秒
     */
//    @Value("${application:rocketmq.producer.sendMsgTimeout}")
    private int sendMsgTimeout = 3000;
    /**
     * 消息发送失败重试次数，默认2次
     */
//    @Value("rocketmq.producer.retryTimesWhenSendFailed")
    private int retryTimesWhenSendFailed =2;

    @Bean
    public DefaultMQProducer getRocketMQProducer() {
//        if (StringUtils.isEmpty(this.groupName)) {
//            throw new RocketMQException(RocketMQErrorEnum.PARAMM_NULL,"groupName is blank",false);
//        }
//        if (StringUtils.isEmpty(this.namesrvAddr)) {
//            throw new RocketMQException(RocketMQErrorEnum.PARAMM_NULL,"nameServerAddr is blank",false);
//        }
        DefaultMQProducer producer;
        producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(this.namesrvAddr);
        //如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
        //producer.setInstanceName(instanceName);

        producer.setMaxMessageSize(this.maxMessageSize);
        producer.setSendMsgTimeout(this.sendMsgTimeout);
        //如果发送消息失败，设置重试次数，默认为2次
        producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);

        try {
            producer.start();

            LOGGER.info(String.format("producer is start ! groupName:[%s],namesrvAddr:[%s]"
                    , this.groupName, this.namesrvAddr));
        } catch (Exception e) {
            LOGGER.error(String.format("producer is error {}"
                    , e.getMessage(),e));
//            throw new RocketMQException(e);
        }
        return producer;
    }
}