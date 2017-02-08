package com.example.utils;

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
}
