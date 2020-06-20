package com.star.service;

import com.star.dataobject.ProductInfo;
import com.star.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    /** 查询单一商品信息 */
    ProductInfo findOne(String productId);

    /** 查询所有商品信息 */
    List<ProductInfo> findUpAll();

    /** 查询所有上架商品 */
    Page<ProductInfo> findAll(Pageable pageable);

    /** 保存商品信息 */
    ProductInfo save(ProductInfo productInfo);

    /** 加库存 */
    void increaseStock(List<CartDTO> cartDTOList);

    /** 减库存 */
    void decreaseStock(List<CartDTO> cartDTOList);
}
