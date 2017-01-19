package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.ChusuiUserMaster;

public class ChuUserDetails implements UserDetails{


	private Integer userId;
	private String userLastName;
	private String userFirstName;
	private String userPassword;
	private String userEmail;
	private Collection<GrantedAuthority> authorities;

	public ChuUserDetails(
			int userId, String userLastName, String userFirstName
			,String userPassword, String userEmail, Collection<GrantedAuthority> authorities
			){
			super();

			this.userId = userId;
			this.userLastName = userLastName;
			this.userFirstName = userFirstName;
			this.userPassword = userPassword;
			this.userEmail = userEmail;
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

}
