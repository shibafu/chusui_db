package com.example.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.orders.GroupOrder1;
import com.example.orders.GroupOrder2;

public class LoginForm {
	//index.htmlのloginNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "ユーザー名を入力してください")
	private String loginName;
	//index.htmlのloginFormと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "パスワードを入力してください")
	@Size(min = 6,max= 18 ,groups={GroupOrder2.class}, message = "パスワードは6文字以上18文字以下で入力してください")
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
