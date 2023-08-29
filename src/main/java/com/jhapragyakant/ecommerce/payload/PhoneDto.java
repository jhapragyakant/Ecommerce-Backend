package com.jhapragyakant.ecommerce.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PhoneDto {

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    private String userPhone;
}
