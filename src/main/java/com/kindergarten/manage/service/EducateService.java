package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IEducateDAO;
import com.kindergarten.manage.po.Educate;

@Service
public class EducateService {
	@Autowired
	private IEducateDAO educateDAO;

	/**
	 * 查询所有学历
	 * 
	 * @return
	 */
	public List<Educate> getLists() {
		Educate args = new Educate();
		return educateDAO.getEducates(args);
	}

	/**
	 * 根据搜索条件来获取学历的列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getEducates(Educate args) {
		List<Educate> educates = educateDAO.getEducates(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (educates.size() > 0) {
			for (Educate educate : educates) {
				sb.append("{\"educateId\": \"").append(educate.getEducateId()).append("\",");
				sb.append("\"educateName\": \"").append(educate.getEducateName()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(educates.size()).append(" }");
		return sb.toString();
	}

	/**
	 * 如果主键为0，就是增加，否则就是修改
	 * 
	 * @param model
	 */
	public void save(Educate model) {
		if (model.getEducateId() == 0) {
			educateDAO.insert(model);
		} else {
			educateDAO.update(model);
		}
	}

	/**
	 * 根据主键，获取一个学历
	 * 
	 * @param educateId
	 * @return
	 */
	public Educate getEducate(int educateId) {
		return educateDAO.getEducate(educateId);
	}

	/**
	 * 删除操作
	 * 
	 * @param educateId
	 */
	public void delete(int educateId) {
		educateDAO.delete(educateId);
	}
}
