package com.tsugaruweb.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * JavaConfig ウェブ設定の統括
 * @author nozawa
 *
 */
@Import(ThymeleafConfig.class)
@EnableWebMvc
@ComponentScan("com.tsugaruweb")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

}
