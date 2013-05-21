package com.kindergarten.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.PhyParameter;
import com.kindergarten.manage.service.PhyParameterService;

@Controller
@RequestMapping(value = "/param")
public class PhyParameterController {
	@Autowired
	private PhyParameterService parameterService;

	/**
	 * Ω¯»Î“≥√Ê
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("params", null);
		return "/pages/params/show";
	}

	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public String select(PhyParameter args, Model model) {
		args.setMonth(-1);
		args.setYear(-1);
		List<PhyParameter> params = parameterService.getPhyParameters(args);
		model.addAttribute("phyType", args.getPhyType());
		model.addAttribute("sex", args.getSex());
		model.addAttribute("params", params);
		return "/pages/params/show";
	}
}
