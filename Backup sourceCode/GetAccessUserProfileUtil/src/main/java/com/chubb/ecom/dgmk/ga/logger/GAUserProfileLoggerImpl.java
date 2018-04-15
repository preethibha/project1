package com.chubb.ecom.dgmk.ga.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.dgmk.common.util.LogMessageFormatter;
import com.chubb.ecom.dgmk.ga.util.GAUserProfileServiceConstants;
import com.chubb.util.Jndi;

public class GAUserProfileLoggerImpl implements ILogger, GAUserProfileServiceConstants {

	private static ILogger INSTANCE = new GAUserProfileLoggerImpl();
	protected Logger logger;
	protected FileHandler filehandler;

	protected String logLocationRoot() {
		return Jndi.getChubbAppWorkspaceRoot();
	}
	protected String logLocationSubfolder() {
			return Jndi.getChubbServer();
	}
	
	protected GAUserProfileLoggerImpl() {
		logger = createLogger();
		try {
			filehandler = createFileHandler();
		} catch (IOException ioe) {
			throw new RuntimeException(
					"IO Exception whan attempting to get GaUserProfile.log file",
					ioe);
		}
		logger.addHandler(filehandler);
	}
	
	/**
	 * Gets the singleton instance.
	 *
	 * @return the logger
	 */
	public static ILogger getLogger() {
		if (null == INSTANCE) {
			INSTANCE = new GAUserProfileLoggerImpl();
		}
		return INSTANCE;
	}	

	protected Logger createLogger() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.setUseParentHandlers(false);
		return logger;
	}
	
	protected FileHandler createFileHandler() throws IOException {

		FileHandler filehandler = new FileHandler(logLocationRoot() + logLocationSubfolder() + GA_APPLICATION_LOG_PATH + GA_APPLICATION_LOG_FILE, 2000000, 20);
		filehandler.setFormatter(new LogMessageFormatter());
		return filehandler;
	}

	public boolean isLoggable(Level level) {
		return logger.isLoggable(level);
	}
	
	public void log(Level level, String msg, String sourceClassName,
			String sourceMethodName) {
		if (isLoggable(level)) {
			LogRecord record = new LogRecord(level, msg);
			if (!(null == sourceClassName)) {
				record.setSourceClassName(sourceClassName);
			}
			if (!(null == sourceMethodName)) {
				record.setSourceMethodName(sourceMethodName);
			}
			filehandler.getFormatter().format(record);
			logger.log(record);
		} 
	}

	public void log(Level level, String msg, Throwable t) {
		if (isLoggable(level)) {
			LogRecord record = new LogRecord(level, msg);
			filehandler.getFormatter().format(record);
			logger.log(level, msg + " - " + getStackTrace(t));
		} 
	}
	
	public void logInfo(String message, String className, String methodName) {
		log(Level.INFO, message, className, methodName);
	}
	
	public void logFine(String message, String className, String methodName) {
		log(Level.FINE, message, className, methodName);
	}
	
	public void logWarning(String message, String className, String methodName) {
		log(Level.WARNING, message, className, methodName);
	}
	
	public void logSevere(String message, String className, String methodName) {
		log(Level.SEVERE, message, className, methodName);
	}

	public void logEntry(String className, String methodName) {
		logInfo("Entering method", className, methodName);
	}

	public void logExit(String className, String methodName) {
		logInfo("Exiting method", className, methodName);
	}

	
	private static String getStackTrace(Throwable aThrowable) {
	    final Writer result = new StringWriter();
	    final PrintWriter printWriter = new PrintWriter(result);
	    aThrowable.printStackTrace(printWriter);
	    return result.toString();
	  }

}