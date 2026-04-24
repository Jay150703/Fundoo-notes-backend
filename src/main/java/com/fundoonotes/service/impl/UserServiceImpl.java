package com.fundoonotes.service.impl;

import com.fundoonotes.dto.request.UserRegisterRequestDto;
import com.fundoonotes.dto.response.UserResponseDto;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.UserRepository;
import com.fundoonotes.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto register(UserRegisterRequestDto requestDto) {

        User user = User.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDto.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .email(savedUser.getEmail())
                .message("User registered successfully")
                .build();
    }
}