package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagementController {

	//判断パラメーター
	private final static String MANAGER_SUCCESS = "管理者としてアクセス認証しました";
	private final static String MANAGER_FAILED = "管理者としてのアクセス認証に失敗しました";


	@RequestMapping(value = "maangement_console", method = RequestMethod.POST)
	public String management_top(Model model){
		return "management_console";
	}
	/**
	 * ログイン情報から、管理者かどうかを判断し、アクセス判断をする。
	 * @return 判断パラメーター
	 */
//	private String management_login_judge(Model x_model){
//		x_model.
//
//	}
	/**
	 * 判断パラメーターから遷移ページを作る。
	 * @return 遷移先ページ(文字列)
	 */
//	private String management_login_page(){
//
//	}
}
