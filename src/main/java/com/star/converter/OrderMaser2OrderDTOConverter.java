package com.star.converter;

import com.star.dataobject.OrderMaster;
import com.star.dto.OrderDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaser2OrderDTOConverter {

    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> converter(List<OrderMaster> orderMasterList){
        return  orderMasterList.stream()
                .map(e -> converter(e))
                .collect(Collectors.toList());
    }
}
