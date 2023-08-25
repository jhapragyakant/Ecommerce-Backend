package com.jhapragyakant.ecommerce.service.impl;

import com.jhapragyakant.ecommerce.controller.payload.ProductDto;
import com.jhapragyakant.ecommerce.entities.Product;
import com.jhapragyakant.ecommerce.excetion.ResourceNotFoundException;
import com.jhapragyakant.ecommerce.repositories.ProductRepository;
import com.jhapragyakant.ecommerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = this.modelMapper.map(productDto, Product.class);
        Product createdProduct = this.productRepository.save(product);
        return this.modelMapper.map(createdProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, String productId) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "Product Id", productId));
        product.setProductDescription(productDto.getProductDescription());
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductQuantity(productDto.getProductQuantity());
        product.setProductImageUrl(productDto.getProductImageUrl());

        Product updatedProduct = this.productRepository.save(product);
        return this.modelMapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(String productId) {

    }

    @Override
    public List<ProductDto> getAllProducts() {
        return null;
    }

    @Override
    public ProductDto getProduct(String productId) {
        return null;
    }

    @Override
    public Boolean doesProductExists(String name) {
        return productRepository.existsByProductName(name);
    }

    @Override
    public String increasePrice(String productId, Double increaseAmount) {
        return null;
    }

    @Override
    public String decreasePrice(String productId, Double decreaseAmount) {
        return null;
    }

    @Override
    public String increaseQuantity(String productId, Integer increaseValue) {
        return null;
    }

    @Override
    public String decreaseQuantity(String productId, Integer increaseValue) {
        return null;
    }

}
