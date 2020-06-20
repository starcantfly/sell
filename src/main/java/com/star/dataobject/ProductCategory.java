package com.star.dataobject;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/*
有data注解，可以不用写get,set和toString方法
*/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    /** 类目id */
    @Id
    //@GeneratedValue
    //这个注解没有参数的话，数据库中的主键自增长会报错
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名称 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
