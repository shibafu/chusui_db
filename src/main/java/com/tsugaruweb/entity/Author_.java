package com.tsugaruweb.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-06T02:11:26.258+0900")
@StaticMetamodel(Author.class)
public class Author_ {
	public static volatile SingularAttribute<Author, Integer> authorId;
	public static volatile SingularAttribute<Author, String> authorFirstname;
	public static volatile SingularAttribute<Author, String> authorLastname;
	public static volatile SingularAttribute<Author, String> authority;
	public static volatile SingularAttribute<Author, String> email;
	public static volatile SingularAttribute<Author, Boolean> enabled;
	public static volatile SingularAttribute<Author, String> password;
}
