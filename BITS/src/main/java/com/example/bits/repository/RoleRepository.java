package com.example.bits.repository;

import com.example.bits.model.Role;
import com.example.bits.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
