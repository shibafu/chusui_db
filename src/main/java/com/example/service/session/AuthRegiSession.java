package com.example.service.session;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.example.form.AuthorRegisterForm;

public class AuthRegiSession {
	/**
	 *
	 */
	private List<String> UserRegiInfo;

	@Cacheable("AuthRegiSession")
	public void ChuUserRegiCache(AuthorRegisterForm af){
		List<String> ls = new ArrayList<String>();

		UserRegiInfo.add(af.getFirstName());
		UserRegiInfo.add(af.getLastName());
		UserRegiInfo.add(af.getPassword());
		UserRegiInfo.add(af.getEMail());
	}

	public void infoTrash(){
		UserRegiInfo = null;
	}
}
