package com.star.dataobject.mapper;

import com.star.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.Map;

public interface ProductCategoryMapper {

@Insert("insert into product_category(category_name,category_type) " +
        "values(#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

@Update("update product_category set category_name = #{category_name,jdbcType=VARCHAR} where category_type = #{category_type,jdbcType=INTEGER}")
    int updateByType(Map<String,Object> map);

@Select("select * from product_category where category_type= #{categoryType}")
@Results({
        @Result(column = "category_id",property = "categoryId"),
        @Result(column = "category_name",property = "categoryName"),
        @Result(column = "category_type",property = "categoryType")
})
ProductCategory findByCategoryType(Integer categoryType);
}
