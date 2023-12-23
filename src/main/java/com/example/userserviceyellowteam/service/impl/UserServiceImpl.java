package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.repository.RoleJpaRepository;
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
    private RoleJpaRepository roleJpaRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto getAnyCourier() {
       return  null; //userMapper.mapToDto(roleJpaRepository.);
    }
}
