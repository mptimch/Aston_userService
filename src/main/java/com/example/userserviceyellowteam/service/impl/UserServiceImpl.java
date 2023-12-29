package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.entity.Role;
import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.db.repository.RoleJpaRepository;
import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.dto.UserResponseFullDto;
import com.example.userserviceyellowteam.mapper.UserMapper;
import com.example.userserviceyellowteam.service.CourierService;
import com.example.userserviceyellowteam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;
    private final RoleJpaRepository roleJpaRepository;
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

    @Override
    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto) {
        User user = userMapper.mapToUser(userRequestDto);
        Role byTitle = roleJpaRepository.findByTitle(user.getUserRole().getTitle());
        user.setUserRole(byTitle);
        return userMapper.mapToDto(userJpaRepository.save(user));
    }

    @Override
    public UserResponseFullDto getUserByChatId(String chatId) {
        User user = userJpaRepository.findByChatId(chatId).orElseThrow();
        return userMapper.toUserResponseFullDto(user);
    }
}
