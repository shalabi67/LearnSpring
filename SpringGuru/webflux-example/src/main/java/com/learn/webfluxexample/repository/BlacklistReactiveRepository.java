package com.learn.webfluxexample.repository;

import com.learn.webfluxexample.data.Blacklist;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface BlacklistReactiveRepository extends ReactiveCouchbaseRepository<Blacklist, String> {

}
