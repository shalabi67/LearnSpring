package com.learn.testing.test_springboot.repository;

import com.learn.testing.test_springboot.data.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolsRepository extends JpaRepository<School, Long> {
}
