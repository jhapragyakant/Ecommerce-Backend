package com.jhapragyakant.ecommerce.service;

import com.jhapragyakant.ecommerce.payload.*;
import com.jhapragyakant.ecommerce.response.ApiResponse;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    Boolean doesUserNameExists(String username);
    Boolean doesUserEmailExists(String email);
//    UserDto updateUser(UserDto userDto, String username);
    ApiResponse updateUserPassword(PasswordDto passwordDto, String userId);
    ApiResponse updateUserFirstName(FirstNameDto firstNameDto, String userId);
    ApiResponse updateUserLastName(LastNameDto lastNameDto, String userId);
    ApiResponse updateUserAddress(AddressDto addressDto, String userId);
    ApiResponse updateDob(DOBDto dobDto, String userId);
    ApiResponse updatePhone(PhoneDto phoneDto, String userId);
}
