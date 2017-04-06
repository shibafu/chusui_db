package com.example.utils.customValidator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.ChusuiUserMaster;
import com.example.repository.ChusuiUserMasterRepository;

public class SameEmailChusuiUserValidator implements ConstraintValidator<SameEmailChusuiUser,String> {

	private SameEmailChusuiUser sec;

	@Autowired
	private ChusuiUserMasterRepository cumRepo;

	@Override
	public void initialize(SameEmailChusuiUser annotation) {
		// TODO 自動生成されたメソッド・スタブ
		sec = annotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO 自動生成されたメソッド・スタブ
		List<ChusuiUserMaster> list = cumRepo.findByUserEmail(value);

		if(list.size() > 0){
			return false;
		}
		return true;
	}


}
