package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
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
				.anyRequest()
				.authenticated()
			.and()
				.csrf()
				.disable();
//				.csrfTokenRepository(csrfTokenRepository());			//csrfトークン挿入

	}

//	@Autowired
//	void configureAuthentivationManager(AuthenticationManagerBuilder auth)throws Exception{
//		auth.userDetailsService(cuService);
//	}

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
