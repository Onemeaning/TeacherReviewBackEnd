package com.meanlam.te.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfigration
{
	@Value("${mybatis_config_file}")
	private String mybatisConfigPathFile;

	@Value("${mapper_path}")
	private String mapperPath;

	@Autowired
	private DataSource dataSource;

	@Value("${entity_package}")
	private String entityPackage;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException
	{

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPathFile));

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

		return sqlSessionFactoryBean;
	}
}
