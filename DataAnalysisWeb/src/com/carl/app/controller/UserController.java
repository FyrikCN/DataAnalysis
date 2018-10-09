package com.carl.app.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.carl.app.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger log =Logger.getLogger(UserController.class);
	private List<User> userList = new ArrayList<User>();
	public UserController() throws ParseException {
		userList.add(new User(1,"test001","123",new SimpleDateFormat("yyyy-MM-dd").parse("1996-08-10"),
				"012323421","example@123.com"));
		userList.add(new User(2,"test002","123",new SimpleDateFormat("yyyy-MM-dd").parse("1996-08-10"),
				"012323421","example@123.com"));
		userList.add(new User(3,"test003","123",new SimpleDateFormat("yyyy-MM-dd").parse("1996-08-10"),
				"012323421","example@123.com"));
	}
	
//	@RequestMapping(value="/welcome",method=RequestMethod.GET)
//	public String welcome(@RequestParam(required=false) String username) {
//		log.info("Welcome: "+username);
//		return "index";
//	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	@RequestMapping(value="/registeUser")
	public String register(@RequestParam(required=false) String username, Model model) {
		System.out.println("usernamer: "+username);
		User user = new User();
		user.setUserName(username);
		model.addAttribute("user",user);
		return "success";
	}
	//Get User List-Testing only
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		log.info("Search without condition");
		model.addAttribute("userList", userList);
		return "list";
	}
}
