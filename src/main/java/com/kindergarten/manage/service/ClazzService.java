package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IClazzDAO;
import com.kindergarten.manage.po.Clazz;

@Service
public class ClazzService {
	@Autowired
	private IClazzDAO clazzDAO;

	/**
	 * 查询所有学历
	 * 
	 * @return
	 */
	public List<Clazz> getLists() {
		Clazz args = new Clazz();
		return clazzDAO.getClazzs(args);
	}

	/**
	 * 根据搜索条件来获取学历的列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getClazzs(Clazz args) {
		List<Clazz> Clazzs = clazzDAO.getClazzs(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (Clazzs.size() > 0) {
			for (Clazz clazz : Clazzs) {
				sb.append("{\"clazzId\": \"").append(clazz.getClazzId()).append("\",");
				sb.append("\"clazzName\": \"").append(clazz.getClazzName()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(Clazzs.size()).append(" }");
		return sb.toString();
	}

	/**
	 * 如果主键为0，就是增加，否则就是修改
	 * 
	 * @param model
	 */
	public void save(Clazz model) {
		if (model.getClazzId() == 0) {
			clazzDAO.insert(model);
		} else {
			clazzDAO.update(model);
		}
	}

	/**
	 * 根据主键，获取一个学历
	 * 
	 * @param ClazzId
	 * @return
	 */
	public Clazz getClazz(int clazzId) {
		return clazzDAO.getClazz(clazzId);
	}

	/**
	 * 删除操作
	 * 
	 * @param ClazzId
	 */
	public void delete(int clazzId) {
		clazzDAO.delete(clazzId);
	}
}
