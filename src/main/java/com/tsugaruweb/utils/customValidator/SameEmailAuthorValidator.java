//package com.tsugaruweb.utils.customValidator;
//
//import java.util.List;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.tsugaruweb.entity.Author;
//import com.tsugaruweb.repository.AuthorRepository;
//
//public class SameEmailAuthorValidator implements ConstraintValidator<SameEmailAuthor,String> {
//
//	private SameEmailAuthor sea;
//
//	@Autowired
//	private AuthorRepository auRepo;
//
//	@Override
//	public void initialize(SameEmailAuthor annotation) {
//		// TODO 自動生成されたメソッド・スタブ
//		sea = annotation;
//	}
//
//	@Override
//	public boolean isValid(String value, ConstraintValidatorContext context) {
//		// TODO 自動生成されたメソッド・スタブ
//		List<Author> list = auRepo.findByEmail(value);
//
//		if(list.size() > 0){
//			return false;
//		}
//		return true;
//	}
//
//
//}
