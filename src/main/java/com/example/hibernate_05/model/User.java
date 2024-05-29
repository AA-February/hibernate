package com.example.hibernate_05.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(nullable = false,length = 150)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToOne
    @JoinColumn(name = "details_id")
    private CarDetails carDetails;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Car> cars = new HashSet<>();

    @OneToMany(mappedBy = "user",
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserRole> roles = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cars=" + cars +
                ", addresses=" + addresses +
                '}';
    }
}
