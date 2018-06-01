package com.jaken.psall.comp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.jaken.psall.service.UserService;

@Component
@Aspect
public class MybatisServiceInterceptor {

	@Around("execution (* com..*.*(..))")
	public Object interceptMethod(ProceedingJoinPoint pjp) throws Throwable{
		MultiDataSource.setDatasourceKey("dsforselect");
		System.out.println("into interceptor------------------- ");
		 if(pjp.getTarget() instanceof UserService){
			 UserService us=(UserService) pjp.getTarget();
		 }
		 return pjp.proceed();
	}
}
