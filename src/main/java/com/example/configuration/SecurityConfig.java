package com.example.configuration;

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
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.inMemoryAuthentication()
				.withUser("user").password("naisho").roles("USER");

		auth
		.inMemoryAuthentication()
			.withUser("user_unnnun").password("naishotest").roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/register","/reigster_confirm","/register_complete").permitAll() //だれでも見れるページ
		.anyRequest().authenticated()
			.and()
		.formLogin().loginPage("/").failureUrl("/").permitAll()  //ログインページ
			.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
}
