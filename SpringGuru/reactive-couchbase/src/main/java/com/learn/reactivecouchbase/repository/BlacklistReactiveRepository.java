package com.learn.reactivecouchbase.repository;


import com.learn.reactivecouchbase.data.Blacklist;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;


public interface BlacklistReactiveRepository extends ReactiveCouchbaseRepository<Blacklist, String>{

}
