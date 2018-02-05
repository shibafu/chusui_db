package com.tsugaruweb.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-06T02:11:26.454+0900")
@StaticMetamodel(NewsArticleMaster.class)
public class NewsArticleMaster_ {
	public static volatile SingularAttribute<NewsArticleMaster, Integer> articleId;
	public static volatile SingularAttribute<NewsArticleMaster, String> articleHeader;
	public static volatile SingularAttribute<NewsArticleMaster, String> articleSentence;
	public static volatile SingularAttribute<NewsArticleMaster, String> companyName;
	public static volatile SingularAttribute<NewsArticleMaster, Date> date;
}
