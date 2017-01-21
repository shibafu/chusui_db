package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.ChusuiUserMaster;

public class ChuUserDetails implements UserDetails{

	private ChusuiUserMaster chusuiUserMaster;

	private Collection<GrantedAuthority> authorities;

	public ChuUserDetails(
			int userId, String userLastName, String userFirstName
			,String userPassword, String userEmail, Collection<GrantedAuthority> authorities
			){
			super();

			this.chusuiUserMaster.setUserLastName(userLastName);
			this.chusuiUserMaster.setUserFirstName(userFirstName);
			this.chusuiUserMaster.setUserEmail(userEmail);
			this.chusuiUserMaster.setUserPassword(userPassword);
			this.chusuiUserMaster.setUserId(userId);
			this.authorities = authorities;
		}

	public static UserDetails create(ChusuiUserMaster entity){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		return new ChuUserDetails(entity.getUserId(), entity.getUserLastName(), entity.getUserFirstName()
				,entity.getUserPassword(), entity.getUserPassword(), authorities);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public ChusuiUserMaster getchusuiUserMaster(){
		return this.chusuiUserMaster;
	}

}
