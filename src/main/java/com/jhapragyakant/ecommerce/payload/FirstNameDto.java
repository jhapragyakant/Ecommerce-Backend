package com.jhapragyakant.ecommerce.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class FirstNameDto {
    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$",
            message = "First letter must be capital of each word")
    private String userFirstName;
}
