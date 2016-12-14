package com.example.controller;

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
import com.example.form.LoginForm;
import com.example.orders.GroupOrders;
import com.example.repository.ChusuiUserMasterRepository;



@Controller
public class LoginController {

	public final static String VALIDATION_ERROR = "妥当性エラー";
	public final static String WRONG_NAME_ERROR = "ユーザー未存在エラー";
	public final static String LOGIN_SUCCESSED = "ログイン成功";

	@Autowired
	ChusuiUserMasterRepository userRepos;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String default_g(Model model,
			@ModelAttribute("LoginForm")LoginForm loginForm,
			BindingResult result){

		Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String default_p(Model model,
			@Validated(GroupOrders.class) @ModelAttribute("LoginForm")LoginForm loginForm,
			BindingResult result){

		return "index";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){

        Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());
	    return "index";
	}

	@RequestMapping(value = "/user_top", method = RequestMethod.POST)
	public String user_login(Model model,
			@Validated(GroupOrders.class) @ModelAttribute("LoginForm")LoginForm x_loginForm,
			BindingResult result){

		String local_error_message = "";
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

		ChusuiUserMaster user_pointer = null;

		//バリデーションチェック
		if(x_result.hasErrors()){
			return VALIDATION_ERROR;
		}

		//データベースから名前取得
		List<ChusuiUserMaster> userlist = userRepos.findAll();

		for(ChusuiUserMaster u_m : userlist){
			//名前チェック
			if(u_m.getUserEmail().equals(x_Name)){
				//ヒットした名前のユーザーマスターフォームを取得する
				user_pointer = u_m;
			}
		}

		if(user_pointer != null){
			//ヒットしたユーザー名のパスワードと同じか判断
			if(user_pointer.getUserPassword().equals(x_Password)){
				//ログイン成功ユーザーページ
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
}
