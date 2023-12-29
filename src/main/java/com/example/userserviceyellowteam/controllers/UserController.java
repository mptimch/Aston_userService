package com.example.userserviceyellowteam.controllers;

import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.dto.UserResponseFullDto;
import com.example.userserviceyellowteam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aston/user-service/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Метод для назначения курьера на доставку по запросу DeliveryService
     * @return
     */
    @GetMapping("/courier")
    UserResponseDto getAnyCourier() {
        return userService.getAnyCourier();
    }

    @PostMapping("/create")
    UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.create(userRequestDto);
    }
@GetMapping("/{id}")
UserResponseFullDto getUserByChatId(@PathVariable(name = "id") String chatId){
        return userService.getUserByChatId(chatId);
}
}
