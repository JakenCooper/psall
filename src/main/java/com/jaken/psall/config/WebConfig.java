package com.jaken.psall.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jaken.psall.web.UserFormInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.jaken.psall.controller","com.jaken.psall.service"})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean(name="viewResolver")
	public InternalResourceViewResolver getDefaultViewResolver(){
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/pages/");
		irv.setSuffix(".jsp");
		return irv;
	}
	
	@Bean(name="fileResolver")
	public CommonsMultipartResolver getDefaultFileResolver(){
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		cmr.setMaxUploadSizePerFile(3000000);
		return cmr;
	}
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		converters.add(jsonConverter);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new UserFormInterceptor());
		super.addInterceptors(registry);
	}
	
}
