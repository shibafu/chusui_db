//package com.tsugaruweb.utils.customValidator;
//
//import java.util.List;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.tsugaruweb.entity.UserMaster;
//import com.tsugaruweb.repository.UserMasterRepository;
//
//public class SameEmailUserValidator implements  ConstraintValidator<SameEmailUser,String> {
//
//	private SameEmailUser seu;
//
//	@Autowired
//	private UserMasterRepository umRepo;
//
//
//	@Override
//	public void initialize(SameEmailUser annotation) {
//		// TODO 自動生成されたメソッド・スタブ
//		seu = annotation;
//	}
//
//	@Override
//	public boolean isValid(String value, ConstraintValidatorContext context) {
//		// TODO 自動生成されたメソッド・スタブ
//		List<UserMaster> list = umRepo.findByUserEmail(value);
//
//		if(list.size() > 0){
//			return false;
//		}
//		return true;
//	}
//
//}
