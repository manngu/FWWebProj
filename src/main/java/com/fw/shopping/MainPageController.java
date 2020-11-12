package com.fw.shopping;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MainPageController {
	
	@GetMapping("/")
	public String mainPage() {
		
		return "main/main";
	}
	
	

	
	
	

}
