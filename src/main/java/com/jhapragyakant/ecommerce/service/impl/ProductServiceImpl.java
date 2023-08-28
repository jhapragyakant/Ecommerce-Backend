package com.jhapragyakant.ecommerce.service.impl;

import com.jhapragyakant.ecommerce.payload.ProductDto;
import com.jhapragyakant.ecommerce.entities.Product;
import com.jhapragyakant.ecommerce.excetion.ResourceNotFoundException;
import com.jhapragyakant.ecommerce.repositories.ProductRepository;
import com.jhapragyakant.ecommerce.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "Product Id", productId));
        productRepository.delete(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream().map((product) -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto getProduct(String productId) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "Product Id", productId));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public Boolean doesProductExists(String name) {
        return productRepository.existsByProductName(name);
    }

    @Override
    public String increasePrice(String productId, Double increaseAmount) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "Product Id", productId));
        product.setProductPrice(product.getProductPrice() + increaseAmount);
        Product savedProduct = productRepository.save(product);
        return String.format("Product price increased by: %.2f. Current price : %.2f", increaseAmount, savedProduct.getProductPrice());
    }

    @Override
    public String decreasePrice(String productId, Double decreaseAmount) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "Product Id", productId));
        if(product.getProductPrice() - decreaseAmount < 0){
            return String.format("Product price cannot be less than 0. Current price : %.2f", product.getProductPrice());
        }
        product.setProductPrice(product.getProductPrice() - decreaseAmount);
        Product savedProduct = productRepository.save(product);
        return  String.format("Product price decreased by: %.2f. Current price : %.2f", decreaseAmount, savedProduct.getProductPrice());
    }

    @Override
    public String increaseQuantity(String productId, Integer increaseValue) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "Product Id", productId));
        product.setProductQuantity(product.getProductQuantity() + increaseValue);
        Product savedProduct = productRepository.save(product);
        return String.format("Product quantity increased by: %d, Current stock: %d", increaseValue, savedProduct.getProductQuantity());
    }

    @Override
    public String decreaseQuantity(String productId, Integer decreaseValue) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "Product Id", productId));
        if(product.getProductQuantity() - decreaseValue < 0){
            return String.format("Product quantity cannot be less than 0. Current stock : %d", product.getProductQuantity());
        }
        product.setProductQuantity(product.getProductQuantity()-decreaseValue);
        Product savedProduct = productRepository.save(product);
        return String.format("Product quantity decreased by: %d. Current stock: %d", decreaseValue, savedProduct.getProductQuantity());
    }

}
