package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 認証を管理するコンフィグBean
 * @author chu31
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/register","/reigster_confirm","/register_complete").permitAll() //だれでも見れるページ
		.anyRequest().authenticated()
			.and()
				//LoginFormと同じものをパラメーターを作成
		.formLogin().loginPage("/").usernameParameter("loginName").passwordParameter("loginPassword") .failureUrl("/?error").permitAll()  //ログインページ
			.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
			.and()
		.formLogin().successForwardUrl("/user_top");

	}

//	@Override
//	protected void configure (AuthenticationManagerBuilder auth)throws Exception{
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.usersByUsernameQuery("SELECT user_email,user_password FROM chusui_user_master WHERE user_email = ?")
////				.usersByUsernameQuery("SELECT email,customer_password FROM customer_master WHERE email = ?")
//				.passwordEncoder(new BCryptPasswordEncoder());
//	}
}
