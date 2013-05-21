package com.kindergarten.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.Clazz;
import com.kindergarten.manage.po.PhysicalLog;
import com.kindergarten.manage.service.ClazzService;
import com.kindergarten.manage.service.PhysicalLogService;
import com.kindergarten.manage.util.TimeMethod;

@Controller
@RequestMapping(value = "/paramLog")
public class PhysicalLogController {
	@Autowired
	private PhysicalLogService logService;
	@Autowired
	private ClazzService clazzService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/paramLog/show";
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
	public void show(PhysicalLog de, HttpServletResponse response) throws IOException {
		String rtn = logService.getPhysicalLogs(de);
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
		PhysicalLog physicalLog = new PhysicalLog();
		physicalLog.setLogId(0);
		List<Clazz> clazzs = clazzService.getLists();
		model.addAttribute("clazzs", clazzs);
		model.addAttribute("log", physicalLog);
		model.addAttribute("year", TimeMethod.getNowYear());
		return "/pages/paramLog/save";
	}

	/**
	 * 保存操作
	 * 
	 * @param Educate
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(PhysicalLog log) {
		logService.save(log);
		return "/pages/paramLog/show";
	}
}
