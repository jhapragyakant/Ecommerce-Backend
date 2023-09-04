package com.jhapragyakant.ecommerce.controllers;

import com.jhapragyakant.ecommerce.payload.ProductDto;
import com.jhapragyakant.ecommerce.response.ApiResponse;
import com.jhapragyakant.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create/category/{categoryId}")
    public ResponseEntity<?> createProduct(
            @Valid @RequestBody ProductDto productDto,
            @PathVariable Long categoryId
    ){
        if(productService.doesProductExists(productDto.getProductName())){
            return new ResponseEntity<>(new ApiResponse(false, "Product exits with same name."), HttpStatus.CONFLICT);
        }
        ProductDto createdProductDto =this.productService.createProduct(productDto, categoryId);
        return new ResponseEntity<>(createdProductDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(
            @Valid @RequestBody ProductDto newProductDto,
            @PathVariable String productId
    ){
        ProductDto updatedProductDto = this.productService.updateProduct(newProductDto, productId);
        return new ResponseEntity<>(new ApiResponse(true, "Product updated Successfully!"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable String productId
    ){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(new ApiResponse(true,"Product Deleted Successfully!"),HttpStatus.OK);
    }

    @GetMapping("get_all")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> list = productService.getAllProducts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("getProduct/{productId}")
    public ResponseEntity<ProductDto> getProductById(
            @PathVariable String productId
    ){
        ProductDto productDto = productService.getProduct(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PutMapping("/increase-price/{productId}")
    public ResponseEntity<String> increasePrice(
            @PathVariable String productId,
            @RequestParam Double increaseAmount
    ){
        String responseString = productService.increasePrice(productId, increaseAmount);
        return new ResponseEntity<>(responseString, HttpStatus.OK);
    }

    @PutMapping("/decrease-price/{productId}")
    public ResponseEntity<String> decreasePrice(
            @PathVariable String productId,
            @RequestParam Double decreaseAmount
    ){
        String responseString = productService.decreasePrice(productId, decreaseAmount);
        return new ResponseEntity<>(responseString, HttpStatus.OK);
    }

    @PutMapping("/increase-quantity/{productId}")
    public ResponseEntity<String> increaseQuantity(
            @PathVariable String productId,
            @RequestParam Integer increaseValue
    ){
        String responseString = productService.increaseQuantity(productId, increaseValue);
        return new ResponseEntity<>(responseString, HttpStatus.OK);
    }

    @PutMapping("/decrease-quantity/{productId}")
    public ResponseEntity<String> decreaseQuantity(
            @PathVariable String productId,
            @RequestParam Integer decreaseValue
    ){
        String responseString = productService.decreaseQuantity(productId,decreaseValue);
        return new ResponseEntity<>(responseString, HttpStatus.OK);
    }

    @PutMapping("/change-category/{productId}/{newCategoryId}")
    public ResponseEntity<String> changeProductCategory(
            @PathVariable String productId,
            @PathVariable Long newCategoryId
    ){
        String responseMessage = productService.changeProductCategory(productId,newCategoryId);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
