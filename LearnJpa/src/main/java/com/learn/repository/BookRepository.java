package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
