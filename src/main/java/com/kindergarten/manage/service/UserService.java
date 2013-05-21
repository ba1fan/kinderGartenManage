package com.kindergarten.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IAuthDAO;
import com.kindergarten.manage.dao.IAuthMapDAO;
import com.kindergarten.manage.dao.IUserDAO;
import com.kindergarten.manage.dao.IUserLogDAO;
import com.kindergarten.manage.po.Auth;
import com.kindergarten.manage.po.AuthMap;
import com.kindergarten.manage.po.User;
import com.kindergarten.manage.po.UserLog;

@Service
public class UserService {
	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IUserLogDAO userLogDAO;
	@Autowired
	private IAuthMapDAO authMapDAO;

	@Autowired
	private IAuthDAO authDAO;

	/**
	 * ��ȡ�����û�
	 * 
	 * @return
	 */
	public List<User> getLists() {
		User args = new User();
		return userDAO.getUsers(args);
	}

	/**
	 * ����������������ȡ�û����б�
	 * 
	 * @param args
	 * @return ��json���ַ���
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
				sb.append("\"status\": \"").append(user.getStatus() == 1 ? "����" : "����").append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(users.size()).append(" }");
		return sb.toString();
	}

	/**
	 * �������Ϊ0���������ӣ���������޸�
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
	 * ������������ȡһ����ɫ
	 * 
	 * @param userId
	 * @return
	 */
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	/**
	 * ɾ������
	 * 
	 * @param userId
	 */
	public void delete(int userId) {
		userDAO.delete(userId);
	}

	public User getLoginUser(User user) {
		return userDAO.getLoginUser(user);
	}

	public int getLoginErrorCount(int userId) {
		return userLogDAO.getLoginErrorCount(userId);
	}

	public void addUserLog(UserLog log) {
		log.setUserLogId(0);
		userLogDAO.insert(log);
	}

	public String getAuth(int userId) {
		User user = userDAO.getUser(userId);
		AuthMap authMap = authMapDAO.getAuthMapByDepartId(user.getDepartId());
		String[] str = authMap.getAuthStr().split(",");
		List<Auth> auths = new ArrayList<Auth>();
		for (int i = 0; i < str.length; i++) {
			Auth auth = authDAO.getAuthByAuthMap(Integer.parseInt(str[i]));
			auths.add(auth);
		}
		String rtn = "";
		if (auths.size() > 0) {
			String childManage = "";
			String techManage = "";
			String WageManage = "";
			String manage = "";
			String authManage = "";
			for (Auth auth : auths) {
				if (auth.getType() == 2) {
					childManage += "<ul><li url=\"" + auth.getUrl() + "\"><span>" + auth.getName()
							+ "</span></li></ul>";
				}
				if (auth.getType() == 3) {
					techManage += "<ul><li url=\"" + auth.getUrl() + "\"><span>" + auth.getName() + "</span></li></ul>";
				}
				if (auth.getType() == 4) {
					WageManage += "<ul><li url=\"" + auth.getUrl() + "\"><span>" + auth.getName() + "</span></li></ul>";
				}
				if (auth.getType() == 5) {
					manage += "<ul><li url=\"" + auth.getUrl() + "\"><span>" + auth.getName() + "</span></li></ul>";
				}
				if (auth.getType() == 6) {
					authManage += "<ul><li url=\"" + auth.getUrl() + "\"><span>" + auth.getName() + "</span></li></ul>";
				}
			}
			if (!childManage.equals("")) {
				rtn += "<li isexpand=\"false\"><span>�׶�����</span>" + childManage + "</li>";
			}
			if (!techManage.equals("")) {
				rtn += "<li isexpand=\"false\"><span>�̹�����</span>" + techManage + "</li>";
			}
			if (!WageManage.equals("")) {
				rtn += "<li isexpand=\"false\"><span>�������</span>" + WageManage + "</li>";
			}
			if (!manage.equals("")) {
				rtn += "<li isexpand=\"false\"><span>����ά��</span>" + manage + "</li>";
			}
			if (!authManage.equals("")) {
				rtn += "<li isexpand=\"false\"><span>ϵͳ����</span>" + authManage + "</li>";
			}
		}
		return rtn;
	}
}
