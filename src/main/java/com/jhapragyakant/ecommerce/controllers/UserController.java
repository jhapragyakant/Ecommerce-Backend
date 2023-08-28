package com.jhapragyakant.ecommerce.controllers;

import com.jhapragyakant.ecommerce.payload.PasswordDto;
import com.jhapragyakant.ecommerce.payload.UserDto;
import com.jhapragyakant.ecommerce.response.ApiResponse;
import com.jhapragyakant.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody UserDto userDto
    ){
        if(userService.doesUserNameExists(userDto.getUsername())){
            return new ResponseEntity<>(new ApiResponse(false, "Username already exists"), HttpStatus.BAD_REQUEST);
        }
        if(userService.doesUserEmailExists(userDto.getUserEmail())){
            return new ResponseEntity<>(new ApiResponse(false, "Email already registered"), HttpStatus.BAD_REQUEST);
        }
        UserDto registeredUser = this.userService.registerUser(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PutMapping("/update-user/password/{userId}")
    public ResponseEntity<ApiResponse> updateUser(
            @Valid @RequestBody PasswordDto passwordDto,
            @PathVariable String userId
    ){
        String response = userService.updateUserPassword(passwordDto, userId);
        return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
    }
}
