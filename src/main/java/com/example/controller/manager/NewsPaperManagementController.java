package com.example.controller.manager;

//リクエストメソッドの定数をインポート
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.form.chuuserManage.NewsArticleForm;

@Controller
@RequestMapping(value="/management_console/newspaper_manage")
public class NewsPaperManagementController {

	@RequestMapping(value="", method = RequestMethod.GET)
	public String newspaperTop(){
		return "management_console/newspaper_manage/newspaper_management";
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(Model model,
			@ModelAttribute("NewsArticleForm")NewsArticleForm x_newsArticleForm,
			BindingResult x_bindingResult){
		return "management_console/newspaper_manage/newspaper_register";
	}

	@RequestMapping(value="/register_confirm", method ={GET,POST})
	public String register_confirm(Model model,
			@Validated @ModelAttribute("NewsArticleForm")NewsArticleForm x_newsArticleForm,
			BindingResult x_bindingResult){

		x_newsArticleForm.getArticleHeader();

		if(x_bindingResult.hasErrors()){
			return "redirect:/management_console/newspaper_manage/register?error";
		}
		return "management_console/newspaper_manage/register_confirm";
	}
	@RequestMapping(value="/register_complete", method ={GET,POST})
	public String register_complete(){
		return "management_console/newspaper_manage/register_complete";
	}
}