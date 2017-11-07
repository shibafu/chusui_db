package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebAquariumWWWApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WebAquariumWWWApplication.class, args);
	}

	//tomcatでweb/xmlなしで動かすための設定
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(WebAquariumWWWApplication.class);
	}
}
