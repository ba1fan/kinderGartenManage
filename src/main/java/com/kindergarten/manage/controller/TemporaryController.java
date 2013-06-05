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

import com.kindergarten.manage.po.Temporary;
import com.kindergarten.manage.po.User;
import com.kindergarten.manage.service.TemporaryService;
import com.kindergarten.manage.service.UserService;
import com.kindergarten.manage.util.TimeMethod;

@Controller
@RequestMapping(value = "/temporary")
public class TemporaryController {
	@Autowired
	private TemporaryService temporaryService;
	@Autowired
	private UserService userService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "pages/temporary/show";
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
	public void show(Temporary args, HttpServletResponse response) throws IOException {
		String rtn = temporaryService.getTemporarys(args);
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
		Temporary temporary = new Temporary();
		temporary.setTemporaryId(0);
		temporary.setMonth(TimeMethod.getNowMonth());
		temporary.setYear(TimeMethod.getNowYear());
		// model.addAttribute("year", TimeMethod.getNowYear());
		// model.addAttribute("month", TimeMethod.getNowMonth());
		model.addAttribute("temporary", temporary);
		List<User> users = userService.getTemporaryUser();
		model.addAttribute("users", users);
		return "/pages/temporary/save";
	}

	/**
	 * 保存操作
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Temporary temporary) {
		temporaryService.save(temporary);
		return "/pages/temporary/show";
	}

	/**
	 * 进入修改页面
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Temporary temporary = temporaryService.getTemporary(id);
		model.addAttribute("temporary", temporary);
		List<User> users = userService.getTemporaryUser();
		model.addAttribute("users", users);
		return "/pages/temporary/save";
	}

}
