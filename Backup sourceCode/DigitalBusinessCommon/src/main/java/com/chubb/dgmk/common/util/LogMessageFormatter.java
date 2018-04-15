package com.chubb.dgmk.common.util;

import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogMessageFormatter extends Formatter {

	private static final MessageFormat messageFormat = new MessageFormat(
			"[{0,date,yyyy-MM-dd'T'HH:mm:ss.SSSZ} {1}|ThreadId {2}|{3}|{4}] {5} {6}");

	private static final String lineSep = System.getProperty("line.separator");

	public LogMessageFormatter() {
		super();
	}

	@Override
	public String format(LogRecord record) {
		Object[] arguments = new Object[7];
		arguments[0] = new Date(record.getMillis());
		arguments[1] = record.getLevel();
		arguments[2] = Thread.currentThread().getId();
		arguments[3] = record.getSourceClassName();
		arguments[4] = record.getSourceMethodName();
		arguments[5] = record.getMessage();
		arguments[6] = lineSep;
		return messageFormat.format(arguments);

	}

}
