package com.example.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.entity.ChusuiUserMaster;

@Component
public class JdbcChusuiDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

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
}
