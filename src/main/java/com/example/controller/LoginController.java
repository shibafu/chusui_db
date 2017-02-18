package com.example.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.form.LoginForm;
import com.example.orders.GroupOrders;
import com.example.repository.ChusuiUserMasterRepository;
import com.example.repository.CustomerMasterRepository;
import com.example.service.ChuUserDetails;



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
	public String domain_redirect(){

		return "redirect:/user_top";
	}

	/**
	 *
	 * @param model モデル
	 * @param error ログイン時に送られるパラメーターエラーの時空白が送られてくる
	 * @param x_loginForm　ログイン情報を送るフォーム
	 * @param result　バリデーション結果。
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String default_g(Model model,
			@RequestParam Optional<String> error,
			@Validated(GroupOrders.class) @ModelAttribute("LoginForm")LoginForm x_loginForm,
			BindingResult result){

		//初めてのラムダ式
		//orElseGet()でerrorがnullの時に起動。それ以外はパラメーターの値が代入される。
		String erOrNot = error.orElseGet(() -> "empty!");

		if(erOrNot.equals("")){
			model.addAttribute("ErrorMessage","ユーザー名とパスワードが違います。");
		}

		return "index";
	}

	/**
	 *
	 * @param model
	 * @param cudService 認証情報　ユーザーディテールサービスの形式で取得する
	 * @return ビューのアドレス
	 */
	@RequestMapping(value = "/user_top", method = RequestMethod.GET)
	public String user_login(Model model,
			Principal principal){

		Authentication auth = (Authentication)principal;
	    ChuUserDetails cudS = (ChuUserDetails)auth.getPrincipal();
		
		model.addAttribute("UserName",cudS.getUsername());
        Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

	    return  "user_top_page";
	}

	/**
	 *
	 * @param model モデル
	 * @return
	 */
	@RequestMapping(value = "/user_top", method = RequestMethod.POST)
	public String user_login_p(Model model,
			Principal principal){


		Authentication auth = (Authentication)principal;
	    ChuUserDetails cudS = (ChuUserDetails)auth.getPrincipal();
		
		model.addAttribute("UserName",cudS.getUsername());
        Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

	    return  "user_top_page";
	}
}
