package com.chubb.dgmk.common.logger;

import java.util.logging.Level;

public interface ILogger {

	public boolean isLoggable(Level level);
	
	public void log(Level level, String msg, String sourceClassName,
			String sourceMethodName);

	public void log(Level level, String msg, Throwable t);
	
	public void logInfo(String message, String className, String methodName);
	
	public void logFine(String message, String className, String methodName);
	
	public void logWarning(String message, String className, String methodName);
	
	public void logSevere(String message, String className, String methodName);
	
	public void logEntry(String className, String methodName);

	public void logExit(String className, String methodName);
}