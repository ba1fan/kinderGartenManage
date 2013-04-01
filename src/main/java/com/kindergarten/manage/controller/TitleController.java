package com.kindergarten.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.TechTitle;
import com.kindergarten.manage.service.TechTitleService;

@Controller
@RequestMapping(value = "/title")
public class TitleController {
	@Autowired
	private TechTitleService titleService;

	/**
	 * ����ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/title/show";
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
	public void show(TechTitle title, HttpServletResponse response) throws IOException {
		String rtn = titleService.getTechTitles(title);
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
		TechTitle title = new TechTitle();
		title.setTitleId(0);
		model.addAttribute("title", title);
		return "/pages/title/save";
	}

	/**
	 * �������
	 * 
	 * @param Educate
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(TechTitle title) {
		titleService.save(title);
		return "/pages/title/show";
	}

	/**
	 * �����޸�ҳ��
	 * 
	 * @param EducateId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{titleId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int titleId, Model model) {
		TechTitle title = titleService.getTechTitle(titleId);
		model.addAttribute("title", title);
		return "/pages/title/save";
	}

	/**
	 * ɾ������
	 * 
	 * @param EducateId
	 * @return
	 */
	@RequestMapping(value = "/{titleId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int titleId) {
		titleService.delete(titleId);
		return "/pages/titleId/show";
	}
}
