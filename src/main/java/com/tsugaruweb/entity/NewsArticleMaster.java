//package com.tsugaruweb.entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.util.Date;
//
//
///**
// * The persistent class for the news_article_master database table.
// * 
// */
//@Entity
//@Table(name="news_article_master")
//@NamedQuery(name="NewsArticleMaster.findAll", query="SELECT n FROM NewsArticleMaster n")
//public class NewsArticleMaster implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name="article_id")
//	private Integer articleId;
//
//	@Column(name="article_header")
//	private String articleHeader;
//
//	@Column(name="article_sentence")
//	private String articleSentence;
//
//	@Column(name="company_name")
//	private String companyName;
//
//	@Temporal(TemporalType.DATE)
//	private Date date;
//
//	public NewsArticleMaster() {
//	}
//
//	public Integer getArticleId() {
//		return this.articleId;
//	}
//
//	public void setArticleId(Integer articleId) {
//		this.articleId = articleId;
//	}
//
//	public String getArticleHeader() {
//		return this.articleHeader;
//	}
//
//	public void setArticleHeader(String articleHeader) {
//		this.articleHeader = articleHeader;
//	}
//
//	public String getArticleSentence() {
//		return this.articleSentence;
//	}
//
//	public void setArticleSentence(String articleSentence) {
//		this.articleSentence = articleSentence;
//	}
//
//	public String getCompanyName() {
//		return this.companyName;
//	}
//
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
//
//	public Date getDate() {
//		return this.date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//}