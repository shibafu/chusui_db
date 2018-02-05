package com.tsugaruweb.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * データベースアクセスコンフィグ
 * @author nozawa
 *
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

	@Bean(destroyMethod = "close")
	DataSource dataSource(
		@Value("${database.driverClassName}") String driverClassName,
		@Value("${database.url}") String url,
		@Value("${database.username}") String username,
		@Value("${database.password}") String password,
		@Value("${cp.MaxActive}") int maxActive,
		@Value("${cp.MaxIdle}") int maxIdle,
		@Value("${cp.MinIdle}") int minIdle,
		@Value("${cp.MaxWaits}") long maxWait
			) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxWait(maxWait);
		return dataSource;
	}
}
