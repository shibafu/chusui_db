package com.example.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
