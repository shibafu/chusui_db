package com.example.service.session;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.example.form.ChuUserRegisterForm;

public class ChuUserRegiSession {
	/**
	 *
	 */
	private List<String> UserRegiInfo;

	@Cacheable("chuusertrying")
	public void ChuUserRegiCache(ChuUserRegisterForm cf){
		List<String> ls = new ArrayList<String>();

		UserRegiInfo.add(cf.getFirstName());
		UserRegiInfo.add(cf.getLastName());
		UserRegiInfo.add(cf.getChuUserPassword());
		UserRegiInfo.add(cf.getEMail());
	}

	public void infoTrash(){
		UserRegiInfo = null;
	}
}
