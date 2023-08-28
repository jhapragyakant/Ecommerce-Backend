package com.jhapragyakant.ecommerce.service;

import com.jhapragyakant.ecommerce.payload.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, String productId);
    void deleteProduct(String productId);
    List<ProductDto> getAllProducts();
    ProductDto getProduct(String productId);
    Boolean doesProductExists(String name);
    String increasePrice(String productId, Double increaseAmount);
    String decreasePrice(String productId, Double decreaseAmount);
    String increaseQuantity(String productId, Integer increaseValue);
    String decreaseQuantity(String productId, Integer increaseValue);
}
