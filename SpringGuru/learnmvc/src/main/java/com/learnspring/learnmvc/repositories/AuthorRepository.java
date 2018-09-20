package com.learnspring.learnmvc.repositories;

import com.learnspring.learnmvc.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
