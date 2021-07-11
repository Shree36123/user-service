package com.shree.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.user.service.RestTemplateVO.RestTemplateVo;
import com.shree.user.service.entity.User;
import com.shree.user.service.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@PostMapping("/")
	User saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
	@GetMapping("/{id}")
	RestTemplateVo getUserWithDep(@PathVariable("id") Long userId) {
		
		return userService.getUserWithDepartment(userId);
		
	}
	
	
	
}
