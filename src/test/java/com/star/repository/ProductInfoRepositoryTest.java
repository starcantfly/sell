package com.star.repository;

import com.star.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    void findOne(){
       ProductInfo productInfo = productInfoRepository.getOne("1");
        System.out.println(productInfo.toString());
    }

    @Test
    void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("凉皮");
        productInfo.setProductPrice(new BigDecimal(6.6));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(10);
        productInfo.setProductDescription("加点黄瓜更好吃");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setCategoryType(1);
        productInfoRepository.save(productInfo);
    }

    @Test
    void findByProductStatus() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        for (ProductInfo productInfo : list){
            System.out.println(productInfo.toString());
        }
    }
}