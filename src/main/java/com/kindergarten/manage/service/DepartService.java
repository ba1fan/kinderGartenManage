package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IDepartDAO;
import com.kindergarten.manage.po.Depart;
import com.kindergarten.manage.util.Constants;

@Service
public class DepartService {
	@Autowired
	private IDepartDAO departDAO;

	/**
	 * ��ѯ����û�н��õ��û�
	 * 
	 * @return
	 */
	public List<Depart> getLists() {
		Depart args = new Depart();
		args.setStatus(Constants.NORMAL_STATUS);
		return departDAO.getDeparts(args);
	}

	/**
	 * ����������������ȡ��ɫ���б�
	 * 
	 * @param args
	 * @return ��json���ַ���
	 */
	public String getDeparts(Depart args) {
		List<Depart> departs = departDAO.getDeparts(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (departs.size() > 0) {
			for (Depart depart : departs) {
				sb.append("{\"departId\": \"").append(depart.getDepartId()).append("\",");
				sb.append("\"departName\": \"").append(depart.getDepartName()).append("\",");
				sb.append("\"status\": \"").append(depart.getStatus() == 1 ? "����" : "����").append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(departs.size()).append(" }");
		return sb.toString();
	}

	/**
	 * �������Ϊ0���������ӣ���������޸�
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
	 * ������������ȡһ����ɫ
	 * 
	 * @param departId
	 * @return
	 */
	public Depart getDepart(int departId) {
		return departDAO.getDepart(departId);
	}

	/**
	 * ɾ������
	 * 
	 * @param departId
	 */
	public void delete(int departId) {
		Depart depart = departDAO.getDepart(departId);
		depart.setStatus(Constants.DELETE_STATUS);
		departDAO.update(depart);
	}
}
