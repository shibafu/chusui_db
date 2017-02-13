package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.form.ChuUserRegisterForm;
import com.example.orders.GroupOrders;
import com.example.utils.StringUtils;

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
	@RequestMapping(value = "/management_console/chusui_user_manage/user_register", method = RequestMethod.POST)
	public String chuuser_manage_register(Model model,
			@ModelAttribute("ChuUserRegisterForm")ChuUserRegisterForm curf){
		return "management_console/chuuser_manage/chuuser_register";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage/register_confirm", method = RequestMethod.POST)
	public String register_confirm(Model model,
			@Validated(GroupOrders.class)
			@ModelAttribute("ChuUserRegisterForm")ChuUserRegisterForm curf,
			BindingResult br){

		model.addAttribute("regForm", curf);
		StringUtils s = new StringUtils();
		String mockpass = s.passwordset(curf.getChuUserPassword().length());

		model.addAttribute("MockPass", mockpass);

		if(br.hasErrors()){
			return "redirect:/management_console/chuuser_manage/chuuser_register?error";
		}

		return "management_console/chuuser_manage/chuuser_register_confirm";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage/register_complete", method = RequestMethod.POST)
	public String register_complete(Model model){
		return "management_console/chuuser_manage/chuuser_register_confirm";
	}

	//□□□□□□□□□□□管理者の管理画面ここまで□□□□□□□□□□□□□□□□□□□□□□□□□□□□
}
