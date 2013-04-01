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
	 * ��ѯ����ѧ��
	 * 
	 * @return
	 */
	public List<Educate> getLists() {
		Educate args = new Educate();
		return educateDAO.getEducates(args);
	}

	/**
	 * ����������������ȡѧ�����б�
	 * 
	 * @param args
	 * @return ��json���ַ���
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
	 * �������Ϊ0���������ӣ���������޸�
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
	 * ������������ȡһ��ѧ��
	 * 
	 * @param educateId
	 * @return
	 */
	public Educate getEducate(int educateId) {
		return educateDAO.getEducate(educateId);
	}

	/**
	 * ɾ������
	 * 
	 * @param educateId
	 */
	public void delete(int educateId) {
		educateDAO.delete(educateId);
	}
}
