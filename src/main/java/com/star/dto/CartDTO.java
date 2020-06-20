package com.star.dto;

import lombok.Data;

/**
 * 商品购物车信息
 */
@Data
public class CartDTO {
    /** 商品ID */
    private String productId;
    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
