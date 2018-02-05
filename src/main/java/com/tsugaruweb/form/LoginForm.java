package com.tsugaruweb.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.tsugaruweb.orders.GroupOrder1;
import com.tsugaruweb.orders.GroupOrder2;

public class LoginForm {
	//index.htmlのインプットタグloginNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※ログインネームを入力してください")
	private String loginName;
	//index.htmlのインプットタグloginFormと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※パスワードを入力してください")
	@Size(min = 8,max= 36 ,groups={GroupOrder2.class}, message = "※パスワードは8文字以上36文字以下で入力してください")
	@Pattern(regexp="[a-zA-Z0-9]*",groups={GroupOrder2.class},message="※パスワードは英数である必要があります。")
	private String loginPassword;

	public void setLoginName(String x_loginname){
		this.loginName = x_loginname;
	}
	public String getLoginName(){
		return this.loginName;
	}
	public void setLoginPassword(String x_loginPassword){
		this.loginPassword = x_loginPassword;
	}
	public String getLoginPassword(){
		return this.loginPassword;
	}
}
