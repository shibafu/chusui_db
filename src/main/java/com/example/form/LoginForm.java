package com.example.form;

public class LoginForm {
	//index.htmlのloginNameと同じ名前
	private String loginName;
	//index.htmlのloginFormと同じ名前
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
