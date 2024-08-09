package com.sreyes.inventory_service.service;

import com.sreyes.inventory_service.model.dto.BaseResponse;
import com.sreyes.inventory_service.model.dto.OrderItemRequest;

import java.util.List;

public interface InventoryService {
    BaseResponse areInStock(List<OrderItemRequest> orderItemRequests);

    boolean isInStock(String sku);
}
