package com.yinghu.yinghu.scheduled;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/**
 * @ClassName ScheduledTest
 * @Description TODO
 * @Author whz
 * @Date 2023/3/23 11:05
 * Version 1.0
 **/
@Component
@RabbitListener(queues = "testQueue")
public class ScheduledTest {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    RestTemplate restTemplate;


    //@Scheduled(cron = "*/1 * * * * ?")
    public void test(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("111","111");
        map.put("112","112");
        map.put("113","113");
        String kk[]={"111","222"};
        redisTemplate.opsForHash().put("order","1",map.toString());
        redisTemplate.opsForSet().add("kk",kk);
        redisTemplate.opsForList().leftPushAll("list",kk);
        redisTemplate.opsForValue().set("String","String");
        //redisTemplate.opsForStream()

        System.out.println("1111");
        //String kk1 = redisTemplate.opsForList().leftPop("kk");


    }




    public void test2(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("111","111");
        map.put("112","112");
        map.put("113","113");
        //rabbitTemplate.convertAndSend("test","testQueue",map);

    }


    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }


    //日志生成项
    //每格1分钟生成3个请求，生成的日志有报错，有异常，有正常的
    @Scheduled(cron = "*/5 * * * * ?")
    public void requestLog(){
        String url="http://localhost:8080/test/testLog";
      restTemplate.postForObject(url,"123",String.class,new HashMap<>());
    }



}
