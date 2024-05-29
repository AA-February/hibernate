package com.example.hibernate_05.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street1;
    private String street2;
    private boolean isDefault;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
