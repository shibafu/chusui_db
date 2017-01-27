package com.example.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.ChusuiUserMaster;

public class ChuUserDetails implements UserDetails{

	private ChusuiUserMaster chusuiUserMaster;

	private Collection<GrantedAuthority> authorities;

	public ChuUserDetails(
			ChusuiUserMaster chusuiUserMaster, Collection<GrantedAuthority> authorities
			){
			this.chusuiUserMaster = chusuiUserMaster;
			this.authorities = authorities;
		}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return authorities;
	}

	//こいつがuser_passwordをpasswordに勝手にやってくれたぜ。
	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return chusuiUserMaster.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return chusuiUserMaster.getUserEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return chusuiUserMaster.getEnabled();
	}

	public ChusuiUserMaster getchusuiUserMaster(){
		return this.chusuiUserMaster;
	}

}
