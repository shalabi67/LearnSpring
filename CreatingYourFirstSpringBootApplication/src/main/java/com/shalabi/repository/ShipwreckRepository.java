package com.shalabi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shalabi.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
