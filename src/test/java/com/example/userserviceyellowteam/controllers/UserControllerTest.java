package com.example.userserviceyellowteam.controllers;

import com.example.userserviceyellowteam.dto.UserRequestDto;
import com.example.userserviceyellowteam.dto.UserResponseDto;
import com.example.userserviceyellowteam.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;

public class UserControllerTest {
    private MockMvc mockMvc;
    private UserService userService;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        UserController userController = new UserController(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAnyCourier() throws Exception {
        UserResponseDto dto = new UserResponseDto();
        dto.setChatId("chat1");
        dto.setNickname("nickname1");

        Mockito.when(userService.getAnyCourier()).thenReturn(dto);

        mockMvc.perform(get("/aston/user-service/users/courier"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.chat_id").value(dto.getChatId()))
                .andExpect(jsonPath("$.nickname").value(dto.getNickname()));
    }

    @Test
    public void testCreateUser() throws Exception {
        UserRequestDto requestDto = new UserRequestDto();
        requestDto.setChatId("chat1");
        requestDto.setNickname("nickname1");

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setChatId(requestDto.getChatId());
        responseDto.setNickname(requestDto.getNickname());

        Mockito.when(userService.create(requestDto)).thenReturn(responseDto);

        mockMvc.perform(post("/aston/user-service/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.chat_id").value(responseDto.getChatId()))
                .andExpect(jsonPath("$.nickname").value(responseDto.getNickname()));
    }

}

