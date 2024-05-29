package com.example.hibernate_05.runner;

import com.example.hibernate_05.Role;
import com.example.hibernate_05.model.Address;
import com.example.hibernate_05.model.UserRole;
import com.example.hibernate_05.repository.AddressRepository;
import com.example.hibernate_05.repository.CarRepository;
import com.example.hibernate_05.repository.UserRepository;
import com.example.hibernate_05.model.Car;
import com.example.hibernate_05.model.User;
import com.example.hibernate_05.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final AddressRepository addressRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public Runner(UserRepository userRepository, CarRepository carRepository, AddressRepository addressRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.addressRepository = addressRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for (Role role : Role.values()){
            UserRole userRole = new UserRole();
            userRole.setRole(role);
            userRolesRepository.save(userRole);
        }

        User user = new User();
        user.setEmail("test@gmail.com");
        user.setFirstName("Petar");
        user.setLastName("Ivanov");
        user.setPassword("123456789");
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRolesRepository.findByRole(Role.ROLE_USER));
        roles.add(userRolesRepository.findByRole(Role.ROLE_ADMIN));
        user.setRoles(roles);
        User savedUser = userRepository.save(user);

        Car car = new Car();
        car.setMake("AUDI");
        car.setModel("Q7");
        car.setVin("1231443653457345");
        car.setRegNumber("B1234BB");
        car.setUser(savedUser);

        carRepository.save(car);

        Address address = new Address();
        address.setCity("Varna");
        address.setCountry("Bulgaria");
        address.setDefault(true);
        address.setUser(savedUser);

        addressRepository.save(address);

        User user1 = userRepository.findById(1L).get();

        Set<Car> userCars = user1.getCars();
        Car savedCar = carRepository.findById(1L).get();
        System.out.println(user1.toString());
    }
}
