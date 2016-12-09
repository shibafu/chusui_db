package com.example.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.form.LoginForm;
import com.example.orders.GroupOrders;

@Controller
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String default_g(Model model){

		Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String default_p(Model model,
			@Validated(GroupOrders.class) @ModelAttribute("LoginForm")LoginForm loginForm,
			BindingResult result){

		if(result.hasErrors()){
			return "index";
		}

		model.addAttribute("loginName",loginForm.getLoginName());
		model.addAttribute("loginPassword",loginForm.getLoginPassword());

		return "login";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){

        model.addAttribute("msg","サンプルメッセージ！");
        Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());
	    return "index";
	}

	@RequestMapping(value = "/user_top", method = RequestMethod.POST)
	public String user_login(Model model,
			@Validated(GroupOrders.class) @ModelAttribute("LoginForm")LoginForm loginForm,
			BindingResult result){

		if(result.hasErrors()){
			return "index";
		}

		model.addAttribute("loginName",loginForm.getLoginName());
		model.addAttribute("loginPassword",loginForm.getLoginPassword());

	    return "login";
	}

}
