package com.learn.jokes.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesService {
	private ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();

	public String getQuote() {
		return chuckNorrisQuotes.getRandomQuote();
	}

}
