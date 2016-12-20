package com.example.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.orders.GroupOrder1;
import com.example.orders.GroupOrder2;

public class RegisterForm {
	//register.htmlのインプットタグFamilyNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※姓名を入力してください")
	private String FamilyName;

	//register.htmlのインプットタグLastNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※姓名を入力してください")
	private String LastName;

	//register.htmlのインプットタグCompanyNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※姓名を入力してください")
	private String CompanyName;

	//register.htmlのインプットタグCompanyBlockと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※部署名を入力してください")
	private String CompanyBlock;

	//register.htmlのインプットタグCompanyAddressと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※会社住所を入力してください")
	private String CompanyAddress;

	//register.htmlのインプットタグEMailと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※メールアドレスを入力してください")
	@Pattern(regexp="([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-])",groups={GroupOrder2.class},message="※正しいメールアドレスの形式を入力してください")
	private String EMail;

	//register.htmlのインプットタグCustomerPasswordと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※パスワードを入力してください")
	@Size(min = 8,max= 36 ,groups={GroupOrder2.class}, message = "※パスワードは8文字以上36文字以下で入力してください")
	@Pattern(regexp="[a-zA-Z0-9]*",groups={GroupOrder2.class},message="※パスワードは英数である必要があります。")
	private String CustomerPassword;

	public void setFamilyName(String x_FamilyName){
		this.FamilyName = x_FamilyName;
	}
	public String getFamilyName(){
		return this.FamilyName;
	}

	public void setLastName(String x_LastName){
		this.LastName = x_LastName;
	}
	public String getLastName(){
		return this.LastName;
	}
	public void setCompanyName(String x_CompanyName){
		this.CompanyName = x_CompanyName;
	}
	public String getCompanyName(){
		return this.CompanyName;
	}

	public void setCompanyBlock(String x_CompanyBlock){
		this.CompanyBlock = x_CompanyBlock;
	}
	public String getCompanyBlock(){
		return this.CompanyBlock;
	}
	public void setCompanyAddress(String x_CompanyAddress){
		this.CompanyAddress = x_CompanyAddress;
	}
	public String getCompanyAddress(){
		return this.CompanyName;
	}

	public void setEMail(String x_EMail){
		this.EMail = x_EMail;
	}
	public String getEMail(){
		return this.EMail;
	}
	public void setCustomerPassword(String x_CustomerPassword){
		this.CustomerPassword = x_CustomerPassword;
	}
	public String getCustomerPassword(){
		return this.CustomerPassword;
	}
}
