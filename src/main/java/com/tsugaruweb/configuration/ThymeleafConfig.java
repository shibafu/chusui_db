package com.tsugaruweb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolution;

/**
 * JavaConfig タイムリーフの設定をするよ
 * @author nozawa
 *
 */
@Configuration
public class ThymeleafConfig {
	/**
	 * ※ServletContextTemplateResolverは古い！
	 * SpringResourceTemplateResolverで
	 * @return サーブレットテンプレートエンジン 元ネタ
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("/WEB-INF/templates");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		
		return resolver;
	}
	
	/**
	 * Spring標準テンプレートエンジンを登録
	 * @return
	 */
	@Bean
	SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
	    // add dialect spring security
        /** @See https://github.com/thymeleaf/thymeleaf-extras-springsecurity */
	    templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	}
	

	/**
	 * タイムリーフリゾルバーを登録
	 * @return Thymeleafリゾルバーエンジン
	 */
	@Bean
	public ThymeleafViewResolver thymeleafResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		resolver.setOrder(1);
		return resolver;
	}
}
