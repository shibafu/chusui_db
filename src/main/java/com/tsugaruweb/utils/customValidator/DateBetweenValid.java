//package com.tsugaruweb.utils.customValidator;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//@Target({ElementType.TYPE,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy=DateBetweenValidator.class)
//@Documented
//public @interface DateBetweenValid {
//	String message() default "日付の前後順序が逆です。";
//
//	String fieldFrom() default "from";
//	String fieldTo() default "to";
//
//	Class<?>[] groups() default {};
//	Class<? extends Payload>[] payload() default {};
//
//	@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
//	@Retention(RetentionPolicy.RUNTIME)
//	@Documented
//	public static @interface List{
//		DateBetweenValid[] value();
//	}
//}
