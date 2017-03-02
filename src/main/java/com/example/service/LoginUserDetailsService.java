package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.repository.ChusuiUserMasterRepository;
import com.example.repository.CustomerMasterRepository;


public class LoginUserDetailsService implements UserDetailsService{

@Autowired
ChusuiUserMasterRepository chusuiUserMasterRepository;

@Autowired
CustomerMasterRepository customerMasterRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		LoginUserDetails lo_ud = new LoginUserDetails(
				Optional.ofNullable(chusuiUserMasterRepository.findByUserEmail(username))
				.orElseGet(() -> Optiona.nu
						customerMasterRepository.findAll()));

	return new ChuUserDetails(lo_cuMaster, getAuthority(lo_cuMaster));
		return null;
	}

}
