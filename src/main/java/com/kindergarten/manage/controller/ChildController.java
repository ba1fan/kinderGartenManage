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

import com.kindergarten.manage.po.Child;
import com.kindergarten.manage.po.Clazz;
import com.kindergarten.manage.service.ChildService;
import com.kindergarten.manage.service.ClazzService;

@Controller
@RequestMapping(value = "/child")
public class ChildController {
	@Autowired
	private ChildService childService;
	@Autowired
	private ClazzService clazzService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/child/show";
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
	public void show(Child args, HttpServletResponse response) throws IOException {
		String rtn = childService.getChilds(args);
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
		Child child = new Child();
		child.setChildId(0);
		List<Clazz> clazzs = clazzService.getLists();
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("child", child);
		return "/pages/child/save";
	}

	/**
	 * 增加
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Child child, Model model) {
		childService.save(child);
		return "/pages/child/show";
	}

	/**
	 * 进入修改页面
	 * 
	 * @param departId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Child child = childService.getClazz(id);
		List<Clazz> clazzs = clazzService.getLists();
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("child", child);
		return "/pages/child/save";
	}
}
