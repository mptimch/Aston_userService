package com.example.userserviceyellowteam.mapper;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserResponseDto mapToDto(User user);
}
