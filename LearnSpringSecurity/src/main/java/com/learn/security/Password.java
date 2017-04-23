package com.learn.security;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {

	@Test
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("123");
		System.out.println(encodedPassword);
	}

}
