package com.example.userserviceyellowteam.mapper;

import com.example.userserviceyellowteam.db.entity.User;
import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserResponseDto mapToDto(User user);
    User mapToUser(UserRequestDto userRequestDto);

}
