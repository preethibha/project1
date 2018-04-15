package com.chubb.ecom.dgmk.ga.controller.svlt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chubb.dgmk.common.logger.ILogger;
import com.chubb.ecom.dgmk.ga.logger.GAUserProfileLoggerImpl;
import com.chubb.ecom.dgmk.ga.util.GAPropertiesFileDigesterUtil;
import com.chubb.ecom.dgmk.ga.util.GAUserProfilePropertiesUtil;
import com.chubb.util.Jndi;

/**
 * Servlet implementation class GAUserProfileInitServlet.
 */
public class GAUserProfileInitServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The logger. This should be injected by IOC framework */
	private ILogger logger;

	/**
	 * Instantiates a new ga user profile intialization servlet.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public GAUserProfileInitServlet() {
		super();

		// get the default logger if object is not set by IOC framework
		if (logger == null) {
			logger = GAUserProfileLoggerImpl.getLogger();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig servletConfig) throws ServletException {
		
		super.init(servletConfig);

		// load JNDI values into the GAUserProfilePropertiesUtil
		loadJNDIProperties();

		// Load gaproperties.xml file into GAUserProfilePropertiesUtil
		try {
			String prefix = getServletContext().getRealPath("/");
			GAUserProfilePropertiesUtil.setRealPath(prefix);

			// Load gaproperties.xml file into GAUserProfilePropertiesUtil
			loadGAPropertiesFile();
			logger.log(Level.INFO,
					"GA User Profile Properties are loaded successfully", this
							.getClass().getName(), "init");

		} catch (Exception e) {
			logger.log(Level.WARNING, "Init Failed ! " + e.getMessage(), this
					.getClass().getName(), "init");
			throw new UnavailableException(e.getMessage());
		}
		logger.log(Level.INFO,
				"GA User Profile is initialized and open for business", this
						.getClass().getName(), "init");
		return;
	}

	/**
	 * Load jndi properties.
	 */
	private void loadJNDIProperties() {

		logger.log(Level.FINE, "loadJNDIProperties Entry", this.getClass()
				.getName(), "loadJNDIProperties");

		GAUserProfilePropertiesUtil.setChubbAppWorkspaceRoot(Jndi
				.getChubbAppWorkspaceRoot());
		logger.log(
				Level.INFO,
				"ChubbAppWorkspaceRoot set to : "
						+ Jndi.getChubbAppWorkspaceRoot(), this.getClass()
						.getName(), "loadJNDIProperties");

		GAUserProfilePropertiesUtil.setChubbNodeInstanceName(Jndi
				.getChubbNodeInstance());
		logger.log(
				Level.INFO,
				"ChubbNodeInstanceName set to : " + Jndi.getChubbNodeInstance(),
				this.getClass().getName(), "loadJNDIProperties");

		GAUserProfilePropertiesUtil.setEnvironment(Jndi.getChubbLevel());
		logger.log(Level.INFO,
				"ChubbLevel (environment) set to : " + Jndi.getChubbLevel(),
				this.getClass().getName(), "loadJNDIProperties");

		GAUserProfilePropertiesUtil.setChubbServer(Jndi.getChubbServer());
		logger.log(Level.INFO, "ChubbServer set to : " + Jndi.getChubbServer(),
				this.getClass().getName(), "loadJNDIProperties");

		logger.log(Level.FINE, "loadJNDIProperties Exit", this.getClass()
				.getName(), "loadJNDIProperties");

		return;
	}

	/**
	 * Load GA User Profile properties file.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	private void loadGAPropertiesFile() throws Exception {

		// Load the GA User Profile Application Level properties.
		URL url = null;
		String[] args = new String[3];
		try {
			Properties properties = new Properties();
			properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"com.ibm.ws.naming.util.WsnInitCtxFactory");
			Context jndiContext = new InitialContext(properties);
			url = (URL) jndiContext.lookup("url/gaproperties");
			logger.log(Level.INFO,
					"GA User Profile Properties URL: " + url.toString(), this
							.getClass().getName(), "loadGAPropertiesFile");

			args[0] = url.getPath();
			args[1] = url.getFile();
			args[2] = GAUserProfilePropertiesUtil.getEnvironment();

			InputStream is = url.openStream();

			GAPropertiesFileDigesterUtil.loadXMLProperties(args, is);

		} catch (Exception e) {
			logger.log(Level.SEVERE,
					"Unable to load GA User Profile properties: " + url.toString() + " in "
							+ args[0] + " environment", this.getClass()
							.getName(), "loadGAPropertiesFile");
			throw new Exception(e);
		}
		logger.log(Level.INFO, " GA User Profile properties initialized from: " + url, this
				.getClass().getName(), "loadGAPropertiesFile");
	}

	/**
	 * Do get.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Do post.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * Sets the logger.
	 * 
	 * @param logger
	 *            the new logger
	 */
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

}
