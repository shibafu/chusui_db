package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.example.service.ChuUserDetailService;

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

	//独自の認証UserDetailServiceを注入
	@Autowired
	ChuUserDetailService cuService;

//	@Autowired
//	LoginUserDetailsService loService;

	/**
	 * デバッグモード
	 */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true);
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				//LoginFormと同じものをパラメーターを作成
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.usernameParameter("loginName")
				.passwordParameter("loginPassword")
				.defaultSuccessUrl("/user_top")
					.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.permitAll()
			.and()
				.authorizeRequests()
				.antMatchers("/register","/register_confirm","/register_complete").permitAll()
				.antMatchers("/management_console/*").hasAuthority("ROLE_ADMIN")
				.anyRequest()
				.authenticated()
			.and()
				.csrf()
				.disable();
//				.csrfTokenRepository(csrfTokenRepository());			//csrfトークン挿入

	}

	/**
	 * 実際セキュリティを動かすメソッド。
	 * 今はChusuiUserのみ
	 * @param auth ユーザー認証情報。
	 * @throws Exception
	 */
	@Autowired
	void configureAuthentivationManager(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(cuService)
		.passwordEncoder(passwordEncoder());

		System.out.println("ここでとなる");
//		auth.authenticationProvider(authenticationProvider)
	}

	//パスワードエンコーダー
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	/**
	 *
	 * @return csrdトークンオブジェクト
	 */
	private CsrfTokenRepository csrfTokenRepository()
	{
	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
	    repository.setSessionAttributeName("_csrf");
	    return repository;
	}
}
