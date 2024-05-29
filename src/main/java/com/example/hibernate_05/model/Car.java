package com.example.hibernate_05.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    @Column(name = "registration_number")
    private String regNumber;
    @Column(nullable = false,name = "vin_number")
    private String vin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
