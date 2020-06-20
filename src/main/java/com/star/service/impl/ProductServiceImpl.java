package com.star.service.impl;

import com.star.dataobject.ProductInfo;
import com.star.dto.CartDTO;
import com.star.enums.ProductStatusEnum;
import com.star.enums.ResultEnum;
import com.star.exception.SellException;
import com.star.repository.ProductInfoRepository;
import com.star.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList){
            ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).get();
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
      for (CartDTO cartDTO : cartDTOList){
          ProductInfo productInfo = productInfoRepository.findById(cartDTO.getProductId()).get();
          if (productInfo == null){
              throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
          }
          Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
          if (result < 0){
              throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
          }
          productInfo.setProductStock(result);
          productInfoRepository.save(productInfo);
      }
    }
}
