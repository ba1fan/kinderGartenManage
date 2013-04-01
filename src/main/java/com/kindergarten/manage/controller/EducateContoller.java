package com.kindergarten.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.Educate;
import com.kindergarten.manage.service.EducateService;

@Controller
@RequestMapping(value = "/educate")
public class EducateContoller {
	@Autowired
	private EducateService educateService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/educate/show";
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
	public void show(Educate de, HttpServletResponse response) throws IOException {
		String rtn = educateService.getEducates(de);
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
		Educate educate = new Educate();
		educate.setEducateId(0);
		model.addAttribute("educate", educate);
		return "/pages/educate/save";
	}

	/**
	 * 保存操作
	 * 
	 * @param Educate
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Educate educate) {
		educateService.save(educate);
		return "/pages/educate/show";
	}

	/**
	 * 进入修改页面
	 * 
	 * @param EducateId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{educateId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int educateId, Model model) {
		Educate educate = educateService.getEducate(educateId);
		model.addAttribute("educate", educate);
		return "/pages/educate/save";
	}

	/**
	 * 删除操作
	 * 
	 * @param EducateId
	 * @return
	 */
	@RequestMapping(value = "/{educateId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int educateId) {
		educateService.delete(educateId);
		return "/pages/educate/show";
	}
}
