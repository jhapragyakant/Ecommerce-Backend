package com.jhapragyakant.ecommerce.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
public class DOBDto {

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth should be in the past")
    private LocalDate userDateOfBirth;

}
