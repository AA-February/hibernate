package com.example.hibernate_05.runner;

import com.example.hibernate_05.repository.CarRepository;
import com.example.hibernate_05.repository.UserRepository;
import com.example.hibernate_05.model.Car;
import com.example.hibernate_05.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setFirstName("Petar");
        user.setLastName("Ivanov");
        user.setPassword("123456789");
        User savedUser = userRepository.save(user);

        Car car = new Car();
        car.setMake("AUDI");
        car.setModel("Q7");
        car.setVin("1231443653457345");
        car.setRegNumber("B1234BB");
        car.setUser(savedUser);

        carRepository.save(car);

        User user1 = userRepository.findById(1L).get();
        Set<Car> userCars = user1.getCars();
        System.out.println(user1.toString());
    }
}
