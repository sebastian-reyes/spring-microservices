package com.sreyes.products_service.controller;

import com.sreyes.products_service.model.dto.ProductRequest;
import com.sreyes.products_service.model.dto.ProductResponse;
import com.sreyes.products_service.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductoService productoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarProducto(@RequestBody ProductRequest productRequest) {
        productoService.agregarProducto(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> obtenerProductos() {
        return this.productoService.listarProductos();
    }
}
