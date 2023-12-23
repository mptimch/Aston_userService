package com.example.userserviceyellowteam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    @NotBlank
    @JsonProperty("chat_id")
    private String chatId;
    @NotBlank
    @JsonProperty("nickname")
    private String nickname;

}
