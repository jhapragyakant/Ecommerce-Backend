package com.jhapragyakant.ecommerce.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
public class CategoryDto {

    private Long categoryId;

    @NotBlank
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$",
            message = "First letter must be capital and other small")
    private String categoryName;

    @NotBlank
    @Size(min = 10, max = 200)
    private String categoryDescription;

}
