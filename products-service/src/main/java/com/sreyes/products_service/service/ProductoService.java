package com.sreyes.products_service.service;

import com.sreyes.products_service.model.dto.ProductRequest;
import com.sreyes.products_service.model.dto.ProductResponse;

import java.util.List;

public interface ProductoService {
    void agregarProducto(ProductRequest productRequest);
    List<ProductResponse> listarProductos();
}
