package com.example.utils.customValidator;

import javax.validation.Payload;

public @interface SameEmailCustomer {
	String message() default "そのメールアドレスは既に登録されています。";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
