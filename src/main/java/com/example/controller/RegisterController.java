package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.CustomerMaster;
import com.example.form.RegisterForm;
import com.example.orders.GroupOrders;
import com.example.repository.CustomerMasterRepository;

@Controller
public class RegisterController {

	public final static String VALIDATION_ERROR = "妥当性エラー";
	public final static String REGISTER_SUCCESSED = "登録成功";

	//データアクセスリポジトリ
	@Autowired
	CustomerMasterRepository cusRepos;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model,
			@ModelAttribute("RegisterForm") RegisterForm x_RegisterForm,
			 BindingResult x_BindingResult) {
		return "register";
	}

	@RequestMapping(value = "/reigster_confirm", method = RequestMethod.POST)
	public String rehgister_confim(Model model,
			@Validated(GroupOrders.class)
			@ModelAttribute("RegisterForm") RegisterForm x_RegisterForm,
			 BindingResult x_BindingResult) {
		String toRegister_page;

		//インサートのやり方が分からないでござる
		CustomerMaster x_cm = CustomerMaster_set(x_RegisterForm);
//
		cusRepos.save(x_cm);

		//遷移先ページチェック
		toRegister_page = judge_to_page(register_judge(x_BindingResult));

		return toRegister_page;

	}

	@RequestMapping(value = "/register_complete", method = RequestMethod.POST)
	public String rehgister_complete(Model model, @ModelAttribute("RegisterForm") RegisterForm x_RegisterForm,
			@Validated(GroupOrders.class) BindingResult x_BindingResult) {
		return "register_complete";
	}

	// ログインチェックメソッド▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	/*
	 * ログインページのエラーチェック
	 */
	private String register_judge(BindingResult x_result) {

		// バリデーションチェック
		if (x_result.hasErrors()) {
			return VALIDATION_ERROR;
		}
		return REGISTER_SUCCESSED;
	}

	/*
	 * 実際の遷移ページ作成
	 */
	private String judge_to_page(String error_mess) {
		if (error_mess.equals(VALIDATION_ERROR)) {
			return "register";
		}
		return "register_confirm";
	}

	/**
	 * レジスターフォームから、実体のエンティティを作成し、
	 * セッターに入力する。
	 * で、エンティティを返す
	 * @param レジスターフォーム rf
	 */
	private CustomerMaster CustomerMaster_set(RegisterForm rf){
		CustomerMaster cm = new CustomerMaster();

		cm.setCustomerLastName(rf.getLastName());
		cm.setCustomerFirstName(rf.getFirstName());
		cm.setCompanyName(rf.getCompanyName());
		cm.setAddres(rf.getCompanyAddress());
		cm.setCompanyBlock(rf.getCompanyBlock());
		cm.setEmail(cm.getEmail());
		cm.setCustomerPassword(rf.getCustomerPassword());

		return cm;

	}
}
