package com.sreyes.inventory_service.controller;

import com.sreyes.inventory_service.model.dto.BaseResponse;
import com.sreyes.inventory_service.model.dto.OrderItemRequest;
import com.sreyes.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku") String sku) {
        return inventoryService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse inStock(@RequestBody List<OrderItemRequest> orderItemRequests) {
        return inventoryService.areInStock(orderItemRequests);
    }
}
