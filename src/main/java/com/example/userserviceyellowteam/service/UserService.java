package com.example.userserviceyellowteam.service;

import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.dto.UserResponseFullDto;

public interface UserService {

    UserResponseDto getAnyCourier();

    UserResponseDto create(UserRequestDto userRequestDto);

   UserResponseFullDto getUserByChatId(String chatId);
}
