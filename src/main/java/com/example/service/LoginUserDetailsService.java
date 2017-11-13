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
UserMasterRepository userMasterRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ

		//オプショナルで型取得
		List<Author> ListAuth = authorRepository.findByEmail(username);
		List<UserMaster> ListUma = userMasterRepository.findByUserEmail(username);

		//条件分岐！
		if(ListAuth != null && ListAuth.size() > 0){
			return new LoginUserDetails(ListAuth.get(0),getAuthorityAuth(ListAuth.get(0)));
		} else if(ListUma != null && ListUma.size() > 0l){
			return new LoginUserDetails(ListUma.get(0),getAuthorityUma(ListUma.get(0)));
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

	public UserMaster notFoundChusuiUser(Optional<List<UserMaster>> x_um)throws UsernameNotFoundException{
		return x_um.map(List_CusUser -> List_CusUser.get(0))
		.orElseThrow(() -> new  UsernameNotFoundException("user not be found"));
	}

	/**
	 *ユーザーの権限付与。
	 *createAuthorityListに権限を加えることで、ROLE_ADMINとROLE_USERの権限を両方持った状態にすることもできる。
	 * @return
	 */
	private Collection<GrantedAuthority> getAuthorityAuth(Author x_author){
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
	private Collection<GrantedAuthority> getAuthorityUma(UserMaster x_userMaster){
		if(x_userMaster.getAuthority().equals("ROLE_ADMIN")){
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
}
