package com.star.service;

import com.star.dto.OrderDTO;

public interface BuyerService {

    public OrderDTO findOrderOne(String openid,String orderId);

    public OrderDTO cancelOrder(String openid,String orderId);
}
