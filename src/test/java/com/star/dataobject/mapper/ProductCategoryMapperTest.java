package com.star.dataobject.mapper;

import com.star.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","数码电子");
        map.put("category_type",1002);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }
    @Test
    public void updateByType() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","苹果电脑");
        map.put("category_type",1001);
        int result = mapper.updateByType(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType() throws Exception{
        ProductCategory result = mapper.findByCategoryType(1001);
        Assert.assertNotNull(result);
    }
}