package com.jhapragyakant.ecommerce.service.impl;

import com.jhapragyakant.ecommerce.entities.User;
import com.jhapragyakant.ecommerce.excetion.ResourceNotFoundException;
import com.jhapragyakant.ecommerce.payload.PasswordDto;
import com.jhapragyakant.ecommerce.payload.UserDto;
import com.jhapragyakant.ecommerce.repositories.UserRepository;
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
    public String updateUserPassword(PasswordDto passwordDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
        user.setUserPassword(passwordDto.getUserPassword());
        userRepository.save(user);
        return String.format("Password updated successfully!");
    }

}
