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

import com.kindergarten.manage.po.Attendance;
import com.kindergarten.manage.po.Child;
import com.kindergarten.manage.po.Clazz;
import com.kindergarten.manage.service.AttendanceService;
import com.kindergarten.manage.service.ChildService;
import com.kindergarten.manage.service.ClazzService;
import com.kindergarten.manage.util.TimeMethod;

@Controller
@RequestMapping(value = "/attendance")
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;
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
		return "/pages/attendance/show";
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
	public void show(Attendance args, HttpServletResponse response) throws IOException {
		String rtn = attendanceService.getAttendances(args);
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
		Attendance attendance = new Attendance();
		attendance.setAttendId(0);
		List<Clazz> clazzs = clazzService.getLists();
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("attendance", attendance);
		model.addAttribute("year", TimeMethod.getNowYear());
		model.addAttribute("month", TimeMethod.getNowMonth());
		return "/pages/attendance/add";
	}

	/**
	 * 加载页面数据
	 * 
	 * @param de
	 *            搜索条件
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/{clazzId}/getChild", method = RequestMethod.POST)
	public void show(@PathVariable int clazzId, HttpServletResponse response) throws IOException {

		Child child = new Child();
		child.setClazzId(clazzId);
		List<Child> childs = childService.getLists(child);
		StringBuilder sb = new StringBuilder();
		sb.append("<option value=\"0\">请选择</option>");
		if (childs.size() > 0) {
			for (Child model : childs) {
				sb.append("<option value=\"" + model.getChildId() + "\">" + model.getChildName() + "</option>");
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(sb.toString());
	}

	/**
	 * 增加
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Attendance attendance, Model model) {
		attendanceService.save(attendance);
		return "/pages/attendance/show";
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
		Attendance attendance = attendanceService.getClazz(id);
		model.addAttribute("attendance", attendance);
		model.addAttribute("year", TimeMethod.getNowYear());
		model.addAttribute("month", TimeMethod.getNowMonth());
		return "/pages/Attendance/edit";
	}
}
