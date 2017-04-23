package com.learn.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationBuilder) throws Exception {
		/*authenticationBuilder.inMemoryAuthentication()
		.withUser("user").password("123").roles("USER")
		.and()
		.withUser("admin").password("123").roles("USER", "ADMIN");*/
		
		authenticationBuilder
			.jdbcAuthentication()
			.dataSource(dataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login")
			.and()
			.httpBasic();
			
	}
	
	
	
}
