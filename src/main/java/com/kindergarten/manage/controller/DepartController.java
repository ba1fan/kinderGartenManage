package com.kindergarten.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.Depart;
import com.kindergarten.manage.service.DepartService;

@Controller
@RequestMapping(value = "/depart")
public class DepartController {
	@Autowired
	private DepartService departService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/depart/show";
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
	public void show(Depart de, HttpServletResponse response) throws IOException {
		String rtn = departService.getDeparts(de);
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
		Depart depart = new Depart();
		depart.setDepartId(0);
		model.addAttribute("depart", depart);
		return "/pages/depart/save";
	}

	/**
	 * 保存操作
	 * 
	 * @param depart
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Depart depart) {
		departService.save(depart);
		return "/pages/depart/show";
	}

	/**
	 * 进入修改页面
	 * 
	 * @param departId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{departId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int departId, Model model) {
		Depart depart = departService.getDepart(departId);
		model.addAttribute("depart", depart);
		return "/pages/depart/save";
	}

	/**
	 * 删除操作
	 * 
	 * @param departId
	 * @return
	 */
	@RequestMapping(value = "/{departId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int departId) {
		departService.delete(departId);
		return "/pages/depart/show";
	}
}
