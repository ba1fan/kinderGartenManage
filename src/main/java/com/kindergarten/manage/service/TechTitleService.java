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
	 * 查询所有职称
	 * 
	 * @return
	 */
	public List<TechTitle> getLists() {
		TechTitle args = new TechTitle();
		return techTitleDAO.getTechTitles(args);
	}

	/**
	 * 根据搜索条件来获取职称的列表
	 * 
	 * @param args
	 * @return 类json的字符串
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
	 * 如果主键为0，就是增加，否则就是修改
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
	 * 根据主键，获取一个职称
	 * 
	 * @param techtitleId
	 * @return
	 */
	public TechTitle getTechTitle(int titleId) {
		return techTitleDAO.getTechTitle(titleId);
	}

	/**
	 * 删除操作
	 * 
	 * @param techtitleId
	 */
	public void delete(int titleId) {
		techTitleDAO.delete(titleId);
	}
}
