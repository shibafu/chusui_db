package com.example.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.ChusuiUserMaster;
import com.example.entity.CustomerMaster;

/**
 * ログインユーザーディテール。
 * 中に入るエンティティはChusuiUserMasterか、CustomerMasterかのどちらかになる。
 * @author chu31
 *
 */
public class LoginUserDetails implements UserDetails{

	private ChusuiUserMaster chusuiUserMaster;
	private CustomerMaster customerMaster;

	private Collection<GrantedAuthority> authorities;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return authorities;
	}

	public LoginUserDetails(ChusuiUserMaster x_c, Collection<GrantedAuthority> x_authorities){
		this.chusuiUserMaster = x_c;
		this.authorities = x_authorities;
		this.customerMaster = null;
	}

	public LoginUserDetails(CustomerMaster x_c, Collection<GrantedAuthority> x_authorities){
		this.chusuiUserMaster = null;
		this.authorities = x_authorities;
		this.customerMaster = x_c;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		String LoginUserPassword;

		Optional<ChusuiUserMaster> chu_opt = Optional.ofNullable(chusuiUserMaster);
		Optional<CustomerMaster> cm_opt = Optional.ofNullable(customerMaster);

		LoginUserPassword =chu_opt.map(chusuiUserMaster ->  chusuiUserMaster.getUserPassword())
							.orElseGet(() ->//ラムダ式の入れ子
							cm_opt.map(customerMaster -> customerMaster.getCustomerPassword())//nullの時もう一度ラムダ式実行
							.orElseGet(() -> "No Password!")
							);
		//返す
		return LoginUserPassword;
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		String LoginUserName;

		Optional<ChusuiUserMaster> chu_opt = Optional.ofNullable(chusuiUserMaster);
		Optional<CustomerMaster> cm_opt = Optional.ofNullable(customerMaster);

		LoginUserName =chu_opt.map(chusuiUserMaster ->  chusuiUserMaster.getUserEmail())
							.orElseGet(() ->//ラムダ式の入れ子
							cm_opt.map(customerMaster -> customerMaster.getEmail())//nullの時もう一度ラムダ式実行
							.orElseGet(() -> "No Email!")
							);
		//返す
		return LoginUserName;
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
		Boolean Enabled;

		Optional<ChusuiUserMaster> chu_opt = Optional.ofNullable(chusuiUserMaster);
		Optional<CustomerMaster> cm_opt = Optional.ofNullable(customerMaster);

		Enabled =chu_opt.map(chusuiUserMaster ->  chusuiUserMaster.getEnabled())
							.orElseGet(() ->//ラムダ式の入れ子
							cm_opt.map(customerMaster -> customerMaster.getEnabled())//nullの時もう一度ラムダ式実行
							.orElseGet(() -> null)
							);
		//返す
		return Enabled;
	}
	/**
	 * どちらのテーブルか判定
	 * @return
	 */
	public String whichUser() {
		String EntityType = null;

		if(chusuiUserMaster.getUserId() != null){
			EntityType = "ChusuiUserMaster";
		} else if (customerMaster.getCustomerId() != null){
			EntityType = "CustomerMaster";
		}

		return EntityType;
	}
}
