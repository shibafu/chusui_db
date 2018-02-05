package com.tsugaruweb.utils.customValidator;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * ここみて修正
 * http://ziqoo.com/wiki/index.php?Spring%20Boot%20%C6%FE%CE%CF%A5%C1%A5%A7%A5%C3%A5%AF
 * @author chu31
 *
 */
public class DateBetweenValidator implements ConstraintValidator<DateBetweenValid,Object> {

	private DateBetweenValid dbv;
	private String fieldFrom;
	private String fieldTo;
	@Override
	public void initialize(DateBetweenValid annotation) {
		// TODO 自動生成されたメソッド・スタブ
		dbv = annotation;
		fieldFrom = annotation.fieldFrom();
		fieldTo = annotation.fieldTo();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO 自動生成されたメソッド・スタブ

		BeanWrapper beanWrapper = new BeanWrapperImpl(value);

		Date from = (Date)beanWrapper.getPropertyValue(fieldFrom);
		Date to = (Date)beanWrapper.getPropertyValue(fieldTo);

		if(from != null && to != null){
			if(from.compareTo(to) > 0){
				return false;
			}
		}
		return true;
	}

}
