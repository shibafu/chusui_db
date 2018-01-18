package com.tsugaruweb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class WebAquariumApplication{

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
	    try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
	    	WebAquariumApplication app = context.getBean(WebAquariumApplication.class);
	        app.execute();
	      }
	}
	
	/**
	 * 実行ログ
	 */
	private void execute() {
		System.out.println("Let's start!!");
	}
}
