package com.learn.jokes.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesService {
	private ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();

	public JokesService(ChuckNorrisQuotes chuckNorrisQuotes) {
		this.chuckNorrisQuotes = chuckNorrisQuotes;
	}
	public String getQuote() {
		return chuckNorrisQuotes.getRandomQuote();
	}

}
