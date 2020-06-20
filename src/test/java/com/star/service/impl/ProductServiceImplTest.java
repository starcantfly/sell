package com.star.service.impl;

import com.star.dataobject.ProductInfo;
import com.star.enums.ProductStatusEnum;
import com.star.repository.ProductInfoRepository;
import com.star.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    void findOne(){
        System.out.println(productService.findOne("1"));
    }

    @Test
    void findUpAll() {
        System.out.println(productService.findUpAll().get(0).toString());
    }

    @Test
    void findAll() {
        //Sort sort = Sort.by(Sort.Direction.ASC);
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<ProductInfo> pageInfo = productService.findAll(pageRequest);
        System.out.println(pageInfo.getTotalElements());
    }

    @Test
    void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2");
        productInfo.setProductName("肉夹馍");
        productInfo.setProductPrice(new BigDecimal(10.6));
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setProductStock(20);
        productInfo.setProductDescription("麻烦多加点驴肉");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setCategoryType(1);
        productService.save(productInfo);
    }
}