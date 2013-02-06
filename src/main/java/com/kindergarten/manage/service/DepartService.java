package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IDepartDAO;
import com.kindergarten.manage.po.Depart;

@Service
public class DepartService {
	@Autowired
	private IDepartDAO departDAO;

	/**
	 * 根据搜索条件来获取角色的列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getDeparts(Depart args) {
		List<Depart> departs = departDAO.getDeparts(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (departs.size() > 0) {
			for (Depart depart : departs) {
				sb.append("{\"departId\": \"").append(depart.getDepartId()).append("\",");
				sb.append("\"departName\": \"").append(depart.getDepartName()).append("\",");
				sb.append("\"status\": \"").append(depart.getStatus() == 1 ? "正常" : "禁用").append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(departs.size()).append(" }");
		return sb.toString();
	}

	/**
	 * 如果主键为0，就是增加，否则就是修改
	 * 
	 * @param model
	 */
	public void save(Depart model) {
		if (model.getDepartId() == 0) {
			departDAO.insert(model);
		} else {
			departDAO.update(model);
		}
	}

	/**
	 * 根据主键，获取一个角色
	 * 
	 * @param departId
	 * @return
	 */
	public Depart getDepart(int departId) {
		return departDAO.getDepart(departId);
	}

	/**
	 * 删除操作
	 * 
	 * @param departId
	 */
	public void delete(int departId) {
		departDAO.delete(departId);
	}
}
