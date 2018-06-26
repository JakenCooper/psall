package com.jaken.psall.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisService {
	
	public void generate() throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String path = MybatisService.class.getResource("/mybatis-generator.xml").getPath();
		System.out.println(path);
		File configFile = new File(path);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	public static void main(String[] args) throws Exception {
		MybatisService service = new MybatisService();
		service.generate();
	}
}
