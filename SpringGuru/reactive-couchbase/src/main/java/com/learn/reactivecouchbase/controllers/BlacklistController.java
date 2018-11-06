package com.learn.reactivecouchbase.controllers;

import com.learn.reactivecouchbase.data.Blacklist;
import com.learn.reactivecouchbase.services.BlacklistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Blacklist controller to add and view blacklists per shop.
 */
@RestController
public class BlacklistController {
	private static final Logger LOG = LoggerFactory.getLogger(BlacklistController.class);
	private static final String SHOP_BLACKLIST = "/blacklist/{shopName}";

	@Autowired
	private BlacklistService blacklistService;
	@RequestMapping(value=SHOP_BLACKLIST, method= RequestMethod.GET)
	public ResponseEntity<Set<String>> getShopBlacklist(@PathVariable("shopName") String shopName) {
		ResponseEntity<Set<String>> result;
		try {
			Set<String> blacklist = blacklistService.getBlacklist(shopName);
			result = new ResponseEntity<>(blacklist, HttpStatus.OK);
		}catch(Exception e) {
			LOG.error(e.getMessage());
			result = new ResponseEntity<>(new LinkedHashSet<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;
	}

	@RequestMapping(value=SHOP_BLACKLIST, method= RequestMethod.POST)
	public ResponseEntity<Blacklist> setShopWhitelist(
			@PathVariable("shopName") String shopName,
			@RequestBody Set<String> blackList) {
		ResponseEntity<Blacklist> result;

		try {
			Blacklist blacklist = blacklistService.writeBlacklist(shopName, blackList);
			result = new ResponseEntity<Blacklist>(blacklist, HttpStatus.OK);
		}catch(Exception e) {
			LOG.error(e.getMessage());
			result = new ResponseEntity<Blacklist>(new Blacklist(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;
	}

}
