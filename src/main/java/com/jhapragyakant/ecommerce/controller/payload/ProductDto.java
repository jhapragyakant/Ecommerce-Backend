package com.jhapragyakant.ecommerce.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String productId;

    @NotBlank(message = "Product Name is Required")
    private String productName;

    @NotBlank(message = "Product Description cannot be empty")
    private String productDescription;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @NotNull
    @Digits(integer = 5, fraction = 2, message = "Price format is invalid : 5 integer part and 2 fractional part")
    private Double productPrice;

    @NotNull
    private Integer productQuantity;

    @NotBlank(message = "Product ImageUrl cannot be empty")
    @Pattern(regexp = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)", message = "file supported of type jpg, png, gif, bmp")
    private String productImageUrl;

}
