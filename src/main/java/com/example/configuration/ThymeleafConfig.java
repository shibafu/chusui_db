package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.TemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@EnableWebMvc
@Configuration
public class ThymeleafConfig {

	@Autowired
	private TemplateResolver defaultTemplateResolver;

	public void setDefaultTemplateResolver(TemplateResolver templateResolver) {
		defaultTemplateResolver = templateResolver;
	}

	@Bean
	SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(defaultTemplateResolver);
		templateEngine.addDialect(new LayoutDialect());

	    // add dialect spring security
        /** @See https://github.com/thymeleaf/thymeleaf-extras-springsecurity */
	    templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	}
}
