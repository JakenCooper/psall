package com.jaken.psall.config;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Import(RepoConfig.class)
@ComponentScan(basePackages={"com.jaken.psall.service","com.jaken.psall.comp"})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class RootConfig {

	
	@Bean(name="transactionManager")
	@Autowired
	public DataSourceTransactionManager getDefaultTransactionManager(DataSource dataSource){
		DataSourceTransactionManager dtm = new DataSourceTransactionManager();
		dtm.setDataSource(dataSource);
		return dtm;
	}
}
