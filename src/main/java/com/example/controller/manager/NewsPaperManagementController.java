package com.example.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.chuuserManage.NewsArticleForm;

@Controller
@RequestMapping(value="/management_console/newspaper_manage")
public class NewsPaperManagementController {

	@RequestMapping(value="")
	public String newspaperTop(){
		return "management_console/newspaper_manage/newspaper_management";
	}

	@RequestMapping(value="/register")
	public String register(Model model){
		return "management_console/newspaper_manage/newspaper_register";
	}

	@RequestMapping(value="/register_confirm")
	public String register_confirm(Model model,
			@ModelAttribute("NewsArticleForm")NewsArticleForm x_newsArticleForm ){

		x_newsArticleForm.getArticleHeader();
		return "management_console/newspaper_manage/register_confirm";
	}
	@RequestMapping(value="/register_complete")
	public String register_complete(){
		return "management_console/newspaper_manage/register_complete";
	}
}