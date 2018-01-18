//package com.tsugaruweb.service;
//
//import java.util.Collection;
//import java.util.Optional;
//import java.util.function.Supplier;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.tsugaruweb.entity.Author;
//import com.tsugaruweb.entity.UserMaster;
//
///**
// * ログインユーザーディテール。
// * 中に入るエンティティはChusuiUserMasterか、CustomerMasterかのどちらかになる。
// * @author chu31
// *
// */
//public class LoginUserDetails implements UserDetails{
//
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//	private Author author;
//	private UserMaster userMaster;
//
//	private Collection<GrantedAuthority> authorities;
//
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO 自動生成されたメソッド・スタブ
//		return authorities;
//	}
//
//	public LoginUserDetails(Author x_a, Collection<GrantedAuthority> x_authorities){
//		this.author = x_a;
//		this.authorities = x_authorities;
//		this.userMaster = null;
//	}
//
//	public LoginUserDetails(UserMaster x_c, Collection<GrantedAuthority> x_authorities){
//		this.author = null;
//		this.authorities = x_authorities;
//		this.userMaster = x_c;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO 自動生成されたメソッド・スタブ
//		String LoginUserPassword;
//
//		Optional<Author> au_opt = Optional.ofNullable(author);
//		Optional<UserMaster> um_opt = Optional.ofNullable(userMaster);
//
//		LoginUserPassword =au_opt.map(author_entity ->  author.getPassword())
//							.orElseGet(() ->//ラムダ式の入れ子
//							um_opt.map(userMaster_entity -> userMaster.getPassword())//nullの時もう一度ラムダ式実行
//							.orElseGet(() -> "No Password!")
//							);
//		//返す
//		return LoginUserPassword;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO 自動生成されたメソッド・スタブ
//		String LoginUserName;
//
//		Optional<Author> au_opt = Optional.ofNullable(author);
//		Optional<UserMaster> um_opt = Optional.ofNullable(userMaster);
//
//		LoginUserName =au_opt.map(author_entity ->  author.getPassword())
//							.orElseGet(() ->//ラムダ式の入れ子
//							um_opt.map(userMaster_entity -> userMaster.getPassword())//nullの時もう一度ラムダ式実行
//							.orElseGet(() -> "No Password!")
//							);
//		//返す
//		return LoginUserName;
//		}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO 自動生成されたメソッド・スタブ
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO 自動生成されたメソッド・スタブ
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO 自動生成されたメソッド・スタブ
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO 自動生成されたメソッド・スタブ
//		boolean EnabledResult;
//
//		Optional<Author> au_opt = Optional.ofNullable(author);
//		Optional<UserMaster> um_opt = Optional.ofNullable(userMaster);
//
//		boolean EnabledAuthor = au_opt.map(author -> author.getEnabled()).orElseGet(() -> false);
//		boolean EnabledUser = au_opt.map(userMaster-> userMaster.getEnabled()).orElseGet(() -> false);
//
//
//		if(EnabledAuthor == true || EnabledUser == true) {
//			EnabledResult = true;
//		}else {
//			EnabledResult = false;
//		}
//
//		//返す
//		return EnabledResult;
//	}
//	/**
//	 * どちらのテーブルか判定
//	 * @return
//	 */
//	public String whichUser() {
//		String EntityType = null;
//
//		if(author.getAuthorId() != null){
//			EntityType = "Author";
//		} else if (userMaster.getUserId() != null){
//			EntityType = "UserMaster";
//		}
//
//		return EntityType;
//	}
//}
