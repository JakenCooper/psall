package com.jaken.psall.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jaken.psall.util.EncryptPropertyPlaceHolder;

@Configuration
@Import(RepoConfig.class)
@ComponentScan(basePackages="com.jaken.psall.service")
@EnableTransactionManagement(proxyTargetClass=true)
public class RootConfig {

	@Bean(name="propertyPlaceholderConfigurer")
	public PropertyPlaceholderConfigurer getPropertyPlaceholder(){
		EncryptPropertyPlaceHolder placeHolder = new EncryptPropertyPlaceHolder();
		PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
		Resource[] resources = null;
		try {
			resources = resourceLoader.getResources("classpath*:psall.properties");
			placeHolder.setLocations(resources);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return placeHolder;
	}
	
	@Bean(name="jpaTransactionManager")
	@Qualifier("jpaTransactionManager")
	public JpaTransactionManager getJpaTransactionManager(EntityManagerFactory emf){
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(emf);
		return jtm;
	}
	
	@Bean(name="dataSourceTransactionManager")
	@Qualifier("dataSourceTransactionManager")
	public DataSourceTransactionManager getDatasourceDataSourceTransactionManager(DataSource dataSource){
		DataSourceTransactionManager dtm = new DataSourceTransactionManager();
		dtm.setDataSource(dataSource);
		return dtm;
	}
	
}
