package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AuthorRepository {

	//IDで検索するメソッド
	public Integer findById();
	//Emailで検索するメソッド
	public Integer findByEmail();
}
