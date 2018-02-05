package com.tsugaruweb.controller.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tsugaruweb.dao.JdbcAuthorDao;
import com.tsugaruweb.entity.Author;
import com.tsugaruweb.form.AuthorRegisterForm;
import com.tsugaruweb.form.authorManage.AuthorUpdateForm;
import com.tsugaruweb.orders.GroupOrders;
import com.tsugaruweb.repository.AuthorRepository;
import com.tsugaruweb.service.LoginUserDetailsService;
import com.tsugaruweb.utils.StringUtils;

@Controller
@SessionAttributes(names="regForm")
public class AuthorRegisterManagerController {
	/**
	 * 管理画面トップ
	 * @param model
	 * @return
	 */

	//DAO一覧
	@Autowired(required=false)
	JdbcAuthorDao jcdRegi;
	@Autowired(required=false)
	AuthorRepository aumRepo;


	//ユーザーディテールサービス。
	@Autowired
	LoginUserDetailsService cud;

	//□□□□□□□□□□□管理者の管理画面□□□□□□□□□□□□□□□□□□□□□□□□□□□□
	/**
	 * 管理者管理トップ。
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console/author_manage", method = RequestMethod.GET)
	public String management_chusui_user_manage(Model model){
		return "management_console/author_manage/author_management_top";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage/user_register", method = RequestMethod.GET)
	public String author_manage_register(Model model,
			@Validated(GroupOrders.class)@ModelAttribute("AuthoregisterForm")AuthorRegisterForm aurf){

		model.addAttribute("regForm",aurf);

		return "management_console/author_manage/author_register";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage/register_confirm", method = RequestMethod.POST)
	public String register_confirm(Model model,
			@Validated(GroupOrders.class)
			@ModelAttribute("regForm")AuthorRegisterForm aurf,
			BindingResult br){

		//モデルを送る
		model.addAttribute("regForm",aurf);
		//セッションを生成する
		setAuthorRegisterFormses(aurf);

		//疑似パスワード生成
		StringUtils s = new StringUtils();
		String mockpass = s.passwordset(aurf.getPassword().length());

		model.addAttribute("MockPass", mockpass);

		if(br.hasErrors()){
			model.addAttribute("ErrorMessage", "入力項目にエラーがあります");
			return "redirect:/management_console/chusui_user_manage/user_register?error";
		}

		return "management_console/author_manage/author_register_confirm";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @param authrf モデルを受け取る
	 * @return
	 */
	@RequestMapping(value = "/management_console/author_manage/register_complete", method = RequestMethod.POST)
	public String register_complete(Model model,
			@ModelAttribute("regForm")AuthorRegisterForm authrf){

		//パスワード生成
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String password_hash = pe.encode(authrf.getPassword());

		//書き込みinfoリスト作成
		List<String> reqInfo = new ArrayList<String>();

		reqInfo.add(authrf.getFirstName());
		reqInfo.add(authrf.getLastName());
		reqInfo.add(password_hash);
		reqInfo.add(authrf.getEMail());

		jcdRegi.AuthorRegister(reqInfo);


		return "management_console/author_manage/author_register_complete";
	}

	//▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼参照機能ここから▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	/**
	 * 管理者登録画面
	 * @param model
	 * @param curf モデルを受け取る
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage/user_search", method = RequestMethod.POST)
	public String refference(Model model){

		List<Author> lc = aumRepo.findAll();

		model.addAttribute("AllRefference",lc);


		return "management_console/author_manage/author_referrence";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @param userEmail モデルを受け取る
	 * @return
	 */
	@RequestMapping(value = "/managemet_console/author_manage/user_id", method = RequestMethod.GET)
	public String refference_indivUser(Model model,
			@RequestParam("username")String userName){

		List<Author> lc = aumRepo.findByEmail(userName);

		model.addAttribute("UserReffernce",lc);

		return "management_console/author_manage/author_update";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @param userEmail モデルを受け取る
	 * @return
	 */
	@RequestMapping(value = "/managemet_console/chusui_user_manage/userupadate", method = RequestMethod.POST)
	public String indivUser_update(Model model,
			@Validated(GroupOrders.class)@ModelAttribute("authorUpdateForm")AuthorUpdateForm auuf){

		Author updateEntity = new Author();
		updateEntity.setAuthorFirstname(auuf.getFirstName());
		updateEntity.setAuthorLastname(auuf.getLastName());
		updateEntity.setAuthority(auuf.getAuthority());
		updateEntity.setEmail(auuf.getEMail());
		updateEntity.setEnabled(auuf.getEnabled());

		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String password_hash = pe.encode(auuf.getChuUserPassword());

		updateEntity.setPassword(password_hash);

		Author returnEntity = aumRepo.saveAndFlush(updateEntity);

		if(returnEntity == null) {
			System.out.println("><update miss!!");
		}

		return "management_console/author_manage/author_update_complete";
	}


	//▲▲▲▲▲▲▲▲▲▲▲参照機能ここまで▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲


	//□□□□□□□□□□□管理者の管理画面ここまで□□□□□□□□□□□□□□□□□□□□□□□□□□□□

	//管理者セッション管理
	@ModelAttribute("regForm")
	public AuthorRegisterForm setAuthorRegisterFormses(AuthorRegisterForm x_r){
		return x_r;
	}

}
