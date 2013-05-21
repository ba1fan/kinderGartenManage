package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kindergarten.manage.dao.ITeacherInfoDAO;
import com.kindergarten.manage.dao.ITeacherLogDAO;
import com.kindergarten.manage.po.TeacherInfo;
import com.kindergarten.manage.po.TeacherLog;
import com.kindergarten.manage.util.Constants;

@Service
public class TeacherService {
	@Autowired
	private ITeacherInfoDAO infoDAO;
	@Autowired
	private ITeacherLogDAO logDAO;

	public String getTeacherInfos(TeacherInfo args) {
		List<TeacherInfo> infos = infoDAO.getTeacherInfos(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (infos.size() > 0) {
			for (TeacherInfo info : infos) {
				sb.append("{\"teacherId\": \"").append(info.getTeacherId()).append("\",");
				sb.append("\"teacherName\": \"").append(info.getTeacherName()).append("\",");
				sb.append("\"age\": \"").append(info.getAge()).append("\",");
				sb.append("\"sex\": \"").append(info.getSex() == 0 ? "男" : "女").append("\",");
				sb.append("\"tel\": \"").append(info.getTel()).append("\",");
				sb.append("\"teacherName\": \"").append(info.getTeacherName()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(infos.size()).append(" }");
		return sb.toString();
	}

	public void save(TeacherInfo model) {
		if (model.getTeacherId() == 0) {
			infoDAO.insert(model);
		} else {
			updateTeacher(model);
		}
	}

	/**
	 * 根据主键获取
	 * 
	 * @param educateId
	 * @return
	 */
	public TeacherInfo getTeacherInfo(int teacherId) {
		return infoDAO.getTeacherInfo(teacherId);
	}

	public void updateTeacher(TeacherInfo model) {
		TeacherInfo info = getTeacherInfo(model.getTeacherId());
		TeacherLog log = new TeacherLog();
		log.setTeacherId(model.getTeacherId());
		if (info.getDepartId() != model.getDepartId()) {
			log.setLogType(Constants.LOG_TYPE_DEPART);
			log.setResFromId(info.getDepartId());
			log.setResToId(model.getDepartId());
			logDAO.insert(log);
		}
		if (info.getEducateId() != model.getEducateId()) {
			log.setLogType(Constants.LOG_TYPE_EDUCATE);
			log.setResFromId(info.getEducateId());
			log.setResToId(model.getEducateId());
			logDAO.insert(log);
		}
		if (info.getTitleId() != model.getTitleId()) {
			log.setLogType(Constants.LOG_TYPE_TITLE);
			log.setResFromId(info.getTitleId());
			log.setResToId(model.getTitleId());
			logDAO.insert(log);
		}
		infoDAO.update(model);
	}

	public void getLogView(int teacherId, Model model) {
		TeacherLog log = new TeacherLog();
		log.setTeacherId(teacherId);
		log.setLogType(Constants.LOG_TYPE_DEPART);
		model.addAttribute("departLog", logDAO.getTeacherDepartLogs(log));
		log.setLogType(Constants.LOG_TYPE_EDUCATE);
		model.addAttribute("educateLog", logDAO.getTeacherEducateLogs(log));
		log.setLogType(Constants.LOG_TYPE_TITLE);
		model.addAttribute("titleLog", logDAO.getTeacherTitleLogs(log));
	}

	public void delete(int teacherId) {
		infoDAO.delete(teacherId);
	}
}
