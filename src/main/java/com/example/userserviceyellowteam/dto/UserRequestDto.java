package com.example.userserviceyellowteam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto implements Serializable {
    @NotBlank
    @JsonProperty("chat_id")
    private String chatId;
    @NotBlank
    @JsonProperty("nickname")
    private String nickname;
    @NotNull
    @JsonProperty("user_roles")
    private List<String> userRoles;
}
