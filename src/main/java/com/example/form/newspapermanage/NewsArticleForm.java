package com.example.form.newspapermanage;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class NewsArticleForm {

	@NotBlank(message = "※見出しを入力してください")
		private String articleHeader;

	@NotBlank(message = "※記事を入力してください")
		private String articleSentence;

	@NotBlank(message = "※会社名を入力してください")
		private String companyName;

	@NotNull(message = "※日付を入力してください。")
	@DateTimeFormat(pattern="yyyy/MM/dd")
		private Date date;

		private String tableData[];

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

		public String[] getTableData() {
			return tableData;
		}

		public void setTableData(String tableData[]) {
			this.tableData = tableData;
		}
}
