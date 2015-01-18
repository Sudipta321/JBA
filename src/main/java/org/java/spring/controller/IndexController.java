package org.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value="/")
	public String index(Model model){
		model.addAttribute("message","Sudipta");
		return "hello";
	}
	/*public String index(){
		return "/WEB-INF/jsp/hello.jsp";
	}
*/	

}
