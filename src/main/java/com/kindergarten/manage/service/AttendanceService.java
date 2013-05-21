package com.kindergarten.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindergarten.manage.dao.IAttendanceDAO;
import com.kindergarten.manage.po.Attendance;
import com.kindergarten.manage.util.TimeMethod;

@Service
public class AttendanceService {
	@Autowired
	private IAttendanceDAO attendanceDAO;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Attendance> getLists(Attendance args) {
		return attendanceDAO.getAttendances(args);
	}

	/**
	 * 根据搜索条件来获取列表
	 * 
	 * @param args
	 * @return 类json的字符串
	 */
	public String getAttendances(Attendance args) {
		if (args.getYear() == 0) {
			args.setYear(TimeMethod.getNowYear());
		}
		if (args.getMonth() == 0) {
			args.setMonth(TimeMethod.getNowMonth());
		}

		List<Attendance> attendances = attendanceDAO.getAttendances(args);
		StringBuilder sb = new StringBuilder();
		sb.append("{ Rows: [");
		if (attendances.size() > 0) {
			for (Attendance attendance : attendances) {
				sb.append("{\"attendId\": \"").append(attendance.getAttendId()).append("\",");
				sb.append("\"childName\": \"").append(attendance.getChildName()).append("\",");
				sb.append("\"count\": \"").append(attendance.getCount()).append("\"},");
			}
			sb.substring(0, sb.length());
		}
		sb.append("], Total: ").append(attendances.size()).append(" }");
		return sb.toString();
	}

	/**
	 * 如果主键为0，就是增加，否则就是修改
	 * 
	 * @param model
	 */
	public void save(Attendance model) {
		if (model.getAttendId() == 0) {
			Attendance args = new Attendance();
			args.setMonth(model.getMonth());
			args.setYear(model.getYear());
			args.setChildId(model.getChildId());
			List<Attendance> attendances = attendanceDAO.getAttendances(args);
			if (attendances.size() == 0) {
				attendanceDAO.insert(model);
			} else {
				attendances.get(0).setCount(model.getCount());
				attendanceDAO.update(attendances.get(0));
			}
		} else {
			attendanceDAO.update(model);
		}
	}

	/**
	 * 根据主键
	 * 
	 * @param
	 * @return
	 */
	public Attendance getClazz(int attendId) {
		return attendanceDAO.getAttendance(attendId);
	}

}
