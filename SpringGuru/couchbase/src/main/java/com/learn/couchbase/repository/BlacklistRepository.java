package com.learn.couchbase.repository;

import com.learn.couchbase.data.Blacklist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends CrudRepository<Blacklist, String> {

}
