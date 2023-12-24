package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.mapper.UserMapper;
import com.example.userserviceyellowteam.service.CourierService;
import com.example.userserviceyellowteam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;
    private final CourierService courierService;

    /**
     * Возвращает следующего из свободных сейчас курьеров
     *
     * @return UserResponseDto
     */
    @Override
    public UserResponseDto getAnyCourier() {
        User courier = courierService.getAny();
        return userMapper.mapToDto(courier);
    }
}
