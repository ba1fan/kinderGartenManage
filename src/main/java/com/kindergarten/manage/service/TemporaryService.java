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
	 * 获取所有临时工
	 * 
	 * @return
	 */
	public List<Temporary> getLists() {
		Temporary args = new Temporary();
		return temporaryDAO.getTemporarys(args);
	}

	/**
	 * 根据搜索条件来获取临时工的列表
	 * 
	 * @param args
	 * @return 类json的字符串
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
	 * 如果主键为0，就是增加，否则就是修改
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
	 * 根据主键
	 * 
	 * @param TemporaryId
	 * @return
	 */
	public Temporary getTemporary(int temporaryId) {
		return temporaryDAO.getTemporary(temporaryId);
	}

	/**
	 * 删除操作
	 * 
	 * @param TemporaryId
	 */
	public void delete(int temporaryId) {
		temporaryDAO.delete(temporaryId);
	}
}
