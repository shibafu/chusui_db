package com.example.utils.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.form.newspapermanage.NewsSearchForm;

public class DateBetweenValidator implements ConstraintValidator<DateBetweenValid,NewsSearchForm> {

	private DateBetweenValid dbv;
	@Override
	public void initialize(DateBetweenValid annotation) {
		// TODO 自動生成されたメソッド・スタブ
		dbv = annotation;
	}

	@Override
	public boolean isValid(NewsSearchForm value, ConstraintValidatorContext context) {
		// TODO 自動生成されたメソッド・スタブ

		if(value.getDateFrom().compareTo(value.getDateTo()) < 0){
			return false;
		}
		return true;
	}

}
