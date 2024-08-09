package com.sreyes.order_service.service;

import com.sreyes.order_service.model.dto.OrderRequest;

public interface OrderService {
    void addOrder(OrderRequest orderRequest);
}
