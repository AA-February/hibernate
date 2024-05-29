package com.example.hibernate_05.model;

import com.example.hibernate_05.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
@Setter
@Getter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
}
