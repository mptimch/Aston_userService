package com.example.userserviceyellowteam.controllers;

import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
