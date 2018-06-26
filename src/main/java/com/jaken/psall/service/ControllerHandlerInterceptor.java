package com.jaken.psall.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.jaken.psall.entity.User;

@Aspect
//@Component
public class ControllerHandlerInterceptor {

	@Around("execution(* com..*.*Controller.form(..))")
	public Object handlerForm(ProceedingJoinPoint jpj){
		Object[] args = jpj.getArgs();
		try {
			User user = (User)args[0];
			Method[] methods = user.getClass().getMethods();
			Map<String,Method> methodMap = new HashMap<String,Method>();
			for(Method method:methods){
				methodMap.put(method.getName(), method);
			}
			for(Method method:methods){
				if(method.getName().startsWith("get")){
					if(method.getName().equals("getName")){
						System.out.println("bingo!!");
					}
					String attrName = method.getName().substring(3);
					Object val = method.invoke(user, null);
					if(!(val instanceof String)){
						continue;
					}
					String strval = (String)val;
					if(strval.indexOf(",")!=-1){
						methodMap.get("set"+attrName).invoke(user, strval.split(",")[0]);
					}
				}
			}
			return jpj.proceed(args);
		} catch (Throwable e){
			e.printStackTrace();
		} 
		return null;
		
	}
}
