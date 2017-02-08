package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagementController {

	/**
	 * 管理画面トップ
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console", method = RequestMethod.GET)
	public String management_top(Model model){
		return "management_console/management_console";
	}

	//□□□□□□□□□□□管理者の管理画面□□□□□□□□□□□□□□□□□□□□□□□□□□□□
	/**
	 * 管理者管理トップ。
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage", method = RequestMethod.GET)
	public String management_chusui_user_manage(Model model){
		return "management_console/chuuser_manage/chuuser_management_top";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage/user_register", method = RequestMethod.GET)
	public String chuuser_manage_register(Model model){
		return "management_console/chuuser_manage/chuuser_register";
	}


	//□□□□□□□□□□□管理者の管理画面ここまで□□□□□□□□□□□□□□□□□□□□□□□□□□□□
}
