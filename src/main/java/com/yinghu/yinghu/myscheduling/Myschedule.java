package com.yinghu.yinghu.myscheduling;


import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Myschedule {

    @Scheduled(fixedDelay = 3000)
    void writLog(){
        System.out.println("开始");
         Logger logger = LogManager.getLogger(Myschedule.class);
         String hello = logger.getName();
         logger.info("怎么说{}{}",hello, new Date());

    }

}
