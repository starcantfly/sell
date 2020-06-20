package com;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.management.snmp.util.MibLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@Data
public class LoggerTest {

     private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void Test1() {
        String name = "admin";
        String password = "12345";
        logger.info("name:"+name+"password:"+password);
        logger.info("name:{},password:{}",name,password);
        logger.error("error.......");
        logger.debug("debug......");
    }
}
