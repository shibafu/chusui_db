package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


/**
 * 認証クラス、ここでDBとの細かい設定を行うと思う。
 * @author chu31
 * 参照　http://shinsuke789.hatenablog.jp/entry/2015/08/11/123000
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationProvider.class)

//	@Autowired
//	private ChusuiUserDao chuDao;
			//未実装

	@Override
	public Authentication authenticate(Authentication auth)
		throws AuthenticationException{

		String id = auth.getName()
		
	}
}
