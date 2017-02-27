package com.example.controller.manager;

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

import com.example.dao.JdbcChusuiDao;
import com.example.entity.ChusuiUserMaster;
import com.example.form.ChuUserRegisterForm;
import com.example.form.chuuserManage.ChuUserUpdateForm;
import com.example.orders.GroupOrders;
import com.example.repository.ChusuiUserMasterRepository;
import com.example.service.ChuUserDetailService;
import com.example.utils.StringUtils;

@Controller
@SessionAttributes(names="regForm")
public class ChuRegisterManagerController {
	/**
	 * 管理画面トップ
	 * @param model
	 * @return
	 */

	//DAO一覧
	@Autowired
	JdbcChusuiDao jcdRegi;
	@Autowired
	ChusuiUserMasterRepository cumRepo;


	//ユーザーディテールサービス。
	@Autowired
	ChuUserDetailService cud;

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
	@RequestMapping(value = "/management_console/chusui_user_manage/user_register", method = RequestMethod.GET)
	public String chuuser_manage_register(Model model,
			@ModelAttribute("ChuUserRegisterForm")ChuUserRegisterForm curf){

		model.addAttribute("regForm",curf);

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
			@ModelAttribute("regForm")ChuUserRegisterForm curf,
			BindingResult br){

		//モデルを送る
		model.addAttribute("regForm",curf);
		//セッションを生成する
		setChuUserRegisterFormses(curf);

		//疑似パスワード生成
		StringUtils s = new StringUtils();
		String mockpass = s.passwordset(curf.getChuUserPassword().length());

		model.addAttribute("MockPass", mockpass);

		if(br.hasErrors()){
			model.addAttribute("ErrorMessage", "入力項目にエラーがあります");
			return "redirect:/management_console/chusui_user_manage/user_register?error";
		}

		return "management_console/chuuser_manage/chuuser_register_confirm";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @param curf モデルを受け取る
	 * @return
	 */
	@RequestMapping(value = "/management_console/chusui_user_manage/register_complete", method = RequestMethod.POST)
	public String register_complete(Model model,
			@ModelAttribute("regForm")ChuUserRegisterForm curf){

		//パスワード生成
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String password_hash = pe.encode(curf.getChuUserPassword());

		//書き込みinfoリスト作成
		List<String> reqInfo = new ArrayList<String>();

		reqInfo.add(curf.getFirstName());
		reqInfo.add(curf.getLastName());
		reqInfo.add(password_hash);
		reqInfo.add(curf.getEMail());

		jcdRegi.ChusuiUserRegister(reqInfo);


		return "management_console/chuuser_manage/chuuser_register_complete";
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

		List<ChusuiUserMaster> lc =cumRepo.findAll();

		model.addAttribute("AllRefference",lc);


		return "management_console/chuuser_manage/chuuser_referrence";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @param userEmail モデルを受け取る
	 * @return
	 */
	@RequestMapping(value = "/managemet_console/chusui_user_manage/user_id", method = RequestMethod.GET)
	public String refference_indivUser(Model model,
			@RequestParam("username")String userName){

		List<ChusuiUserMaster> lc = cumRepo.findByUserEmail(userName);

		model.addAttribute("UserReffernce",lc);

		return "management_console/chuuser_manage/chuuser_update";
	}

	/**
	 * 管理者登録画面
	 * @param model
	 * @param userEmail モデルを受け取る
	 * @return
	 */
	@RequestMapping(value = "/managemet_console/chusui_user_manage/userupadate", method = RequestMethod.POST)
	public String indivUser_update(Model model,
			@ModelAttribute("ChuUserUpdateForm")ChuUserUpdateForm cuuf){

		//更新数受け取る
		Integer result_count = cud.updateChusuiUser(cuuf);

		System.out.println(result_count);
		return "management_console/chuuser_manage/chuuser_update_complete";
	}


	//▲▲▲▲▲▲▲▲▲▲▲参照機能ここまで▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲


	//□□□□□□□□□□□管理者の管理画面ここまで□□□□□□□□□□□□□□□□□□□□□□□□□□□□

	//管理者セッション管理
	@ModelAttribute("regForm")
	public ChuUserRegisterForm setChuUserRegisterFormses(ChuUserRegisterForm x_r){
		return x_r;
	}

}
