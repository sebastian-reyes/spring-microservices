package com.sreyes.products_service.service.impl;

import com.sreyes.products_service.model.dto.ProductRequest;
import com.sreyes.products_service.model.dto.ProductResponse;
import com.sreyes.products_service.model.entities.Product;
import com.sreyes.products_service.repository.ProductRepository;
import com.sreyes.products_service.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);
    private final ProductRepository productRepository;

    @Override
    public void agregarProducto(ProductRequest productRequest) {
        var product = Product.builder()
                .sku(productRequest.getSku())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .status(productRequest.getStatus())
                .build();
        productRepository.save(product);
        log.info("Producto agregado {}", product);
    }

    @Override
    public List<ProductResponse> listarProductos() {
        var productos = productRepository.findAll();
        return productos.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }
}
