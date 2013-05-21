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
import com.kindergarten.manage.po.MonthWage;
import com.kindergarten.manage.service.ChildService;
import com.kindergarten.manage.service.ClazzService;
import com.kindergarten.manage.service.MonthWageService;
import com.kindergarten.manage.util.TimeMethod;

@Controller
@RequestMapping(value = "/monthwage")
public class MonthWageController {

	@Autowired
	private MonthWageService monthWageService;
	@Autowired
	private ClazzService clazzService;
	@Autowired
	private ChildService childService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("year", TimeMethod.getNowYear());
		model.addAttribute("month", TimeMethod.getNowMonth());
		return "/pages/monthwage/show";
	}

	/**
	 * 加载页面数据
	 * 
	 * @param de
	 *            搜索条件
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public void show(MonthWage de, HttpServletResponse response) throws IOException {
		String rtn = monthWageService.getMonthWages(de);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(rtn);
	}

	/**
	 * 进入增加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		MonthWage monthWage = new MonthWage();
		monthWage.setMonthWageId(0);
		List<Clazz> clazzs = clazzService.getLists();
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("monthWage", monthWage);
		model.addAttribute("year", TimeMethod.getNowYear());
		model.addAttribute("month", TimeMethod.getNowMonth());
		return "/pages/monthwage/add";
	}

	/**
	 * 进入增加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{childId}/{year}/{month}/wage", method = RequestMethod.POST)
	public String wages(@PathVariable int childId, @PathVariable int month, @PathVariable int year, Model model) {
		MonthWage monthWage = monthWageService.initMonthWage(childId, year, month);
		model.addAttribute("monthWage", monthWage);
		return "/pages/monthwage/wage";
	}

	/**
	 * 保存操作
	 * 
	 * @param depart
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(MonthWage monthWage) {
		monthWageService.save(monthWage);
		return "/pages/monthwage/show";
	}
}
