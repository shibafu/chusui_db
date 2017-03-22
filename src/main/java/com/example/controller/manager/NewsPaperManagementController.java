package com.example.controller.manager;

//リクエストメソッドの定数をインポート
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.dao.JdbcNewsArticleDAO;
import com.example.entity.NewsArticleMaster;
import com.example.form.newspapermanage.NewsArticleForm;
import com.example.form.newspapermanage.NewsSearchForm;
import com.example.repository.NewsArticleMasterRepository;

@Controller
@RequestMapping(value="/management_console/newspaper_manage")
@SessionAttributes(names="NewsArticleForm")
public class NewsPaperManagementController {

	//DAO
	@Autowired
	NewsArticleMasterRepository namRepository;

	@Autowired
	JdbcNewsArticleDAO newsDao;

	/**
	 *
	 * @return
	 */
	@RequestMapping(value="", method = RequestMethod.GET)
	public String newspaperTop(){
		return "management_console/newspaper_manage/newspaper_management";
	}

	//▼▼▼▼▼▼▼▼▼▼▼▼▼▼登録処理ここから▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	/**
	 *
	 * @param model
	 * @param x_newsArticleForm
	 * @param x_bindingResult
	 * @return
	 */
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(Model model,
			@ModelAttribute NewsArticleForm x_newsArticleForm){

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
			@ModelAttribute("NewsArticle")NewsArticleForm x_newsArticleForm){

		namRepository.saveAndFlush(ArticleFormToEntity(x_newsArticleForm));

		return "management_console/newspaper_manage/register_complete";
	}

	//▲▲▲▲▲▲▲▲▲▲▲▲登録処理ここまで▲▲▲▲▲▲▲▲▲▲▲▲


	//▼▼▼▼▼▼▼▼▼▼▼▼▼▼検索処理ここから▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	@RequestMapping(value="/search", method ={GET,POST})
	public String search(Model model,
			 @ModelAttribute NewsSearchForm x_newsSearchForm,
			 BindingResult result){

		if(!result.hasErrors()){
		model.addAttribute("NewsSearchForm",x_newsSearchForm);
		}

		return "management_console/newspaper_manage/newspaper_search";
	}

	@RequestMapping(value="/reffernce", method ={GET,POST})
	public String reffernce(Model model,
			@Valid @ModelAttribute("NewsSearchForm") NewsSearchForm x_newsSearchForm,
			BindingResult result
			){

		if(result.hasGlobalErrors()){
			return search(model,x_newsSearchForm,result);
		}

		List<NewsArticleMaster> articles = dynamicQuery(x_newsSearchForm);

		model.addAttribute("Articles",articles);

		return "management_console/newspaper_manage/newspaper_referrence";
	}

	@RequestMapping(value="/refference/details", method = RequestMethod.GET)
	public String newsDetailsUpdate(Model model,
			@RequestParam("articleId")Integer articleid){

		NewsArticleMaster nam = namRepository.findOne(articleid);

		model.addAttribute("article",nam);

		return "management_console/newspaper_manage/newspaper_details";
	}

	@RequestMapping(value="/refference/update_confirm", method = RequestMethod.GET)
	public String newsDetailsUpdateConfirm(Model model,
			@ModelAttribute("article")NewsArticleMaster x_NewsArticlMaster){


		namRepository.saveAndFlush(x_NewsArticlMaster);

		return "management_console/newspaper_manage/newspaper_details";
	}
	//▲▲▲▲▲▲▲▲▲▲▲▲検索処理ここまで▲▲▲▲▲▲▲▲▲▲▲▲

	/**
	 * 登録用エンティティ作成
	 * @param x_newsArticleForm
	 * @return
	 */
	private NewsArticleMaster ArticleFormToEntity(NewsArticleForm x_newsArticleForm){

		NewsArticleMaster nam = new NewsArticleMaster();
		nam.setArticleHeader(x_newsArticleForm.getArticleHeader());
		nam.setArticleSentence(x_newsArticleForm.getArticleSentence());
		nam.setCompanyName(x_newsArticleForm.getCompanyName());
		nam.setDate(x_newsArticleForm.getDate());

		return nam;
	}

	/**
	 * 検索用メソッド
	 * @param x_newsSearchForm
	 * @return
	 */
	private List<NewsArticleMaster> dynamicQuery(NewsSearchForm x_newsSearchForm){

		List<NewsArticleMaster> articles = new ArrayList<NewsArticleMaster>();


		if((!x_newsSearchForm.getArticleHeader().isEmpty()
				||!x_newsSearchForm.getArticleSentence().isEmpty()
				||!x_newsSearchForm.getCompanyName().isEmpty())
			&&(x_newsSearchForm.getDateFrom() != null
				||x_newsSearchForm.getDateTo() != null )){

			articles = newsDao.findDateAndCondition(x_newsSearchForm.getCompanyName(),
					x_newsSearchForm.getArticleHeader(),
					x_newsSearchForm.getArticleSentence(),
					x_newsSearchForm.getDateFrom(),
					x_newsSearchForm.getDateTo());

		}else if(!x_newsSearchForm.getArticleHeader().isEmpty()
				||!x_newsSearchForm.getArticleSentence().isEmpty()
				||!x_newsSearchForm.getCompanyName().isEmpty()){

			articles = newsDao.findCondition(x_newsSearchForm.getCompanyName(),
					x_newsSearchForm.getArticleHeader(),
					x_newsSearchForm.getArticleSentence());

		}else if(x_newsSearchForm.getDateFrom() != null
				||x_newsSearchForm.getDateTo() != null){

			articles = newsDao.findDate(x_newsSearchForm.getDateFrom(), x_newsSearchForm.getDateTo());

		}
		return articles;
	}
}