package com.jhapragyakant.ecommerce.controllers;

import com.jhapragyakant.ecommerce.payload.*;
import com.jhapragyakant.ecommerce.response.ApiResponse;
import com.jhapragyakant.ecommerce.service.UserService;
import org.apache.tomcat.jni.Address;
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
    public ResponseEntity<ApiResponse> updateUserPassword(
            @Valid @RequestBody PasswordDto passwordDto,
            @PathVariable String userId
    ){
        ApiResponse response = userService.updateUserPassword(passwordDto, userId);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update-user/first-name/{userId}")
    public ResponseEntity<ApiResponse> updateFirstName(
            @Valid @RequestBody FirstNameDto firstNameDto,
            @PathVariable String userId
    ){
        ApiResponse response = userService.updateUserFirstName(firstNameDto, userId);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update-user/last-name/{userId}")
    public ResponseEntity<ApiResponse> updateLastName(
            @Valid @RequestBody LastNameDto lastNameDto,
            @PathVariable String userId
    ){
        ApiResponse response = userService.updateUserLastName(lastNameDto, userId);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update-user/address/{userId}")
    public ResponseEntity<ApiResponse> updateAddress(
            @Valid @RequestBody AddressDto addressDto,
            @PathVariable String userId
    ){
        ApiResponse response = userService.updateUserAddress(addressDto, userId);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update-user/dob/{userId}")
    public ResponseEntity<ApiResponse> updateDOB(
            @Valid @RequestBody DOBDto dobDto,
            @PathVariable String userId
    ){
        ApiResponse response = userService.updateDob(dobDto, userId);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update-user/phone/{userId}")
    public ResponseEntity<ApiResponse> updatePhoneNo(
            @Valid @RequestBody PhoneDto phoneDto,
            @PathVariable String userId
    ){
        ApiResponse response = userService.updatePhone(phoneDto, userId);
        if(response.isSuccess()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
