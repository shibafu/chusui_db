package com.example.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.orders.GroupOrder1;
import com.example.orders.GroupOrder2;
import com.example.orders.GroupOrder3;
import com.example.utils.customValidator.SameEmailChusuiUser;
import com.example.utils.customValidator.SameEmailCustomer;

public class ChuUserRegisterForm {
	//register.htmlのインプットタグFamilyNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※名前を入力してください")
	private String FirstName;

	//register.htmlのインプットタグLastNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※姓を入力してください")
	private String LastName;

	//register.htmlのインプットタグEMailと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※メールアドレスを入力してください")
	@Pattern(regexp="(^[a-zA-Z0-9!$&*.=^`|~#%'+\\/?_{}-]+@([a-zA-Z0-9_-]+\\.)+[a-zA-Z]{2,4}$)",groups={GroupOrder2.class},message="※正しいメールアドレスの形式を入力してください")
	@SameEmailCustomer(groups={GroupOrder3.class})
	@SameEmailChusuiUser(groups={GroupOrder3.class})
	private String EMail;

	//register.htmlのインプットタグChuUserPasswordと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※パスワードを入力してください")
	@Size(min = 8,max= 36 ,groups={GroupOrder2.class}, message = "※パスワードは8文字以上36文字以下で入力してください")
	@Pattern(regexp="[a-zA-Z0-9]*",groups={GroupOrder2.class},message="※パスワードは英数である必要があります。")
	private String ChuUserPassword;

	public void setFirstName(String x_FirstName){
		this.FirstName = x_FirstName;
	}
	public String getFirstName(){
		return this.FirstName;
	}

	public void setLastName(String x_LastName){
		this.LastName = x_LastName;
	}
	public String getLastName(){
		return this.LastName;
	}

	public void setEMail(String x_EMail){
		this.EMail = x_EMail;
	}
	public String getEMail(){
		return this.EMail;
	}
	public void setChuUserPassword(String x_ChuUserPassword){
		this.ChuUserPassword = x_ChuUserPassword;
	}
	public String getChuUserPassword(){
		return this.ChuUserPassword;
	}
}
