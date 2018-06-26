package com.jaken.psall.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaken.psall.entity.User;

@Controller
public class MainController {
	
	private static Map<String,User> userMap = new HashMap<String,User>(); 

	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/userform")
	public String form(@ModelAttribute User user,Model model){
		if(user==null || StringUtils.isBlank(user.getId())){
			return "main";
		}
		user = userMap.get(user.getId());
		model.addAttribute(user);
		return "main";
	}
	
	@RequestMapping("/saveform")
	public String saveform(User user,RedirectAttributes ra){
		user.setId(UUID.randomUUID().toString());
		userMap.put(user.getId(), user);
		ra.addFlashAttribute("user",user);
		return "redirect:/userform";
	}
}
