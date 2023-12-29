package com.example.userserviceyellowteam.service.impl;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.db.repository.UserJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CourierServiceImplTest {

    private CourierServiceImpl courierService;
    private UserJpaRepository userJpaRepository;

    @BeforeEach
    public void setUp() {
        userJpaRepository = Mockito.mock(UserJpaRepository.class);
        courierService = new CourierServiceImpl(userJpaRepository);
    }

    @Test
    public void testGetAny() {
        User user1 = new User();
        user1.setId(UUID.randomUUID());
        user1.setChatId("chat1");
        user1.setNickname("nickname1");

        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setChatId("chat2");
        user2.setNickname("nickname2");

        when(userJpaRepository.findAllWhereRoleLikeCourier()).thenReturn(Optional.of(List.of(user1, user2)));

        User result = courierService.getAny();

        assertEquals(user1, result);

        result = courierService.getAny();

        assertEquals(user2, result);

        result = courierService.getAny();

        assertEquals(user1, result);
    }
}
