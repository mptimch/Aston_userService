package com.example.userserviceyellowteam.db.repository;

import com.example.userserviceyellowteam.db.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, UUID> {
}
