package com.jaken.psall.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserFormInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object method) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod)method;
		String controllerClassName = handlerMethod.getBean().getClass().getSimpleName();
		String methodName = handlerMethod.getMethod().getName();
		System.out.println("invoking ---> "+controllerClassName+","+methodName);
		String currName = request.getParameter("name");
		if(methodName.equals("saveform")){
			if(currName.indexOf("ss")!=-1){
				HttpSession session = request.getSession();
				String reqpath = "";
				String referer = request.getHeader("Referer");
				String contextPath = request.getContextPath();
				if(session.getAttribute("CACHE_"+controllerClassName) == null){
//					reqpath = referer.substring(referer.indexOf(contextPath)+contextPath.length());
					reqpath = referer.substring(referer.indexOf(contextPath));
					session.setAttribute("CACHE_"+controllerClassName, reqpath);
				}else{
					reqpath = (String)session.getAttribute("CACHE_"+controllerClassName);
				}
				request.setAttribute("errormsg", "repeat!");
//				request.getRequestDispatcher(reqpath).forward(request, response);
				response.sendRedirect(reqpath);
				return false;
			}
		}
		return true;
	}

	
}
