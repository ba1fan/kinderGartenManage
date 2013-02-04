package com.kindergarten.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kindergarten.manage.po.Depart;
import com.kindergarten.manage.service.DepartService;

@Controller
@RequestMapping(value = "/depart")
public class DepartController {
	@Autowired
	private DepartService departService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/pages/depart/show";
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public void show(Depart de, HttpServletResponse response) throws IOException {
		List<Depart> departs = departService.getDeparts(de);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (departs.size() > 0) {
			for (Depart depart : departs) {
				sb.append("{\"departId\": \"").append(depart.getDepartId()).append("\",");
				sb.append("\"departName\": \"").append(depart.getDepartName()).append("\",");
				sb.append("\"status\": \"").append(depart.getStatus() == 1 ? "Õý³£" : "½ûÓÃ").append("\"},");
			}
			sb.substring(0, sb.length());
			// sb.Remove(sb.length() - 1, 1);
		}
		sb.append("], Total: ").append(departs.size()).append(" }");
		// model.addAttribute("departs", departs);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(sb.toString());

	}
}
