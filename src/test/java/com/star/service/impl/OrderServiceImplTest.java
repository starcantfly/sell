package com.star.service.impl;

import com.star.dataobject.OrderDetail;
import com.star.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    OrderServiceImpl orderService;
    private final String BUYER_OPENID = "0000";
    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        OrderDetail orderDetail = new OrderDetail();

        orderDTO.setBuyerAddress("上海市浦江镇");
        orderDTO.setBuyerName("张敏");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("1234567");
        orderDetail.setProductId("1");
        orderDetail.setProductQuantity(10);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        orderService.create(orderDTO);

    }

    @Test
    void findOne() {
        OrderDTO orderDTO = orderService.findOne("1589561020297228872");
        log.info("【订单查询结果：】 result={}" ,orderDTO);
    }

    @Test
    void findList() {
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.findOne("1589561020297228872");
        orderService.cancel(orderDTO);
    }

    @Test
    void finish() {
        OrderDTO orderDTO = orderService.findOne("1589561020297228872");
        orderService.finish(orderDTO);
    }

    @Test
    void paid() {
        OrderDTO orderDTO = orderService.findOne("1589561020297228872");
        orderService.paid(orderDTO);
    }
}