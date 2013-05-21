package com.kindergarten.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.Clazz;
import com.kindergarten.manage.service.ClazzService;

@Controller
@RequestMapping(value = "/clazz")
public class ClazzContoller {
	@Autowired
	private ClazzService clazzService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/clazz/show";
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
	public void show(Clazz de, HttpServletResponse response) throws IOException {
		String rtn = clazzService.getClazzs(de);
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
		Clazz clazz = new Clazz();
		clazz.setClazzId(0);
		model.addAttribute("clazz", clazz);
		return "/pages/clazz/save";
	}

	/**
	 * 保存操作
	 * 
	 * @param Clazz
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Clazz clazz) {
		clazzService.save(clazz);
		return "/pages/clazz/show";
	}

	/**
	 * 进入修改页面
	 * 
	 * @param ClazzId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{clazzId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int clazzId, Model model) {
		Clazz clazz = clazzService.getClazz(clazzId);
		model.addAttribute("clazz", clazz);
		return "/pages/clazz/save";
	}

	/**
	 * 删除操作
	 * 
	 * @param ClazzId
	 * @return
	 */
	@RequestMapping(value = "/{clazzId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int clazzId) {
		clazzService.delete(clazzId);
		return "/pages/clazz/show";
	}
}
