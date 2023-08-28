package com.jhapragyakant.ecommerce.service;

import com.jhapragyakant.ecommerce.payload.PasswordDto;
import com.jhapragyakant.ecommerce.payload.UserDto;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    Boolean doesUserNameExists(String username);
    Boolean doesUserEmailExists(String email);
//    UserDto updateUser(UserDto userDto, String username);
    String updateUserPassword(PasswordDto passwordDto, String userId);
}
