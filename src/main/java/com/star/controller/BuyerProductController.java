package com.star.controller;

import com.star.VO.ProductInfoVO;
import com.star.VO.ProductVO;
import com.star.VO.ResultVO;
import com.star.dataobject.ProductCategory;
import com.star.dataobject.ProductInfo;
import com.star.service.CategoryService;
import com.star.service.ProductService;
import com.star.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("list")
    public ResultVO list(){
        /** 查询所有上架商品 */
        List<ProductInfo> productInfoList = productService.findUpAll();

        /** 查询类目 */
        List<Integer> categoryList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        /** 封装数据 */
        List<ProductCategory> productCategoryList =
                categoryService.findByCategoryTypeIn(categoryList);
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                 ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.seccess(productVOList);
    }

}
