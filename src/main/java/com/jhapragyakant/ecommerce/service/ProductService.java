package com.jhapragyakant.ecommerce.service;

import com.jhapragyakant.ecommerce.controller.payload.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, UUID productId);
    void deleteProduct(UUID productId);
    List<ProductDto> getAllProducts();
    ProductDto getProduct(UUID productId);
    Boolean doesProductExists(String name);
    String increasePrice(String productId, Double increaseAmount);
    String decreasePrice(String productId, Double decreaseAmount);
    String increaseQuantity(String productId, Integer increaseValue);
    String decreaseQuantity(String productId, Integer increaseValue);
}
