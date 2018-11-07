package com.learn.webfluxexample.services;

import com.learn.webfluxexample.data.Blacklist;
import com.learn.webfluxexample.repository.BlacklistReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BlacklistService {
	@Autowired
	private BlacklistReactiveRepository blacklistRepository;

	public Mono<Blacklist> getBlacklist(String shopName) {
		Mono<Blacklist> blacklistPublisher = blacklistRepository.findById(Blacklist.getId(shopName));

		return blacklistPublisher;
	}
}
