//package com.tsugaruweb.form.newspapermanage;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import com.tsugaruweb.utils.customValidator.DateBetweenValid;
//import com.tsugaruweb.utils.customValidator.SearchConditionValid;
//
//
//@SearchConditionValid
//@DateBetweenValid(fieldFrom="dateFrom",fieldTo="dateTo")
//public class NewsSearchForm implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	private String articleHeader;
//
//	private String articleSentence;
//
//	private String companyName;
//
//	private Date dateFrom;
//
//	private Date dateTo;
//
//	public NewsSearchForm() {
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
//	public Date getDateFrom() {
//		return dateFrom;
//	}
//
//	public void setDateFrom(Date dateFrom) {
//		this.dateFrom = dateFrom;
//	}
//
//	public Date getDateTo() {
//		return dateTo;
//	}
//
//	public void setDateTo(Date dateTo) {
//		this.dateTo = dateTo;
//	}
//
//}