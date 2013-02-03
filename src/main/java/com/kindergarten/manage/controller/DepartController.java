package com.kindergarten.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.Depart;
import com.kindergarten.manage.service.DepartService;

@Controller
@RequestMapping(value = "/depart")
public class DepartController {
	@Autowired
	private DepartService departService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<Depart> departs = departService.getDeparts();
		model.addAttribute("departs", departs);
		return "/pages/depart";
	}

}
