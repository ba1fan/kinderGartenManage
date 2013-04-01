package com.kindergarten.manage.util;

import java.sql.Timestamp;

public class TimeMethod {
	public static Timestamp getTimestamp() {
		Timestamp d = new Timestamp(System.currentTimeMillis());
		return d;
	}
}
