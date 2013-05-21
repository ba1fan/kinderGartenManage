package com.kindergarten.manage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.AuthMap;
import com.kindergarten.manage.po.Depart;
import com.kindergarten.manage.service.AuthService;
import com.kindergarten.manage.service.DepartService;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {
	@Autowired
	private DepartService departService;
	@Autowired
	private AuthService authService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/auth/show";
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
	public void show(Depart de, HttpServletResponse response) throws IOException {
		String rtn = departService.getDeparts(de);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(rtn);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		AuthMap authMap = authService.getAuthMapByDepartId(id);
		model.addAttribute("authMap", authMap);
		model.addAttribute("departId", id);
		return "/pages/auth/save";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String save(AuthMap authMap, Model model) {
		authService.insert(authMap);
		return "/pages/auth/show";
	}
}
