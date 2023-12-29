package com.example.userserviceyellowteam.mapper;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.dto.UserResponseFullDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserResponseDto mapToDto(User user);

    @Mapping(source = "userRole", target = "userRole.title")
    User mapToUser(UserRequestDto userRequestDto);

    @Mapping(target = "userRole", source = "userRole.title")
    UserResponseFullDto toUserResponseFullDto(User user);
}
