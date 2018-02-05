package com.tsugaruweb.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginGroup implements Serializable {
	private static final long SerialVersionUI = 1L;

	@NotNull
	@Size(min = 6, max = 50)
	private String name;

	@NotNull
	@Size(min = 6, max = 50)
	private String password;

}
