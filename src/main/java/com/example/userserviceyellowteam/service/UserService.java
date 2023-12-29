package com.example.userserviceyellowteam.service;

import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;

public interface UserService {

    UserResponseDto getAnyCourier();

    UserResponseDto create(UserRequestDto userRequestDto);

    UserResponseDto getUserByChatId(String chatId);
}
