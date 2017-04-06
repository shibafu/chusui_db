package com.example.utils.customValidator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.CustomerMaster;
import com.example.repository.CustomerMasterRepository;

public class SameEmailCustomerValidator implements  ConstraintValidator<SameEmailCustomer,String> {

	private SameEmailCustomer sec;

	@Autowired
	private CustomerMasterRepository cumRepo;


	@Override
	public void initialize(SameEmailCustomer annotation) {
		// TODO 自動生成されたメソッド・スタブ
		sec = annotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO 自動生成されたメソッド・スタブ
		List<CustomerMaster> list = cumRepo.findByUserEmail(value);

		if(list.size() > 0){
			return false;
		}
		return true;
	}

}
