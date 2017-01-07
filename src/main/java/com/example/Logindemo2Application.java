package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Logindemo2Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Logindemo2Application.class, args);
	}

	//tomcatでweb/xmlなしで動かすための設定
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Logindemo2Application.class);
	}
}
