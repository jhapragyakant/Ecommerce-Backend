package com.jhapragyakant.ecommerce.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddressDto {
    @NotBlank
    private String userAddress;
}
