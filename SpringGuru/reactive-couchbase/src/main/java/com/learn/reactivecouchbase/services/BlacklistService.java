package com.learn.reactivecouchbase.services;



import com.learn.reactivecouchbase.data.Blacklist;
import com.learn.reactivecouchbase.repository.BlacklistReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class BlacklistService {
	@Autowired
	private BlacklistReactiveRepository blacklistRepository;

	public Set<String> getBlacklist(String shopName) {
		Mono<Blacklist> blacklistPublisher = blacklistRepository.findById(Blacklist.getId(shopName));
		Blacklist shopBlacklist = blacklistPublisher.block();
		if(shopBlacklist == null) {
			return new LinkedHashSet<>();
		}
		return shopBlacklist.getBlackList();
	}

	public Blacklist writeBlacklist(String shopName, Set<String> blacklistSet) {
		Blacklist blacklist = Blacklist.create(shopName, blacklistSet);
		blacklistRepository.save(blacklist);

		return blacklist;
	}
}
