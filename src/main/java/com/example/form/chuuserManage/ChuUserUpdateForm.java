package com.example.form.chuuserManage;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.orders.GroupOrder1;
import com.example.orders.GroupOrder2;

public class ChuUserUpdateForm {
	//chuuser_manage/chuuser_update.htmlのインプットタグFamilyNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※名前を入力してください")
	private String FirstName;

	//chuuser_manage/chuuser_update.htmlのインプットタグLastNameと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※姓を入力してください")
	private String LastName;

	//chuuser_manage/chuuser_update.htmlのインプットタグEMailと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※メールアドレスを入力してください")
	@Pattern(regexp="(^[a-zA-Z0-9!$&*.=^`|~#%'+\\/?_{}-]+@([a-zA-Z0-9_-]+\\.)+[a-zA-Z]{2,4}$)",groups={GroupOrder2.class},message="※正しいメールアドレスの形式を入力してください")
	private String EMail;

	//chuuser_manage/chuuser_update.htmlのインプットタグChuUserPasswordと同じ名前
	@NotEmpty(groups = {GroupOrder1.class},message = "※パスワードを入力してください")
	@Size(min = 8,max= 36 ,groups={GroupOrder2.class}, message = "※パスワードは8文字以上36文字以下で入力してください")
	@Pattern(regexp="[a-zA-Z0-9]*",groups={GroupOrder2.class},message="※パスワードは英数である必要があります。")
	private String ChuUserPassword;

	//chuuser_manage/chuuser_update.html
	@NotEmpty(groups = {GroupOrder1.class},message = "※ユーザー許可エラーです")
	private Boolean Enabled;

	//chuuser_manage/chuuser_update.html
	@NotEmpty(groups = {GroupOrder1.class},message = "※権限を入力してください")
	private String Authority;

	//chuuser_manage/chuuser_update.html
	@NotEmpty(groups = {GroupOrder1.class},message = "※権限を入力してください")
	private String BeforeEmail;

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
	public Boolean getEnabled() {
		return Enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.Enabled = enabled;
	}
	public String getAuthority() {
		return Authority;
	}
	public void setAuthority(String authority) {
		Authority = authority;
	}

	public String getBeforeEmail() {
		return this.BeforeEmail;
	}
	public void setBeforeEmail(String beforeEmail) {
		this.BeforeEmail = beforeEmail;
	}
}
