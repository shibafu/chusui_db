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
		 *
		 * @param x_company
		 * @param x_articleHeader
		 * @param x_articleSentence
		 * @return
		 */
		public List<NewsArticleMaster> findAllCondition(String x_company,String x_articleHeader,String x_articleSentence){

			StringBuilder DynamSql = new StringBuilder();

			DynamSql.append("SELECT * FROM news_article_master WHERE ");

			if(!x_company.isEmpty()){
				DynamSql.append("company_name LIKE %" + x_company + "% ");

			}

			if(!x_articleHeader.isEmpty()){
				if(!x_company.isEmpty()){
					DynamSql.append(" OR ");
				}
				DynamSql.append("article_header LIKE %" + x_articleHeader + "% OR");
			}

			if(!x_articleSentence.isEmpty()){
				if(!x_company.isEmpty() || !x_articleHeader.isEmpty()){
					DynamSql.append(" OR ");
				}
				DynamSql.append("article_sentence LIKE %" + x_articleSentence + "% ");
			}

			DynamSql.append(";");

			String sql = DynamSql.toString();
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
