package com.example.controller.manager;

//リクエストメソッドの定数をインポート
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.entity.NewsArticleMaster;
import com.example.form.chuuserManage.NewsArticleForm;
import com.example.repository.NewsArticleMasterRepository;

@Controller
@RequestMapping(value="/management_console/newspaper_manage")
@SessionAttributes(names="NewsArticleForm")
public class NewsPaperManagementController {

	//DAO
	@Autowired
	NewsArticleMasterRepository namRepository;

	/**
	 *
	 * @return
	 */
	@RequestMapping(value="", method = RequestMethod.GET)
	public String newspaperTop(){
		return "management_console/newspaper_manage/newspaper_management";
	}

	/**
	 *
	 * @param model
	 * @param x_newsArticleForm
	 * @param x_bindingResult
	 * @return
	 */
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(Model model){
		return "management_console/newspaper_manage/newspaper_register";
	}

	@RequestMapping(value="/register_confirm", method ={GET,POST})
	public String register_confirm(Model model,
			@Validated NewsArticleForm x_newsArticleForm,
			BindingResult x_bindingResult){

		x_newsArticleForm.getArticleHeader();
		model.addAttribute("NewsArticleForm",x_newsArticleForm);

		if(x_bindingResult.hasErrors()){
			return "redirect:/management_console/newspaper_manage/register?error";
		}

		return "management_console/newspaper_manage/register_confirm";
	}
	@RequestMapping(value="/register_complete", method ={GET,POST})
	public String register_complete(Model model,
			@ModelAttribute("NewsArticleForm")NewsArticleForm x_newsArticleForm){

		namRepository.saveAndFlush(ArticleFormToEntity(x_newsArticleForm));

		return "management_console/newspaper_manage/register_complete";
	}

	private NewsArticleMaster ArticleFormToEntity(NewsArticleForm x_newsArticleForm){

		NewsArticleMaster nam = new NewsArticleMaster();
		nam.setArticleHeader(x_newsArticleForm.getArticleHeader());
		nam.setArticleSentence(x_newsArticleForm.getArticleSentence());
		nam.setCompanyName(x_newsArticleForm.getCompanyName());
		nam.setDate(x_newsArticleForm.getDate());

		return nam;
	}
}