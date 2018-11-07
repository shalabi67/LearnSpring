package com.learn.webfluxexample.controllers;

import com.learn.webfluxexample.data.Blacklist;
import com.learn.webfluxexample.services.BlacklistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

/**
 * Blacklist controller to add and view blacklists per shop.
 */
@Controller
public class BlacklistController {
	private static final Logger LOG = LoggerFactory.getLogger(BlacklistController.class);
	private static final String SHOP_BLACKLIST = "/blacklist/{shopName}";

	@Autowired
	private BlacklistService blacklistService;

	@RequestMapping(value=SHOP_BLACKLIST, method= RequestMethod.GET)
	public String getShopBlacklist(Model model, @PathVariable("shopName") String shopName) {
		Mono<Blacklist> blacklist = blacklistService.getBlacklist(shopName);
		model.addAttribute("blackList", blacklist);

		return "blacklist";
	}

}
