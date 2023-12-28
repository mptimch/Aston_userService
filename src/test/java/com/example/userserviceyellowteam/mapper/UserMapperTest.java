package com.example.userserviceyellowteam.mapper;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void shouldMapUserToDto() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setChatId("chat1");
        user.setNickname("nickname1");

        UserResponseDto dto = userMapper.mapToDto(user);

        assertNotNull(dto);
        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getChatId(), dto.getChatId());
        assertEquals(user.getNickname(), dto.getNickname());
    }

    @Test
    public void shouldMapDtoToUser() {
        UserRequestDto dto = new UserRequestDto();
        dto.setChatId("chat1");
        dto.setNickname("nickname1");

        User user = userMapper.mapToUser(dto);

        assertNotNull(user);
        assertEquals(dto.getChatId(), user.getChatId());
        assertEquals(dto.getNickname(), user.getNickname());
    }
}
