package com.example.userserviceyellowteam.dto;

import com.example.userserviceyellowteam.db.entity.enumeration.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseFullDto implements Serializable {
    @NotNull
    @JsonProperty("id")
    private UUID id;
    @NotBlank
    @JsonProperty("chat_id")
    private String chatId;
    @NotBlank
    @JsonProperty("nickname")
    private String nickname;
    @NotBlank
    @JsonProperty("user_roles")
    private UserRole userRole;
}
