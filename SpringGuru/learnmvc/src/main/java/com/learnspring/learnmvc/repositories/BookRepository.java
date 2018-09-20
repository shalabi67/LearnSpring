package com.learnspring.learnmvc.repositories;

import com.learnspring.learnmvc.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
