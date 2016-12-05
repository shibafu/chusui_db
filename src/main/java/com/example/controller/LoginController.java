package com.example.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String default_c(Model model){

		Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

		return "/index";
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
			@RequestParam("username") String username,
			@RequestParam("password")String password){


	    return "index";
	}

}
