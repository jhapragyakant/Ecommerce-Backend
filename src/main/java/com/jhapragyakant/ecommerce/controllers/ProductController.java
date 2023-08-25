package com.jhapragyakant.ecommerce.controllers;

import com.jhapragyakant.ecommerce.controller.payload.ProductDto;
import com.jhapragyakant.ecommerce.response.ApiResponse;
import com.jhapragyakant.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(
            @Valid @RequestBody ProductDto productDto
    ){
        if(productService.doesProductExists(productDto.getProductName())){
            return new ResponseEntity<>(new ApiResponse(false, "Product exits with same name."), HttpStatus.CONFLICT);
        }
        ProductDto createdProductDto =this.productService.createProduct(productDto);
        return new ResponseEntity<>(createdProductDto, HttpStatus.CREATED);
    }
}
