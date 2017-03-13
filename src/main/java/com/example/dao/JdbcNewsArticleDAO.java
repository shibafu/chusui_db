package com.example.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	public List<NewsArticleMaster> findCondition(String x_company, String x_articleHeader,
			String x_articleSentence) {

		StringBuilder DynamSql = new StringBuilder();

		DynamSql.append("SELECT * FROM news_article_master WHERE ");

		if (!x_company.isEmpty()) {
			DynamSql.append("company_name LIKE %" + x_company + "% ");

		}

		if (!x_articleHeader.isEmpty()) {
			if (!x_company.isEmpty()) {
				DynamSql.append(" OR ");
			}
			DynamSql.append("article_header LIKE %" + x_articleHeader + "% OR");
		}

		if (!x_articleSentence.isEmpty()) {
			if (!x_company.isEmpty() || !x_articleHeader.isEmpty()) {
				DynamSql.append(" OR ");
			}
			DynamSql.append("article_sentence LIKE %" + x_articleSentence + "% ");
		}

		DynamSql.append(";");

		String sql = DynamSql.toString();
		// 結果取得
		List<NewsArticleMaster> result = jdbcTemplate.queryForList(sql, NewsArticleMaster.class);

		return result;
	}

	/**
	 * 日付検索のみ
	 * @param x_From
	 * @param x_To
	 * @return
	 */
	public List<NewsArticleMaster> findDate(Date x_From, Date x_To){
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * FROM news_article_master WHERE ");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			if(x_From != null && x_To != null){
				String FromDate = sdf.format(x_From);
				String ToDate = sdf.format(x_To);

				sb.append("date >= '" + FromDate + "' ");
				sb.append("AND date <= '" + ToDate + "' ");

			}else if(x_From != null){
				String FromDate = sdf.format(x_From);
				sb.append("date >= '" + FromDate + "' ");
			}else if(x_To != null){
				String ToDate = sdf.format(x_To);
				sb.append("date <= '" + ToDate + "' ");
			}else{
				return null;
			}

			String sql = sb.toString();
			//結果取得
			List<NewsArticleMaster> result = jdbcTemplate.queryForList(sql, NewsArticleMaster.class);

			return result;
		}

	public List<NewsArticleMaster> findDateAndCondition(String x_company, String x_articleHeader,
			String x_articleSentence, Date x_From, Date x_To){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM news_article_master WHERE");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (!x_company.isEmpty()) {
			sb.append("company_name LIKE %" + x_company + "% ");

		}

		if (!x_articleHeader.isEmpty()) {
			if (!x_company.isEmpty()) {
				sb.append(" OR ");
			}
			sb.append("article_header LIKE %" + x_articleHeader + "% OR");
		}

		if (!x_articleSentence.isEmpty()) {
			if (!x_company.isEmpty() || !x_articleHeader.isEmpty()) {
				sb.append(" OR ");
			}
			sb.append("article_sentence LIKE %" + x_articleSentence + "% ");
		}


		if(x_From != null && x_To != null){
			String FromDate = sdf.format(x_From);
			String ToDate = sdf.format(x_To);

			sb.append("AND date >= '" + FromDate + "' ");
			sb.append("AND date <= '" + ToDate + "' ");

		}else if(x_From != null){
			String FromDate = sdf.format(x_From);
			sb.append("AND date >= '" + FromDate + "' ");
		}else if(x_To != null){
			String ToDate = sdf.format(x_To);
			sb.append("AND date <= '" + ToDate + "' ");
		}else{
			return null;
		}

		String sql = sb.toString();
	//結果取得
		List<NewsArticleMaster> result = jdbcTemplate.queryForList(sql, NewsArticleMaster.class);

		return result;
	}
}
