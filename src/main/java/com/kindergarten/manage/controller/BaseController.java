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
		// �����û������ң���������ڣ������û�������
		User exist = userService.getLoginUser(user);
		if (exist == null) {
			model.addAttribute("msg", "�û�������");
			return "/pages/login";
		} else {
			// ����û�������,����¼��¼��5����֮����û��3����¼���������ʾ5���Ӳ��ܵ�¼
			// ����������������ȷ����¼��¼��¼��
			int count = userService.getLoginErrorCount(exist.getUserId());
			if (count >= 3) {
				model.addAttribute("msg", "�������3�Σ�5�����ڲ��ܵ�¼��");
				return "/pages/login";
			}
			// ��¼Log
			UserLog log = new UserLog();
			log.setUserId(exist.getUserId());
			// ��������Ƿ���ȷ�������ȷ���Ͷ�ȡȨ�ޡ�����indexҳ��
			if (!exist.getPassword().equals(user.getPassword())) {
				log.setStatus(Constants.USER_LOG_PWD_ERROR);
				userService.addUserLog(log);
				model.addAttribute("msg", "�������");
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
