package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IUserDAO;
import com.kindergarten.manage.po.User;

@Service
public class UserService {
	@Autowired
	private IUserDAO userDAO;

	/**
	 * 根据搜索条件来获取用户的列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getDeparts(User args) {
		List<User> users = userDAO.getUsers(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (users.size() > 0) {
			for (User user : users) {
				sb.append("{\"userId\": \"").append(user.getUserId()).append("\",");
				sb.append("\"userName\": \"").append(user.getUserName()).append("\",");
				sb.append("\"password\": \"").append(user.getPassword()).append("\",");
				sb.append("\"departName\": \"").append(user.getDepartName()).append("\",");
				sb.append("\"status\": \"").append(user.getStatus() == 1 ? "正常" : "禁用").append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(users.size()).append(" }");
		return sb.toString();
	}

	/**
	 * 如果主键为0，就是增加，否则就是修改
	 * 
	 * @param model
	 */
	public void save(User model) {
		if (model.getUserId() == 0) {
			userDAO.insert(model);
		} else {
			userDAO.update(model);
		}
	}

	/**
	 * 根据主键，获取一个角色
	 * 
	 * @param userId
	 * @return
	 */
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	/**
	 * 删除操作
	 * 
	 * @param userId
	 */
	public void delete(int userId) {
		userDAO.delete(userId);
	}
}
