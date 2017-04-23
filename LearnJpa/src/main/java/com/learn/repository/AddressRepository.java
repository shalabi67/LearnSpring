package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
