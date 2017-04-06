package com.example.utils.customValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SameEmailChusuiUserValidator.class)
@Documented
public @interface SameEmailChusuiUser {
	String message() default "メール認証が弾かれました。既存のメールアドレスと重複していませんか？";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
