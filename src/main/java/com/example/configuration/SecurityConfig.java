package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.anyRequest()
				.authenticated()
				.antMatchers("/register","/reigster_confirm","/register_complete")
				.permitAll() //だれでも見れるページ
					.and()
				//LoginFormと同じものをパラメーターを作成
			.formLogin()
				.loginPage("/login")
				.usernameParameter("loginName")
				.passwordParameter("loginPassword")
				.loginProcessingUrl("/authenticate")
				.failureUrl("/login?error")
				.permitAll()  //ログインページ
				.defaultSuccessUrl("/user_top")
					.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll()
			.and()
				.csrf()
				.disable();
//				.csrfTokenRepository(csrfTokenRepository());			//csrfトークン挿入

	}

	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth)throws Exception{
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT email as username, customer_password as password, authority as authority, enabled as enabled FROM customer_master WHERE email = ?")
				.authoritiesByUsernameQuery("SELECT user_email as username, authority as authority FROM chusui_user_master WHERE user_email = ?");

		//				.passwordEncoder(new BCryptPasswordEncoder());

		System.out.println("へっへ");
	}

//	@Configuration
//	static class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter{
//
//			//ユーザー情報を取得するサービス
//		@Autowired
//		JdbcUserDetailsServiceImpl userDetailService;
//
//		//パスワードの暗号化形式
//		@Bean
//		PasswordEncoder passwordEncoder(){
//			return new BCryptPasswordEncoder();
//		}
//
//		@Override
//		public void init(AuthenticationManagerBuilder auth)throws Exception{
//			//ユーザーの情報の取得方式とエンコード方式を設定
//
//			auth.authenticationProvider(authenticationProviderImpl);
//			auth.userDetailsService(this.userDetailService);
//		}
//	}

	@Autowired
	void configureAuthentivationManager(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(cuService);
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
