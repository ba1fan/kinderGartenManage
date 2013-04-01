package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.ITechTitleDAO;
import com.kindergarten.manage.po.TechTitle;

@Service
public class TechTitleService {
	@Autowired
	private ITechTitleDAO techTitleDAO;

	/**
	 * ��ѯ����ְ��
	 * 
	 * @return
	 */
	public List<TechTitle> getLists() {
		TechTitle args = new TechTitle();
		return techTitleDAO.getTechTitles(args);
	}

	/**
	 * ����������������ȡְ�Ƶ��б�
	 * 
	 * @param args
	 * @return ��json���ַ���
	 */
	public String getTechTitles(TechTitle args) {
		List<TechTitle> techtitles = techTitleDAO.getTechTitles(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (techtitles.size() > 0) {
			for (TechTitle techtitle : techtitles) {
				sb.append("{\"titleId\": \"").append(techtitle.getTitleId()).append("\",");
				sb.append("\"titleName\": \"").append(techtitle.getTitleName()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(techtitles.size()).append(" }");
		return sb.toString();
	}

	/**
	 * �������Ϊ0���������ӣ���������޸�
	 * 
	 * @param model
	 */
	public void save(TechTitle model) {
		if (model.getTitleId() == 0) {
			techTitleDAO.insert(model);
		} else {
			techTitleDAO.update(model);
		}
	}

	/**
	 * ������������ȡһ��ְ��
	 * 
	 * @param techtitleId
	 * @return
	 */
	public TechTitle getTechTitle(int titleId) {
		return techTitleDAO.getTechTitle(titleId);
	}

	/**
	 * ɾ������
	 * 
	 * @param techtitleId
	 */
	public void delete(int titleId) {
		techTitleDAO.delete(titleId);
	}
}
