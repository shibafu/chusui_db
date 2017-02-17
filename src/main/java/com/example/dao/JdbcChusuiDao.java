package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.entity.ChusuiUserMaster;
import com.example.repository.ChusuiUserMasterRepository;

@Component
public class JdbcChusuiDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ChusuiUserMasterRepository cuRepository;


	public ChusuiUserMaster findByUseemail(String x_email){
		String sql = "SELECT user_id, user_lastname, user_firstname, user_password, user_email, authority, enabled FROM chusui_user_master WHERE user_email LIKE '" + x_email + "' ;";

		ChusuiUserMaster c_m = new ChusuiUserMaster();
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);

		c_m.setUserId((Integer)result.get("user_id"));
		c_m.setUserLastName((String)result.get("user_lastname"));
		c_m.setUserFirstName((String)result.get("user_firstname"));
		c_m.setUserPassword((String)result.get("user_password"));
		c_m.setUserEmail((String)result.get("user_email"));
		c_m.setAuthority((String)result.get("authority"));
		c_m.setEnabled((Boolean)result.get("enabled"));

		return c_m;
	}

	/**
	 * ユーザー登録アクセス
	 * @param x_cuUserRegisterエンティティに書き込む情報
	 * 	1,名前2,姓3,パスワードハッシュ,4.Eメール
	 * @return
	 */
	public boolean ChusuiUserRegister(List<String>x_cuUserRegister){
		//エンティティ作成
		//姓　名　パスワード　Eメールの順番
		ChusuiUserMaster c_m = new ChusuiUserMaster();
		c_m.setUserFirstName(x_cuUserRegister.get(0));
		c_m.setUserLastName(x_cuUserRegister.get(1));
		c_m.setUserPassword(x_cuUserRegister.get(2));
		c_m.setUserEmail(x_cuUserRegister.get(3));
		c_m.setAuthority("ROLE_ADMIN");
		c_m.setEnabled(true);

		//書き込み
		if(cuRepository.saveAndFlush(c_m) != null){
			return true;
		}else{
			return false;
		}
	}
}
