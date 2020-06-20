package com.star.repository;

import com.star.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findOneTest(){
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1);
        System.out.println(productCategory.toString());
    }
    @Test
    public void insertTest(){
    ProductCategory productCategory = new ProductCategory();
    productCategory.setCategoryId(1);
    productCategory.setCategoryName("学生最爱1");
    productCategory.setCategoryType(10);
     //   productCategoryRepository.findById(1);
    productCategoryRepository.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List list = Arrays.asList(1,2,3);
        List list1 =  productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,list1);
    }
}