package com.example.hibernate_05.repository;

import com.example.hibernate_05.Role;
import com.example.hibernate_05.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRolesRepository extends JpaRepository<UserRole,Long> {
   UserRole findByRole(Role role);
}
