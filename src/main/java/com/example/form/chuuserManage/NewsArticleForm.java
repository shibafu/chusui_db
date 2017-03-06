package com.example.form.chuuserManage;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class NewsArticleForm {

	@NotEmpty(message = "※見出しを入力してください")
		private String articleHeader;

	@NotEmpty(message = "※記事を入力してください")
		private String articleSentence;

	@NotEmpty(message = "※会社名を入力してください")
		private String companyName;

	@NotEmpty(message = "※日付を入力してください。")
	@Pattern(regexp="(\\d{4})/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])",message="その日付は存在しません")
		private Date date;

		public String getArticleHeader() {
			return this.articleHeader;
		}

		public void setArticleHeader(String articleHeader) {
			this.articleHeader = articleHeader;
		}

		public String getArticleSentence() {
			return this.articleSentence;
		}

		public void setArticleSentence(String articleSentence) {
			this.articleSentence = articleSentence;
		}

		public String getCompanyName() {
			return this.companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public Date getDate() {
			return this.date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
}
