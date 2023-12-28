package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.entity.Role;
import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.db.entity.enumeration.UserRole;
import com.example.userserviceyellowteam.db.repository.RoleJpaRepository;
import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.mapper.UserMapper;
import com.example.userserviceyellowteam.service.CourierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    private UserServiceImpl userService;
    private UserJpaRepository userJpaRepository;
    private RoleJpaRepository roleJpaRepository;
    private UserMapper userMapper;
    private CourierService courierService;

    @BeforeEach
    public void setUp() {
        userJpaRepository = Mockito.mock(UserJpaRepository.class);
        roleJpaRepository = Mockito.mock(RoleJpaRepository.class);
        userMapper = Mockito.mock(UserMapper.class);
        courierService = Mockito.mock(CourierService.class);
        userService = new UserServiceImpl(userJpaRepository, roleJpaRepository, userMapper, courierService);
    }

    @Test
    public void testGetAnyCourier() {
        User courier = new User();
        courier.setId(UUID.randomUUID());
        courier.setChatId("chat1");
        courier.setNickname("nickname1");

        UserResponseDto dto = new UserResponseDto();
        dto.setId(courier.getId());
        dto.setChatId(courier.getChatId());
        dto.setNickname(courier.getNickname());

        when(courierService.getAny()).thenReturn(courier);
        when(userMapper.mapToDto(courier)).thenReturn(dto);

        UserResponseDto result = userService.getAnyCourier();

        assertEquals(dto, result);
        verify(courierService).getAny();
        verify(userMapper).mapToDto(courier);
    }

    @Test
    public void testCreate() {
        UserRequestDto requestDto = new UserRequestDto();
        requestDto.setChatId("chat1");
        requestDto.setNickname("nickname1");
        requestDto.setUserRoles(List.of("COURIER"));

        User user = new User();
        user.setChatId(requestDto.getChatId());
        user.setNickname(requestDto.getNickname());

        Role role = new Role();
        role.setTitle(UserRole.COURIER);

        User savedUser = new User();
        savedUser.setId(UUID.randomUUID());
        savedUser.setChatId(user.getChatId());
        savedUser.setNickname(user.getNickname());
        savedUser.setUserRoleList(List.of(role));

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(savedUser.getId());
        responseDto.setChatId(savedUser.getChatId());
        responseDto.setNickname(savedUser.getNickname());

        when(userMapper.mapToUser(requestDto)).thenReturn(user);
        when(roleJpaRepository.findByTitle(UserRole.COURIER)).thenReturn(role);
        when(userJpaRepository.save(user)).thenReturn(savedUser);
        when(userMapper.mapToDto(savedUser)).thenReturn(responseDto);

        UserResponseDto result = userService.create(requestDto);

        assertEquals(responseDto, result);
        verify(userMapper).mapToUser(requestDto);
        verify(roleJpaRepository).findByTitle(UserRole.COURIER);
        verify(userJpaRepository).save(user);
        verify(userMapper).mapToDto(savedUser);
    }
}
