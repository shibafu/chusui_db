package com.example.controller;

import java.security.MessageDigest;

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

	private RegisterForm rf_inclass = null;

	// データアクセスリポジトリ
	@Autowired
	CustomerMasterRepository cusRepos;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model, @ModelAttribute("RegisterForm") RegisterForm x_RegisterForm,
			BindingResult x_BindingResult) {
		return "register";
	}

	@RequestMapping(value = "/reigster_confirm", method = RequestMethod.POST)
	public String rehgister_confim(Model model,
			@Validated(GroupOrders.class) @ModelAttribute("RegisterForm") RegisterForm x_RegisterForm,
			BindingResult x_BindingResult) {
		String toRegister_page;
		String MockPassword = null;

		// 遷移先ページチェック
		toRegister_page = judge_to_page(register_judge(x_BindingResult));

		// ページ遷移に成功するなら、パスワード疑似文字列生成
		if (toRegister_page.equals("register_confirm")) {
			rf_inclass = x_RegisterForm;
			MockPassword = passwordset(x_RegisterForm.getCustomerPassword().length());
			model.addAttribute("mockpassword", MockPassword);
		}

		return toRegister_page;
	}

	@RequestMapping(value = "/register_complete", method = RequestMethod.POST)
	public String rehgister_complete(Model model, @ModelAttribute("RegisterForm") RegisterForm x_RegisterForm,
			@Validated(GroupOrders.class) BindingResult x_BindingResult) {

		// インサートのやり方が分からないでござる
		CustomerMaster x_cm = CustomerMaster_set(rf_inclass);

		cusRepos.save(x_cm);

		rf_inclass = null;
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
	 * レジスターフォームから、実体のエンティティを作成し、 セッターに入力する。 で、エンティティを返す
	 *
	 * @param レジスターフォーム
	 *            rf
	 */
	private CustomerMaster CustomerMaster_set(RegisterForm rf) {
		CustomerMaster cm = new CustomerMaster();

		cm.setCustomerLastName(rf.getLastName());
		cm.setCustomerFirstName(rf.getFirstName());
		cm.setCompanyName(rf.getCompanyName());
		cm.setAddres(rf.getCompanyAddress());
		cm.setCompanyBlock(rf.getCompanyBlock());
		cm.setEmail(rf.getEMail());

		// ハッシュ生成
		String hashGenerated = hash_generator(rf.getCustomerPassword());
		cm.setCustomerPassword(hashGenerated);

		return cm;

	}

	/**
	 * 文字数を全て"*"に変換して返す
	 *
	 * @param x_num
	 *            文字数
	 * @return *****....の文字列
	 */
	private String passwordset(Integer x_num) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x_num; i++) {
			sb.append('*');
		}

		return sb.toString();
	}

	/**
	 * ハッシュ生成機
	 * @param raw_password 生パスワード
	 * @return ハッシュ値
	 */
	private String hash_generator(String raw_password){
		StringBuilder sb = new StringBuilder();

		try{
		MessageDigest md = MessageDigest.getInstance("SHA-512");

		md.update(raw_password.getBytes());

		for(byte b:md.digest()){
			String hex = String.format("%02x", b);
			sb.append(hex);
		}

		} catch (Exception e) {
            e.printStackTrace();
		}
		return sb.toString();
	}

}
