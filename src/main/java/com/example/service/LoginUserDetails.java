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

		LoginUserPassword = Optional.ofNullable(chusuiUserMaster)		//値をオプショナルでラップ
				.map(chusuiUserMaster -> chusuiUserMaster.getUserPassword())//帰ってきたオプショナルでメソッド実行
				.orElseGet(null);//値を取り出す。

		LoginUserPassword = Optional.ofNullable(customerMaster)		//値をオプショナルでラップ
				.map(customerMaster -> customerMaster.getCustomerPassword())//帰ってきたオプショナルでメソッド実行
				.orElseGet(null);//値を取り出す。

		//返す
		return LoginUserPassword;
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		String LoginUserName;

		//値をオプショナルでラップ
		Optional<ChusuiUserMaster> chu_opt = Optional.ofNullable(chusuiUserMaster);
		Optional<CustomerMaster> cm_opt = Optional.ofNullable(customerMaster);

		//値を取り出す。
		Optional<String>chu_UserNameOpt = chu_opt.map(chusuiUserMaster ->  chusuiUserMaster.getUserPassword());
		Optional<String>cm_UserNameOpt = cm_opt.map(customerMaster ->  customerMaster.getCustomerPassword());

		//代入
		LoginUserName = chu_UserNameOpt.orElseGet(() -> null);
		if(LoginUserName == null){
			LoginUserName =cm_UserNameOpt.orElseGet(() -> null);
		}

		//返す
		return LoginUserName;
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
		Boolean Enabled;

		//値をオプショナルでラップ
		Optional<ChusuiUserMaster> chu_opt = Optional.ofNullable(chusuiUserMaster);
		Optional<CustomerMaster> cm_opt = Optional.ofNullable(customerMaster);

		//値を取り出す。
		Optional<Boolean>chu_UserNameOpt = chu_opt.map(chusuiUserMaster ->  chusuiUserMaster.getEnabled());
		Optional<Boolean>cm_UserNameOpt = cm_opt.map(customerMaster ->  customerMaster.getEnabled());

		//代入
		Enabled = chu_UserNameOpt.orElseGet(() -> null);
		if((Enabled == null)){
			Enabled =cm_UserNameOpt.orElseGet(() -> null);
		}

		//返す
		return Enabled.booleanValue();
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
