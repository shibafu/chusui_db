package com.example.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String user_login(Model model){

        model.addAttribute("msg","サンプルメッセージ！");
        Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());
	    return "login";
	}
}
