package com.kindergarten.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.TeacherInfo;
import com.kindergarten.manage.service.DepartService;
import com.kindergarten.manage.service.EducateService;
import com.kindergarten.manage.service.TeacherService;
import com.kindergarten.manage.service.TechTitleService;
import com.kindergarten.manage.service.UserService;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private DepartService departService;
	@Autowired
	private TechTitleService titleService;
	@Autowired
	private EducateService educateService;
	@Autowired
	private UserService userService;

	/**
	 * ����ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/teacher/show";
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
	public void show(TeacherInfo de, HttpServletResponse response) throws IOException {
		String rtn = teacherService.getTeacherInfos(de);
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
		TeacherInfo info = new TeacherInfo();
		info.setTeacherId(0);
		model.addAttribute("info", info);
		initElement(model);
		return "/pages/teacher/save";
	}

	/**
	 * �������
	 * 
	 * @param Educate
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(TeacherInfo info) {
		teacherService.save(info);
		return "/pages/teacher/show";
	}

	/**
	 * �����޸�ҳ��
	 * 
	 * @param EducateId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		TeacherInfo info = teacherService.getTeacherInfo(id);
		model.addAttribute("info", info);
		initElement(model);
		return "/pages/teacher/save";
	}

	/**
	 * �����޸�ҳ��
	 * 
	 * @param EducateId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String view(@PathVariable int id, Model model) {
		TeacherInfo info = teacherService.getTeacherInfo(id);
		model.addAttribute("info", info);
		initElement(model);
		return "/pages/teacher/view";
	}

	/**
	 * �����޸�ҳ��
	 * 
	 * @param EducateId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/log", method = RequestMethod.GET)
	public String log(@PathVariable int id, Model model) {
		teacherService.getLogView(id, model);
		return "/pages/teacher/log";
	}

	/**
	 * ɾ������
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		teacherService.delete(id);
		return "/pages/teacher/show";
	}

	/**
	 * ��ʼ��ҳ��Ԫ��
	 * 
	 * @param model
	 */
	private void initElement(Model model) {
		model.addAttribute("departs", departService.getLists());
		model.addAttribute("titles", titleService.getLists());
		model.addAttribute("educates", educateService.getLists());
		model.addAttribute("users", userService.getLists());
	}
}
