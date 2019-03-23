package com.meanlam.te.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
//配置Mybatis mapper的扫描路径
@MapperScan("com.meanlam.te.dao")
public class DataSourceConfigration {
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUserName;
	@Value("${jdbc.password}")
	private String jdbcPssword;

	@Bean(name = "dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		dataSource.setDriverClass(jdbcDriver);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(jdbcUserName);
		dataSource.setPassword(jdbcPssword);

		// 关闭连接后不自动commit
		dataSource.setAutoCommitOnClose(false);

		return dataSource;
	}
}
