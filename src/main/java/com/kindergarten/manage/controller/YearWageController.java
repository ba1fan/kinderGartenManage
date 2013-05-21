package com.kindergarten.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.Clazz;
import com.kindergarten.manage.po.YearWage;
import com.kindergarten.manage.service.ChildService;
import com.kindergarten.manage.service.ClazzService;
import com.kindergarten.manage.service.YearWageService;
import com.kindergarten.manage.util.TimeMethod;

@Controller
@RequestMapping(value = "/yearwage")
public class YearWageController {
	@Autowired
	private YearWageService yearWageService;
	@Autowired
	private ClazzService clazzService;
	@Autowired
	private ChildService childService;

	/**
	 * ����ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("year", TimeMethod.getNowYear());

		return "/pages/yearwage/show";
	}

	/**
	 * ����ҳ������
	 * 
	 * @param de
	 *            ��������
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public void show(YearWage de, HttpServletResponse response) throws IOException {
		String rtn = yearWageService.getYearWages(de);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(rtn);
	}

	/**
	 * ��������ҳ��
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		YearWage yearWage = new YearWage();
		yearWage.setYearWageId(0);
		List<Clazz> clazzs = clazzService.getLists();
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("yearWage", yearWage);
		model.addAttribute("year", TimeMethod.getNowYear());
		model.addAttribute("term", TimeMethod.getNowMonth() > 7 ? 1 : 2);
		return "/pages/yearwage/add";
	}

	/**
	 * ��������ҳ��
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{childId}/wage", method = RequestMethod.POST)
	public String wages(@PathVariable int childId, Model model) {
		YearWage yearWage = yearWageService.initYearWage(childId);
		model.addAttribute("yearWage", yearWage);
		return "/pages/yearwage/wage";
	}

	/**
	 * �������
	 * 
	 * @param depart
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(YearWage yearWage) {
		yearWageService.save(yearWage);
		return "/pages/yearwage/show";
	}
}
