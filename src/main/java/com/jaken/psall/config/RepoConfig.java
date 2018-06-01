package com.jaken.psall.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.jaken.psall.comp.MultiDataSource;

@Configuration
@ComponentScan(basePackages={"com.jaken.psall.dao","com.jaken.psall.comp"})
public class RepoConfig {

	@Bean(name="dsforupdate")
	public DataSource getDsForUpdate(){
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3333/doctransys");
		bds.setUsername("root");
		bds.setPassword("jaken123");
		return bds;
	}
	
	@Bean(name="dsforselect")
	public DataSource getDsForSelect(){
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3334/doctransys");
		bds.setUsername("root");
		bds.setPassword("jaken123");
		return bds;
	}
	
	@Bean(name="dataSource")
	@Autowired
	public DataSource getDataSource(DataSource dsforupdate,DataSource dsforselect){
		MultiDataSource mds = new MultiDataSource();
		mds.setDefaultTargetDataSource(dsforupdate);
		Map<Object,Object> dsmap=new HashMap<Object,Object>();
		dsmap.put("dsforupdate", dsforupdate);
		dsmap.put("dsforselect", dsforselect);
		mds.setTargetDataSources(dsmap);
		mds.setTargetDataSources(dsmap);
		return mds;
	}

	@Bean(name="sqlSessionFactory")
	@Autowired
	public SqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource){
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
		try {
			sfb.setConfigLocation(resourceLoader.getResource("classpath:mybatisconfig.xml"));
			sfb.setMapperLocations(resourceLoader.getResources("classpath:com/jaken/psall/entity/mapper/*.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sfb;
	}
	
	@Bean(name="mapperScannerConfigurer")
	public MapperScannerConfigurer getScanner(){
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage("com.jaken.psall.dao");
		return msc;
	}
	
}
