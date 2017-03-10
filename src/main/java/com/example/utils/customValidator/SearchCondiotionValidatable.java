package com.example.utils.customValidator;

import javax.validation.ConstraintValidatorContext;

public interface SearchCondiotionValidatable {
	boolean isValid(SearchCondiotionValidatable constraint, ConstraintValidatorContext context);
}
