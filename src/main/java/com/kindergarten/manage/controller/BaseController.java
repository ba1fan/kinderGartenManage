package com.kindergarten.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.User;
import com.kindergarten.manage.po.UserLog;
import com.kindergarten.manage.service.UserService;
import com.kindergarten.manage.util.Constants;

@Controller
@RequestMapping(value = "/")
public class BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {
		return "/pages/login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(User user, Model model) {
		// 根据用户名查找，如果不存在，返回用户不存在
		User exist = userService.getLoginUser(user);
		if (exist == null) {
			model.addAttribute("msg", "用户不存在");
			return "/pages/login";
		} else {
			// 如果用户名存在,检查登录记录表5分钟之内有没有3条记录。如果有提示5分钟不能登录
			// 无论密码错误或者正确，记录登录记录。
			int count = userService.getLoginErrorCount(exist.getUserId());
			if (count >= 3) {
				model.addAttribute("msg", "密码输错3次，5分钟内不能登录。");
				return "/pages/login";
			}
			// 记录Log
			UserLog log = new UserLog();
			log.setUserId(exist.getUserId());
			// 检查密码是否正确，如果正确，就读取权限。进入index页面
			if (!exist.getPassword().equals(user.getPassword())) {
				log.setStatus(Constants.USER_LOG_PWD_ERROR);
				userService.addUserLog(log);
				model.addAttribute("msg", "密码错误");
				return "/pages/login";
			} else {
				log.setStatus(Constants.USER_LOG_PWD_RIGHT);
				userService.addUserLog(log);
				model.addAttribute("userId", exist.getUserId());
				return "/pages/index";
			}
		}
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "/pages/index";
	}

	@RequestMapping(value = "getAuth", method = RequestMethod.POST)
	public void auth(int userId, HttpServletResponse response) throws IOException {
		String rtn = userService.getAuth(userId);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(rtn);
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "/pages/welcome";
	}

}
