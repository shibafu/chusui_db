package com.example.form.newspapermanage;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the news_article_master database table.
 *
 */
@Entity
@Table(name="news_article_master")
@NamedQuery(name="NewsArticleMaster.findAll", query="SELECT n FROM NewsArticleMaster n")
public class NewsSearchForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String articleHeader;

	private String articleSentence;

	private String companyName;

	private Date dateFrom;
	private Date dateTo;

	public NewsSearchForm() {
	}

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

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

}