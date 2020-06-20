package com.star.repository;

import com.star.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {
    @Autowired
    OrderMasterRepository orderMasterRepository;
    private final String OPENID = "0000";
    @Test
    void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("上海市浦东新区");
        orderMaster.setBuyerName("月亮不会飞");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("1234567");
        orderMaster.setOrderAmount(new BigDecimal(88));
        orderMaster.setOrderId("2");
        orderMasterRepository.save(orderMaster);
    }

    @Test
    void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0,1);
        Page<OrderMaster> page = orderMasterRepository.findByBuyerOpenid(OPENID,pageRequest);
        System.out.println(page.getTotalElements());
    }
}