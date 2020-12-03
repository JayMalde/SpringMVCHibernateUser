package com.aptechkharghar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.aptechkharghar.entities.*;
import com.aptechkharghar.service.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userservice;
	
	@GetMapping("/addUser")
	public ModelAndView addStudent() {
		ModelAndView modelAndView = new ModelAndView("AddUser");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	@PostMapping("/submitDetails")
	public ModelAndView submitDetails(User user) {
		ModelAndView mav = new ModelAndView("ListUser");
		userservice = new UserService();
		userservice.addUser(user);
		List<User> list = userservice.getAllUsers();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("ListUser");
		List<User> list = userservice.getAllUsers();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam("userId") Integer userId) {
		ModelAndView mov = new ModelAndView("AddUser");
		User user = findById(userId);
		mov.addObject("user", user);
		return mov;
	}
	
	@RequestMapping("/deleteRecord")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		User userObj = findById(userId);
		userservice.deleteUser(userObj);
		return "redirect:/";
	}
	
	public User findById(Integer userId) {
		User user = userservice.getUserById(userId);
		return user;
	}
}
