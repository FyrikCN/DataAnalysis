package com.carl.app.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController{
	private Logger log = Logger.getLogger(IndexController.class);
//	@RequestMapping("/index")
//	public String index() {
//		return "index";
//	}
	//Using Model and View sending data
//	@RequestMapping("/welcome")
//	public ModelAndView welcome(@RequestParam(required=false) String username) {
//		log.info("Welcome: "+username);
//		ModelAndView modelandview = new ModelAndView();
//		modelandview.addObject("username",username);
//		modelandview.setViewName("index");
//		return modelandview;
//	}
	//Using Model sending data
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String welcome(@RequestParam(required=false)String username, Model model) {
//		log.info("Hello SpringMVC !username: "+username);
//		model.addAttribute("username",username);
//		return "index";
//	}
	@RequestMapping(value="/")
	public String index() {
		log.info("Entering Index Page");
		return "index";
	}
}
