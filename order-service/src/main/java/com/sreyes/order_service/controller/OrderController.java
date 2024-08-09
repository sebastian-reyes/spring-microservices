package com.sreyes.order_service.controller;

import com.sreyes.order_service.model.dto.OrderRequest;
import com.sreyes.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRequest order) {
        this.orderService.addOrder(order);
        return "Orden creada";
    }
}
