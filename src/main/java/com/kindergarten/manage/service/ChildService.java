package com.kindergarten.manage.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IChildDAO;
import com.kindergarten.manage.po.Child;
import com.kindergarten.manage.util.TimeMethod;

@Service
public class ChildService {
	@Autowired
	private IChildDAO childDAO;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Child> getLists(Child args) {
		return childDAO.getChilds(args);
	}

	/**
	 * 根据搜索条件来获取列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getChilds(Child args) {
		List<Child> childs = childDAO.getChilds(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (childs.size() > 0) {
			for (Child child : childs) {
				sb.append("{\"childId\": \"").append(child.getChildId()).append("\",");
				sb.append("\"childName\": \"").append(child.getChildName()).append("\",");
				sb.append("\"entranday\": \"").append(TimeMethod.getTimestapStr(child.getEntranday())).append("\",");
				sb.append("\"sex\": \"").append(child.getSex() == 0 ? "男" : "女").append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(childs.size()).append(" }");
		return sb.toString();
	}

	/**
	 * 如果主键为0，就是增加，否则就是修改
	 * 
	 * @param model
	 */
	public void save(Child model) {
		setSaveChildTime(model);
		if (model.getChildId() == 0) {
			childDAO.insert(model);
		} else {
			childDAO.update(model);
		}
	}

	public Child getClazz(int childId) {
		Child child = childDAO.getChild(childId);
		setGetChildTime(child);
		return child;
	}

	public void delete(int childId) {
		childDAO.delete(childId);
	}

	private void setSaveChildTime(Child model) {
		if (!StringUtils.isBlank(model.getBirthdayStr())) {
			model.setBirthday(TimeMethod.getTimestamp(model.getBirthdayStr()));
		}
		if (!StringUtils.isBlank(model.getEntrandayStr())) {
			model.setEntranday(TimeMethod.getTimestamp(model.getEntrandayStr()));
		}
	}

	private void setGetChildTime(Child model) {
		model.setBirthdayStr(TimeMethod.getTimestapStr(model.getBirthday()));
		model.setEntrandayStr(TimeMethod.getTimestapStr(model.getEntranday()));
	}
}
