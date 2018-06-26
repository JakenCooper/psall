package com.jaken.psall.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan(basePackages="com.jaken.psall.dao")
@EnableJpaRepositories(basePackages="com.jaken.psall.dao",transactionManagerRef="jpaTransactionManager")
@PropertySource("classpath:psall.properties")
public class RepoConfig {

	@Configuration
	static class BasicConfig{
		@Value("${jdbc.url}")
		private String jdbcUrl;
		@Value("${jdbc.user}")
		private String jdbcUser;
		@Value("${jdbc.password}")
		private String jdbcPassword;
		
		@Autowired
		private Environment env;
		
		@Bean(name="dataSource")
		public DataSource getDefaultDataSource(){
			BasicDataSource bds = new BasicDataSource();
			bds.setDriverClassName("com.mysql.jdbc.Driver");
//			System.out.println("url======= "+env.getProperty("jdbc.url"));
			bds.setUrl(jdbcUrl);
			bds.setUsername(jdbcUser);
			bds.setPassword(jdbcPassword);
			return bds;
		}

		@Bean(name="jpaVendorAdapter")
		public JpaVendorAdapter getJpaVendorAdapter(){
			HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
			jpaVendorAdapter.setGenerateDdl(true);
			jpaVendorAdapter.setShowSql(true);
			jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
			return jpaVendorAdapter;
		}
		
		@Bean(name="entityManagerFactory")
		@Autowired
		public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
			LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
			emf.setDataSource(dataSource);
			emf.setJpaVendorAdapter(jpaVendorAdapter);
			emf.setPackagesToScan("com.jaken.psall.entity");
			return emf;
		}
		
		@Bean("mybatisSqlSessionFactory")
		@Autowired
		public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource){
			SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
			ssf.setDataSource(dataSource);
			PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
			try {
				Resource configResource = resourceLoader.getResource("classpath:mybatis-conf.xml");
				Resource[] mapperResources = resourceLoader.getResources("classpath:com/jaken/psall/entity/mapper/*.xml");
				ssf.setConfigLocation(configResource);
				ssf.setMapperLocations(mapperResources);
				return ssf;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	@Bean(name="mapperScannerConfigurer")
	public MapperScannerConfigurer getMapperScannerConfigurer(){
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setSqlSessionFactoryBeanName("mybatisSqlSessionFactory");
		msc.setBasePackage("com.jaken.psall.dao");
		return msc;
	}
	
	
	
}
