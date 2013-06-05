package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.ITemporaryDAO;
import com.kindergarten.manage.po.Temporary;

@Service
public class TemporaryService {
	@Autowired
	private ITemporaryDAO temporaryDAO;

	/**
	 * ��ȡ������ʱ��
	 * 
	 * @return
	 */
	public List<Temporary> getLists() {
		Temporary args = new Temporary();
		return temporaryDAO.getTemporarys(args);
	}

	/**
	 * ����������������ȡ��ʱ�����б�
	 * 
	 * @param args
	 * @return ��json���ַ���
	 */
	public String getTemporarys(Temporary args) {
		List<Temporary> temporarys = temporaryDAO.getTemporarys(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (temporarys.size() > 0) {
			for (Temporary temporary : temporarys) {
				sb.append("{\"userName\": \"").append(temporary.getUserName()).append("\",");
				sb.append("\"year\": \"").append(temporary.getYear()).append("\",");
				sb.append("\"temporaryId\": \"").append(temporary.getTemporaryId()).append("\",");
				sb.append("\"month\": \"").append(temporary.getMonth()).append("\",");
				sb.append("\"basic\": \"").append(temporary.getBasic()).append("\",");
				sb.append("\"award\": \"").append(temporary.getAward()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(temporarys.size()).append(" }");
		return sb.toString();
	}

	/**
	 * �������Ϊ0���������ӣ���������޸�
	 * 
	 * @param model
	 */
	public void save(Temporary model) {
		if (model.getTemporaryId() == 0) {
			temporaryDAO.insert(model);
		} else {
			temporaryDAO.update(model);
		}
	}

	/**
	 * ��������
	 * 
	 * @param TemporaryId
	 * @return
	 */
	public Temporary getTemporary(int temporaryId) {
		return temporaryDAO.getTemporary(temporaryId);
	}

	/**
	 * ɾ������
	 * 
	 * @param TemporaryId
	 */
	public void delete(int temporaryId) {
		temporaryDAO.delete(temporaryId);
	}
}
