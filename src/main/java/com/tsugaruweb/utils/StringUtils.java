package com.tsugaruweb.utils;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

/**
 * 文字列を操作するユーティリティ　細かいのあると便利。
 * @author chu31
 *
 */
@Component
public class StringUtils {
	/**
	 * 文字数を全て"*"に変換して返す
	 *
	 * @param x_num
	 *            文字数
	 * @return *****....の文字列
	 */
	public String passwordset(Integer x_num) {

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
	public String hash_generator(String raw_password){
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

	/*
	 * 実際の遷移ページ作成
	 * SpringSecurityのおかげで必要なくなったよ！
	 */
//	private String judge_to_page(String error_mess){
//		if(error_mess.equals(LOGIN_SUCCESSED)){
//			return "login";
//		} else if(error_mess.equals(VALIDATION_ERROR)) {
//			return "index";
//		} else if(error_mess.equals(WRONG_NAME_ERROR)){
//			return "index";
//		}
//
//	return "index";
//	}



	//ログインチェックメソッド▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
	/*
	 * ログインページのエラーチェック
	 * SpringSecurityのおかげで必要なくなったよ！
	 */
//	private String login_judge(String x_Name, String x_Password, BindingResult x_result){
//
//		ChusuiUserMaster chuuser_pointer = null;
//		CustomerMaster custuser_pointer = null;
//		//バリデーションチェック
//		if(x_result.hasErrors()){
//			return VALIDATION_ERROR;
//		}
//
//		//中水ユーザーテーブルから名前取得
//		//データベースから名前取得
//		List<ChusuiUserMaster> userlist = userRepos.findAll();
//
//
//
//		/** 	▼▼▼	中水ユーザーかどうかを判断する	▼▼▼	 	**/
//		for(ChusuiUserMaster u_m : userlist){
//			//名前チェック
//			if(u_m.getUserEmail().equals(x_Name)){
//				//ヒットした名前の中水ユーザーエンティティを指し示すポインターを取得する
//				chuuser_pointer = u_m;
//			}
//		}
//
//		if(chuuser_pointer != null){
//			//ヒットしたユーザー名のパスワードと同じか判断
//			if(chuuser_pointer.getUserPassword().equals(x_Password)){
//				//ログイン成功ユーザーページへ
//				return LOGIN_SUCCESSED;
//			}
//		}
//		/**			▲▲▲	中水ユーザーの判断ここまで		▲▲▲	**/
//
//		String hash = hash_generator(x_Password);
//
//		/** 	▼▼▼	顧客ユーザーかどうかを判断する	▼▼▼	 **/
//
//		//今指示している中水ユーザーエンティティを一度破棄
//		chuuser_pointer = null;
//
//		List<CustomerMaster> custlist = CustomRepos.findAll();
//
//		//顧客ユーザー(登録ユーザー)から名前取得
//		for(CustomerMaster cl : custlist){
//			if(cl.getEmail().equals(x_Name)){
//				//ヒットした名前の顧客ユーザーエンティティを指し示すポインターを取得する。
//				custuser_pointer = cl;
//			}
//		}
//
//
//
//		if(custuser_pointer != null){
//			//ヒットした名前の顧客とパスワードが同じか判断
//			//ハッシュ変換してるので、同じように変換すること！
//			if(custuser_pointer.getCustomerPassword().equals(hash)){
//				//ログイン成功ユーザーページへ
//				return LOGIN_SUCCESSED;
//			}
//		}
//
//		//ユーザーがヒットせずエラー終了
//		return WRONG_NAME_ERROR;
//	}
	//ログインチェックメソッドここまで▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲
}
