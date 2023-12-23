package com.example.userserviceyellowteam.db.repository;

import com.example.userserviceyellowteam.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID> {
    @Query("select User")
    List<User> findAllWhereRoleLikeCourier();

}
