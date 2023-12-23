package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.db.repository.RoleJpaRepository;
import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.mapper.UserMapper;
import com.example.userserviceyellowteam.service.CourierService;
import com.example.userserviceyellowteam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;
    private RoleJpaRepository roleJpaRepository;
    private final UserMapper userMapper;

    /**
     * на данный момент метод возвращает случайного курьера из всех существующих
     * хочу потом переделать с кешированием и очередью)
     * @return
     */
    @Override
    public UserResponseDto getAnyCourier() {
        List<User> couriers = userJpaRepository.findAllWhereRoleLikeCourier();
        Random random = new Random();
        User courier = couriers.get(random.nextInt(0,couriers.size()));
       return userMapper.mapToDto(courier) ;
    }
}
