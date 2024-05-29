package com.example.hibernate_05.repository;

import com.example.hibernate_05.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
