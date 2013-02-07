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

import com.kindergarten.manage.po.Depart;
import com.kindergarten.manage.po.User;
import com.kindergarten.manage.service.DepartService;
import com.kindergarten.manage.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DepartService departService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "pages/user/show";
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
	public void show(User args, HttpServletResponse response) throws IOException {
		String rtn = userService.getDeparts(args);
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
		User user = new User();
		user.setUserId(0);
		model.addAttribute("user", user);
		List<Depart> departs = departService.getLists();
		model.addAttribute("departs", departs);
		return "/pages/user/save";
	}

	/**
	 * 保存操作
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(User user) {
		userService.save(user);
		return "/pages/user/show";
	}

	/**
	 * 进入修改页面
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int userId, Model model) {
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		List<Depart> departs = departService.getLists();
		model.addAttribute("departs", departs);
		return "/pages/user/save";
	}

	/**
	 * 删除操作
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{userId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int userId) {
		userService.delete(userId);
		return "/pages/user/show";
	}
}
