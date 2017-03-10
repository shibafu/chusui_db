package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.entity.NewsArticleMaster;

@Component
public class JdbcNewsArticleDAO {

		@Autowired
		JdbcTemplate jdbcTemplate;

		/**
		 * まだ未完成
		 * @param x_email
		 * @return
		 */
		public List<NewsArticleMaster> findAllCondition(String x_email){
			String sql = "SELECT user_id, user_lastname, user_firstname, user_password, user_email, authority, enabled FROM chusui_user_master WHERE user_email LIKE '" + x_email + "' ;";

			//結果取得
			List<NewsArticleMaster> result = jdbcTemplate.queryForList(sql, NewsArticleMaster.class);


			return result;
		}

//		public  findDate(String x_email){
//			String sql = "SELECT user_id, user_lastname, user_firstname, user_password, user_email, authority, enabled FROM chusui_user_master WHERE user_email LIKE '" + x_email + "' ;";
//
//			//結果取得
//			List<NewsArticleMaster> result = jdbcTemplate.queryForList(sql, NewsArticleMaster.class);
//
//
//			return c_m;
//		}

//		public  findAllConditionAndDate(String x_email){
//			String sql = "SELECT user_id, user_lastname, user_firstname, user_password, user_email, authority, enabled FROM chusui_user_master WHERE user_email LIKE '" + x_email + "' ;";
//
//			//結果取得
//			List<NewsArticleMaster> result = jdbcTemplate.queryForList(sql, NewsArticleMaster.class);
//
//
//			return c_m;
//		}

}
