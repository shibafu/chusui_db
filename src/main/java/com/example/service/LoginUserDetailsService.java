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

import com.example.entity.ChusuiUserMaster;
import com.example.entity.CustomerMaster;
import com.example.repository.ChusuiUserMasterRepository;
import com.example.repository.CustomerMasterRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService{

@Autowired
ChusuiUserMasterRepository chusuiUserMasterRepository;

@Autowired
CustomerMasterRepository customerMasterRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ

		//オプショナルで型取得
		List<ChusuiUserMaster> ListChu = chusuiUserMasterRepository.findByUserEmail(username);
		List<CustomerMaster> ListCus = customerMasterRepository.findByUserEmail(username);

		//条件分岐！
		if(ListChu != null && ListChu.size() > 0){
			return new LoginUserDetails(ListChu.get(0),getAuthorityChu(ListChu.get(0)));
		} else if(ListCus != null && ListCus.size() > 0l){
			return new LoginUserDetails(ListCus.get(0),getAuthorityCus(ListCus.get(0)));
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

	public CustomerMaster notFoundChusuiUser(Optional<List<CustomerMaster>> x_cus)throws UsernameNotFoundException{
		return x_cus.map(List_CusUser -> List_CusUser.get(0))
		.orElseThrow(() -> new  UsernameNotFoundException("user not be found"));
	}

	/**
	 *ユーザーの権限付与。
	 *createAuthorityListに権限を加えることで、ROLE_ADMINとROLE_USERの権限を両方持った状態にすることもできる。
	 * @return
	 */
	private Collection<GrantedAuthority> getAuthorityChu(ChusuiUserMaster x_cuMaster){
		if(x_cuMaster.getAuthority().equals("ROLE_ADMIN")){
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}

	/**
	 *
	 * @return
	 */
	private Collection<GrantedAuthority> getAuthorityCus(CustomerMaster x_cusMaster){
		if(x_cusMaster.getAuthority().equals("ROLE_ADMIN")){
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}
}
