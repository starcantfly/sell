package com.star.service.impl;

import com.star.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl categoryService;

    @Test
    void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        System.out.println(productCategory.toString());
        //Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        for(ProductCategory productCategory:list){
            System.out.println(productCategory.toString());
        }
    }

    @Test
    void findByCategoryTypeIn() {
        List list = Arrays.asList(1,2,3);
        List result = categoryService.findByCategoryTypeIn(list);
        for(Object productCategory : result){
            System.out.println((ProductCategory)productCategory);
        }
    }

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory("男生最爱",3);
        categoryService.save(productCategory);
    }
}