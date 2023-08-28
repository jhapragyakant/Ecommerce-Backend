package com.jhapragyakant.ecommerce.payload;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userId;
    @NotBlank
    @Size(min = 4, message = "Minimum length of username should be 4")
    private String username;

    @NotBlank
    @Pattern(regexp = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$",
            message = "Email address is not valid!")
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^\\w\\s]).{8,}$",
            message = "Should have at least one uppercase letter, one lowercase letter, one digit, one special character, and a minimum length of 8 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, max = 20, message = "password must be between 8 to 20 characters")
    private String userPassword;

    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$",
            message = "First letter must be capital of each word")
    private String userFirstName;

    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$",
            message = "First letter must be capital")
    private String userLastName;

    @NotBlank
    private String userAddress;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth should be in the past")
    private LocalDate userDateOfBirth;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    private String userPhone;

    @NotBlank
    @Pattern(regexp = "^(Male|Female|Trans)$",
            message = "Must be from Male, Female and Trans")
    private String userGender;
}
