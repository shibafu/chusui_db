package com.example.controller;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.ChusuiUserMaster;
import com.example.entity.CustomerMaster;
import com.example.form.LoginForm;
import com.example.orders.GroupOrders;
import com.example.repository.ChusuiUserMasterRepository;
import com.example.repository.CustomerMasterRepository;



@Controller
public class LoginController {

	public final static String VALIDATION_ERROR = "妥当性エラー";
	public final static String WRONG_NAME_ERROR = "ユーザー未存在エラー";
	public final static String LOGIN_SUCCESSED = "ログイン成功";

	@Autowired
	ChusuiUserMasterRepository userRepos;
	@Autowired
	CustomerMasterRepository CustomRepos;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String default_g(Model model,
			@ModelAttribute("LoginForm")LoginForm loginForm,
			BindingResult result){

		Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

		return "index";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(Model model){
//
//        Calendar cal = Calendar.getInstance();
//        model.addAttribute("today",cal.getTime().toString());
//	    return "index";
//	}

	@RequestMapping(value = "/user_top", method = RequestMethod.POST)
	public String user_login(Model model,
			@Validated(GroupOrders.class) @ModelAttribute("LoginForm")LoginForm x_loginForm,
			BindingResult result){

		String local_error_message = "";
		//変更確認
		//遷移先を判断する
		String l_judge = login_judge(x_loginForm.getLoginName()
				,x_loginForm.getLoginPassword()
				,result);

		if(l_judge.equals(WRONG_NAME_ERROR)){
			local_error_message = "ユーザー名とパスワードが違います";
		}

		model.addAttribute("ErrorMessage", local_error_message);
		model.addAttribute("userName", x_loginForm.getLoginName());

        Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

	    return  judge_to_page(l_judge);
	}

	//ログインチェックメソッド▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	/*
	 * ログインページのエラーチェック
	 */
	private String login_judge(String x_Name, String x_Password, BindingResult x_result){

		ChusuiUserMaster chuuser_pointer = null;
		CustomerMaster custuser_pointer = null;
		//バリデーションチェック
		if(x_result.hasErrors()){
			return VALIDATION_ERROR;
		}

		//中水ユーザーテーブルから名前取得
		//データベースから名前取得
		List<ChusuiUserMaster> userlist = userRepos.findAll();



		/** 	▼▼▼	中水ユーザーかどうかを判断する	▼▼▼	 	**/
		for(ChusuiUserMaster u_m : userlist){
			//名前チェック
			if(u_m.getUserEmail().equals(x_Name)){
				//ヒットした名前の中水ユーザーエンティティを指し示すポインターを取得する
				chuuser_pointer = u_m;
			}
		}

		if(chuuser_pointer != null){
			//ヒットしたユーザー名のパスワードと同じか判断
			if(chuuser_pointer.getUserPassword().equals(x_Password)){
				//ログイン成功ユーザーページへ
				return LOGIN_SUCCESSED;
			}
		}
		/**			▲▲▲	中水ユーザーの判断ここまで		▲▲▲	**/

		String hash = hash_generator(x_Password);

		/** 	▼▼▼	顧客ユーザーかどうかを判断する	▼▼▼	 **/

		//今指示している中水ユーザーエンティティを一度破棄
		chuuser_pointer = null;

		List<CustomerMaster> custlist = CustomRepos.findAll();

		//顧客ユーザー(登録ユーザー)から名前取得
		for(CustomerMaster cl : custlist){
			if(cl.getEmail().equals(x_Name)){
				//ヒットした名前の顧客ユーザーエンティティを指し示すポインターを取得する。
				custuser_pointer = cl;
			}
		}



		if(custuser_pointer != null){
			//ヒットした名前の顧客とパスワードが同じか判断
			//ハッシュ変換してるので、同じように変換すること！
			if(custuser_pointer.getCustomerPassword().equals(hash)){
				//ログイン成功ユーザーページへ
				return LOGIN_SUCCESSED;
			}
		}

		//ユーザーがヒットせずエラー終了
		return WRONG_NAME_ERROR;
	}

	/*
	 * 実際の遷移ページ作成
	 */
	private String judge_to_page(String error_mess){
		if(error_mess.equals(LOGIN_SUCCESSED)){
			return "login";
		} else if(error_mess.equals(VALIDATION_ERROR)) {
			return "index";
		} else if(error_mess.equals(WRONG_NAME_ERROR)){
			return "index";
		}

	return "index";
	}
	//ログインチェックメソッドここまで▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
	/**
	 * ハッシュ生成機
	 * @param raw_password 生パスワード
	 * @return ハッシュ値
	 */
	private String hash_generator(String raw_password){
		StringBuilder sb = new StringBuilder();

		try{
		MessageDigest md = MessageDigest.getInstance("SHA-512");

		md.update(raw_password.getBytes());

		for(byte b:md.digest()){
			String hex = String.format("%02x", b);
			sb.append(hex);
		}

		} catch (Exception e) {
            e.printStackTrace();
		}
		return sb.toString();
	}
}
