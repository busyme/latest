package com.yan.foodorder.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.yan.foodorder.model.User;
import com.yan.foodorder.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger logger = 
			(Logger) LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	@ResponseBody
	private List<User> listUser() {
		logger.debug("Listing All Users");
		return (List<User>) userService.findAll();
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	private ResponseEntity<String> saveUser(@RequestBody User user) {
		
		logger.debug("user name is "+ user.getName());
		logger.debug("user name is "+ user.getEmail());
		logger.debug("user name is "+ user.getPassword());
		logger.debug("user name is "+ user.getId());
		logger.debug("user name is "+ user.getType());
		userService.save(user);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
