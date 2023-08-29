package com.jhapragyakant.ecommerce.service.impl;

import com.jhapragyakant.ecommerce.entities.User;
import com.jhapragyakant.ecommerce.excetion.ResourceNotFoundException;
import com.jhapragyakant.ecommerce.payload.*;
import com.jhapragyakant.ecommerce.repositories.UserRepository;
import com.jhapragyakant.ecommerce.response.ApiResponse;
import com.jhapragyakant.ecommerce.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User registerdUser = this.userRepository.save(user);
        return modelMapper.map(registerdUser, UserDto.class);
    }

    @Override
    public Boolean doesUserNameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean doesUserEmailExists(String email) {
        return userRepository.existsByUserEmail(email);
    }

    @Override
    public ApiResponse updateUserPassword(PasswordDto passwordDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
        if(user.getUserPassword().equals(passwordDto.getUserPassword())){
            return new ApiResponse(false,"Cannot update as password entered is same");
        }
        user.setUserPassword(passwordDto.getUserPassword());
        userRepository.save(user);
        return new ApiResponse(true, "Password updated successfully!");
    }

    @Override
    public ApiResponse updateUserFirstName(FirstNameDto firstNameDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
        if(user.getUserFirstName().equals(firstNameDto.getUserFirstName())){
            return new ApiResponse(false, "First Name same");
        }
        user.setUserFirstName(firstNameDto.getUserFirstName());
        userRepository.save(user);
        return new ApiResponse(true, "First Name updated successfully!");
    }

    @Override
    public ApiResponse updateUserLastName(LastNameDto lastNameDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
        if(user.getUserLastName() != null && user.getUserLastName().equals(lastNameDto.getUserLastName())){
            return new ApiResponse(false, "Last Name same");
        }
        user.setUserLastName(lastNameDto.getUserLastName());
        userRepository.save(user);
        return new ApiResponse(true, "Last Name updated successfully!");
    }

    @Override
    public ApiResponse updateUserAddress(AddressDto addressDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
        if(user.getUserAddress().equals(addressDto.getUserAddress())){
            return new ApiResponse(false, "Address same");
        }
        user.setUserAddress(addressDto.getUserAddress());
        userRepository.save(user);
        return new ApiResponse(true, "Address updated successfully!");
    }

    @Override
    public ApiResponse updateDob(DOBDto dobDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
        if(user.getUserDateOfBirth().compareTo(dobDto.getUserDateOfBirth()) == 0){
            return new ApiResponse(false, "DOB same");
        }
        user.setUserDateOfBirth(dobDto.getUserDateOfBirth());
        userRepository.save(user);
        return new ApiResponse(true, "DOB updated successfully!");
    }

    @Override
    public ApiResponse updatePhone(PhoneDto phoneDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
        if(user.getUserPhone().equals(phoneDto.getUserPhone())){
            return new ApiResponse(false, "Phone no same");
        }
        user.setUserPhone(phoneDto.getUserPhone());
        userRepository.save(user);
        return new ApiResponse(true, "Phone no updated successfully!");
    }

}
