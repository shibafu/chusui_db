package com.example.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Author;
import com.example.entity.UserMaster;
import com.example.repository.AuthorRepository;
import com.example.repository.UserMasterRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService{

@Autowired
AuthorRepository authorRepository;

@Autowired
UserMasterRepository umRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ

		//オプショナルで型取得
		List<Author> ListAuthority = authorRepository.findByEmail(username);
		List<UserMaster> ListUm = umRepository.findByUserEmail(username);

		//条件分岐！
		if(ListAuthority != null && ListUm.size() > 0){
			return new LoginUserDetails(ListAuthority.get(0), getAuthority(ListAuthority.get(0)));
		} else if(ListAuthority != null && ListUm.size() > 0l){
			return new LoginUserDetails(ListUm.get(0), getAuthorityUm(ListUm.get(0)));
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

	/**
	 *ユーザーの権限付与。
	 *後でリファクタリングするかも
	 *createAuthorityListに権限を加えることで、ROLE_ADMINとROLE_USERの権限を両方持った状態にすることもできる。
	 * @return
	 */
	private Collection<GrantedAuthority> getAuthority(Author x_author){
		if(x_author.getAuthority().equals("ROLE_ADMIN")){
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}

	/**
	 *
	 * @return
	 */
	private Collection<GrantedAuthority> getAuthorityUm(UserMaster x_umMaster){
		if(x_umMaster.getAuthority().equals("ROLE_ADMIN")){
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
}
