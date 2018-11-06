package com.learn.reactivecouchbase.repository;

import com.learn.reactivecouchbase.data.Blacklist;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlacklistRepositoryTest {

	@Autowired
	BlacklistReactiveRepository blacklistReactiveRepository;

	@Test
	public void nonExitingItem() {
		Mono<Blacklist> blacklistPublisher = blacklistReactiveRepository.findById(Blacklist.getId("not found"));
		Blacklist blacklist = blacklistPublisher.block();
		if(blacklist != null) {
			Assert.fail();
		}
	}


}
