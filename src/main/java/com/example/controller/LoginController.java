package com.example.controller;

//リクエストメソッドの定数をインポート
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.NewsArticleMaster;
import com.example.form.LoginForm;
import com.example.orders.GroupOrders;
import com.example.repository.AuthorRepository;
import com.example.repository.NewsArticleMasterRepository;
import com.example.repository.UserMasterRepository;
import com.example.service.LoginUserDetails;



@Controller
public class LoginController {

	public final static String VALIDATION_ERROR = "妥当性エラー";
	public final static String WRONG_NAME_ERROR = "ユーザー未存在エラー";
	public final static String LOGIN_SUCCESSED = "ログイン成功";

	@Autowired
	AuthorRepository authorRepos;
	@Autowired
	UserMasterRepository umRepos;
	@Autowired
	NewsArticleMasterRepository namRepos;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String domain_redirect(){

		return "redirect:/user_top";
	}

	/**
	 *
	 * @param model モデル
	 * @param error ログイン時に送られるパラメーターエラーの時空白が送られてくる
	 * @param x_loginForm　ログイン情報を送るフォーム
	 * @param result　バリデーション結果。
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String default_g(Model model,
			@RequestParam Optional<String> error,
			@Validated(GroupOrders.class) @ModelAttribute("LoginForm")LoginForm x_loginForm,
			BindingResult result){

		//初めてのラムダ式
		//orElseGet()でerrorがnullの時に起動。それ以外はパラメーターの値が代入される。
		String erOrNot = error.orElseGet(() -> "empty!");

		if(erOrNot.equals("")){
			model.addAttribute("ErrorMessage","ユーザー名とパスワードが違います。");
		}

		return "index";
	}

	/**
	 *
	 * @param model
	 * @param cudService 認証情報　ユーザーディテールサービスの形式で取得する
	 * @return ビューのアドレス
	 */
	@RequestMapping(value = "/user_top", method = {GET,POST})
	public String user_login(Model model,
			Principal principal){

		//ユーザー情報を取得
		Authentication auth = (Authentication)principal;
		LoginUserDetails loginUser = (LoginUserDetails)auth.getPrincipal();

		//ユーザー名表示
		model.addAttribute("UserName",loginUser.getUsername());
        Calendar cal = Calendar.getInstance();
        model.addAttribute("today",cal.getTime().toString());

        //日付順にデータを取得。
        List<NewsArticleMaster> namLis_raw = namRepos.findAll(new Sort(new Order(Sort.Direction.DESC, "date")));
    	List<NewsArticleMaster> namLis = new ArrayList<NewsArticleMaster>();

    	Iterator<NewsArticleMaster> it = namLis_raw.iterator();

        //6つだけ取得 イテレーターを使ったので若干汚くなってしまった。
        for(int i =0;i<6;i++){
        	if(it.hasNext()){
        	namLis.add(it.next());
        	}
        }

        model.addAttribute("FrontNews",namLis);

	    return  "user_top_page";
	}
}
