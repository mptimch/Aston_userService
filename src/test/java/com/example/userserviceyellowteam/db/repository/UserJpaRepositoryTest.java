package com.example.userserviceyellowteam.db.repository;

import com.example.userserviceyellowteam.db.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class UserJpaRepositoryTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Container
    public static JdbcDatabaseContainer<?> container = new PostgreSQLContainer("postgres:latest")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test")
            .withInitScript("init_for_testcontainer.sql");

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Test
    public void testFindAllWhereRoleLikeCourier() {
        List<User> users = userJpaRepository.findAllWhereRoleLikeCourier().orElseThrow();
        assertThat(users).isNotEmpty();
    }
}
