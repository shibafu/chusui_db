package com.example.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.Author;
import com.example.entity.UserMaster;

/**
 * ログインユーザーディテール。
 * 中に入るエンティティはChusuiUserMasterか、CustomerMasterかのどちらかになる。
 * @author chu31
 *
 */
public class LoginUserDetails implements UserDetails{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//フィールド
	//二つのテーブルから読み込む
	private Author author;
	private UserMaster userMaster;

	//ユーザーディテールフィールド
	private boolean enabled;
	private String userName;
	private String userPassword;

	//権限をロード
	private Collection<GrantedAuthority> authorities;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return authorities;
	}

	/**
	 * 管理者のフィールドを生成して初期化
	 * @param x_a
	 * @param x_authorities
	 */
	public LoginUserDetails(Author x_a, Collection<GrantedAuthority> x_authorities){
		this.author = x_a;
		this.authorities = x_authorities;
		this.userMaster = null;
	}

	/**
	 * 一般ユーザーのフィールドを生成して初期化
	 * @param x_u
	 * @param x_authorities
	 */
	public LoginUserDetails(UserMaster x_u, Collection<GrantedAuthority> x_authorities){
		this.author = null;
		this.authorities = x_authorities;
		this.userMaster = x_u;
	}

	@Override
	public String getPassword() {
		return this.userPassword;
	}

	@Override
	public String getUsername() {
		return this.userName;
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
		return this.enabled;
	}
	/**
	 * どちらのテーブルか判定
	 * @return
	 */
	public String whichUser() {
		String EntityType = null;

		//管理者の場合
		if(author.getAuthorId()!= null){
			EntityType = "ChusuiUserMaster";

			this.userName = author.getEmail();
			this.userPassword = author.getPassword();
			this.enabled = author.getEnabled();

			return EntityType; //メソッド終了

		} else if (userMaster.getUserId() != null){
			EntityType = "CustomerMaster";

			this.userName = userMaster.getEmail();
			this.userPassword = userMaster.getPassword();
			this.enabled = true;

			return EntityType; //メソッド終了
		}

		return EntityType;
	}
}
