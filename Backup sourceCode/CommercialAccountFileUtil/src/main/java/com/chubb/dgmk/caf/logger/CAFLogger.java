package com.chubb.dgmk.caf.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.chubb.dgmk.caf.util.ICAFConstants;
import com.chubb.util.Jndi;

/**
 * @author P62240B
 * The CAFLogger is responsible for creating a Singleton instance for use
 * in logging all application level and exception messages. 
 */
public class CAFLogger implements ICAFConstants {

	// Single instance of class
	private static CAFLogger INSTANCE = new CAFLogger();
	// Single instance of Logger
	protected Logger logger;
	// Single instance of FileHandler
	protected FileHandler filehandler;
	// Path for location of log file
	protected String logLocationRoot() {
		return Jndi.getChubbAppWorkspaceRoot();
	}
	protected String logLocationSubfolder() {
			return Jndi.getChubbServer();
	}
	/**
	 * Private constructor for singleton
	 *
	 */
	protected CAFLogger() {
		logger = createLogger();
		try {
			/**
			 * Specifies a rotating set of log files, each with a size limit =
			 * n number of bytes. When (approximately) the given limit has been
			 * written to one file, another file will be opened. The output will
			 * cycle through a set of files.
			 * 
			 */
			filehandler = createFileHandler();

		} catch (IOException ioe) {
			throw new RuntimeException(
					"IO Exception whan attempting to get CommercialAccountFile.log file",
					ioe);
		}
		// Send logger output to filehandler.
		logger.addHandler(filehandler);
	}

	protected Logger createLogger() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		// Prevents logging to system.out
		logger.setUseParentHandlers(false);
		return logger;
	}
	
	protected FileHandler createFileHandler() throws IOException {

		FileHandler filehandler = new FileHandler(logLocationRoot() + logLocationSubfolder() + CAF_APPLICATION_LOG_PATH + CAF_APPLICATION_LOG_FILE, 2000000, 20);
		filehandler.setFormatter(new CAFLogMessageFormatter());
		return filehandler;
	}
	
	public static CAFLogger getLogger() {
		if (null == INSTANCE) {
			INSTANCE = new CAFLogger();
		}
		return INSTANCE;
	}

	public boolean isLoggable(Level level) {
		return logger.isLoggable(level);
	}
	
	/**
	 * Log a String
	 * @param level
	 * @param msg
	 * @param sourceClassName
	 * @param sourceMethodName
	 */
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
	
	public static void logInfo(String message, String className, String methodName) {
		getLogger().log(Level.INFO, message, className, methodName);
	}
	
	public static void logFine(String message, String className, String methodName) {
		getLogger().log(Level.FINE, message, className, methodName);
	}
	
	public static void logWarning(String message, String className, String methodName) {
		getLogger().log(Level.WARNING, message, className, methodName);
	}
	
	public static void logSevere(String message, String className, String methodName) {
		getLogger().log(Level.SEVERE, message, className, methodName);
	}

	private static String getStackTrace(Throwable aThrowable) {
	    final Writer result = new StringWriter();
	    final PrintWriter printWriter = new PrintWriter(result);
	    aThrowable.printStackTrace(printWriter);
	    return result.toString();
	  }

}