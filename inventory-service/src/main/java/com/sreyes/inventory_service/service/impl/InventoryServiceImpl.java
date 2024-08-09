package com.sreyes.inventory_service.service.impl;

import com.sreyes.inventory_service.model.dto.BaseResponse;
import com.sreyes.inventory_service.model.dto.OrderItemRequest;
import com.sreyes.inventory_service.model.entities.Inventory;
import com.sreyes.inventory_service.repository.InventoryRepository;
import com.sreyes.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public boolean isInStock(String sku) {
        var inventory = inventoryRepository.findBySku(sku);
        return inventory.filter(value -> value.getQuantity() > 0).isPresent();
    }

    @Override
    public BaseResponse areInStock(List<OrderItemRequest> orderItemRequests) {
        var errorList = new ArrayList<String>();
        List<String> skus = orderItemRequests.stream().map(OrderItemRequest::getSku).toList();
        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);
        orderItemRequests.forEach(orderItem -> {
            var inventory = inventoryList.stream().filter(inventory1 -> inventory1.getSku().equals(orderItem.getSku())).findFirst();
            if (inventory.isEmpty()) {
                errorList.add("SKU " + orderItem.getSku() + " no encontrado");
            } else if (inventory.get().getQuantity() < orderItem.getQuantity()) {
                errorList.add("SKU " + orderItem.getSku() + " no cuenta con stock");
            }
        });
        return !errorList.isEmpty() ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }
}
