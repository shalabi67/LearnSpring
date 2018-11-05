package com.learn.couchbase.services;


import com.learn.couchbase.data.Blacklist;
import com.learn.couchbase.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class BlacklistService {
	@Autowired
	private BlacklistRepository blacklistRepository;

	public Set<String> getBlacklist(String shopName) {
		Blacklist shopBlacklist = blacklistRepository.findById(Blacklist.getId(shopName)).orElse(null);
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
