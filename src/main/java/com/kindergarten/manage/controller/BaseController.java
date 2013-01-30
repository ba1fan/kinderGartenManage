package com.kindergarten.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "/index";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "/welcome";
	}

}
