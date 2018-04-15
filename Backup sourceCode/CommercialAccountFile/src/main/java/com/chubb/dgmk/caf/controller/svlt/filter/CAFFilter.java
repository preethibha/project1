package com.chubb.dgmk.caf.controller.svlt.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import pagecode.bean.CAFBean;
import chubb.ecom.util.ECommerceUserInfo;

import com.chubb.dgmk.caf.domain.manager.ContactChubbDomainManager;
import com.chubb.dgmk.caf.domain.model.UserInformation;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;
import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.domain.resource.UserResource;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;

/**
 * Servlet Filter implementation class CAFFilter
 */
/**
 * @author P62240B
 * The CAFFilter will receive all requests targeted to the CommercialAccountFile context and validate that the
 * user type and related Producer Numbers are available in the session.  If they are not present, the filter
 * will build a new instance of the CAFBean and value the required elements from the GetAccess header.
 */
public class CAFFilter implements Filter {

	FilterConfig filterConfig;

    /**
     * Default constructor. 
     */
    public CAFFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	       try{
	    		HttpServletRequest srequest = (HttpServletRequest) request;
	    		Object obj = srequest.getAttribute("cafBean");
	    		if (obj == null){
	    			CAFBean cafBean = new CAFBean();
	    		
	    		   setProfileData(cafBean, srequest);
	    			srequest.setAttribute("cafBean", cafBean);
	    		}
	    		chain.doFilter(request, response);
	    	} catch (ServletException sx) {
	        	getFilterConfig().getServletContext().log(sx.getMessage());
	        } catch (IOException iox) {
	        	getFilterConfig().getServletContext().log(iox.getMessage());
	        }
		}

	/**
	 * @param cafBean
	 * @param request
	 * Set the user type and producer number list from the GetAccess header.
	 * check whether the incoming string has length more than or equal to 12 or not.
	 * If not show the error message, otherwise split the string to get the producer number and sub producer number
	 * First 7 characters are producer numbers and last 5 characters are sub producers
	 * 
	 */
	private void setProfileData(CAFBean cafBean, HttpServletRequest request) {
		ECommerceUserInfo userInfo=null;
		String envStr=CAFPropertiesUtil.getEnvironment();
		try{
			userInfo = new ECommerceUserInfo(request);

			if(userInfo==null || userInfo.isEmpty()){
				if(ICAFConstants.LOCAL_ENV.equals(envStr)){
					
					setProfileDataFromCrp31X1(cafBean, request);
					setProfileDataStub(cafBean, request);
					return;
				}else{
					CAFLogger.logInfo("GA Header info not found for non-local environment: " + envStr, this.getClass().getName(), "setProfileData");
					throw new Exception();
				}
			}
		}catch (Exception e){
			CAFLogger.logWarning("GA Header info not found. Stack trace follows. ", this.getClass().getName(), "setProfileData");
			e.printStackTrace();
			return;
		}
		
		cafBean.setEmailAddress(userInfo.getEMailAddr());
		cafBean.setUserFirstName(userInfo.getUserName().substring(0, userInfo.getUserName().indexOf("$")));
		String userType = userInfo.getUserTypeCode();
		String userId = userInfo.getUserId();
		cafBean.setUserType(userType);
		//cafBean.setUserType("CHBEMP");
		cafBean.setUserId(userId);
		//if user is an agent, continue to collect producer numbers; if employee, we're done
		if (!ICAFConstants.AGENT.equalsIgnoreCase(userType)){
			return;
		}
		
		//get the full set of producer numbers.  Per Brad, this is the compete set.  Concept of Primary or First is out of date
		List<ProducerKey> prodKeys = new ArrayList<ProducerKey>();
		String[] producerNumbers = userInfo.getAllProducerNumbers();
		if (producerNumbers.length == 0){
			CAFLogger.logInfo("User: " + userId + "of type: " +userType + " has no associated Producer Numbers " , this.getClass().getName(),"setProfileData");
			return;
		}
		List<String> producerNumberStrings = Arrays.asList(producerNumbers);
		for (String concatProdNumber:producerNumberStrings){
			if (concatProdNumber.length() == ICAFConstants.PRODUCER_KEY_MAX_LENGTH){
				prodKeys.add(new ProducerKey(concatProdNumber));
			
			}
			else 
				CAFLogger.logInfo("Producer Numbers of incorrect length found.  Bypassing add of value: " + concatProdNumber, this.getClass().getName(),"setProfileData");
		}
		CAFLogger.logInfo("Associated Producer Numbers : " + Arrays.toString(prodKeys.toArray()) + " found for user: " + userId, this.getClass().getName(),"setProfileData");
		cafBean.setProducerKeys(prodKeys);
		CAFLogger.logInfo("User: " + userId+ " has related ProducerKey size : " + prodKeys.size(), this.getClass().getName(),"setProfileData");
	
	}
	
	
	/**
	 * @param cafBean
	 * @param request
	 * Set the user type and producer number for local testing.
	 */
	private void setProfileDataStub(CAFBean cafBean, HttpServletRequest request) {
		
		cafBean.setUserType(ICAFConstants.AGENT ); 
		//cafBean.setUserId("npgm41o");
		//ProducerKey producerKeySample1 = new ProducerKey("0035795","99999");
		//ProducerKey producerKeySample2 = new ProducerKey("0024617","00000");
		//ProducerKey producerKeySample3 = new ProducerKey("0077509","99999");

		ProducerKey producerKeySample1 = new ProducerKey("0041714","99999");
		ProducerKey producerKeySample2 = new ProducerKey("0041714","00001");
		ProducerKey producerKeySample3 = new ProducerKey("0027065","99999");
		
		List<ProducerKey> producerKeys = new ArrayList<ProducerKey>();
		producerKeys.add(producerKeySample1);
		producerKeys.add(producerKeySample2);
		producerKeys.add(producerKeySample3);
		CAFLogger.logInfo("GA Header info not found.  Setting to default producerKeys to: " + producerKeySample1.toString()+";" + producerKeySample2.toString() + producerKeySample3.toString(), this.getClass().getName(),"setProfileDataStub");			
		cafBean.setProducerKeys(producerKeys);
		
		cafBean.setEmailAddress("rpanda@chubb.com");
		cafBean.setUserFirstName("User Stub");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
	
	/**
	 * @param cafBean
	 * @param request
	 * Set the user type and producer number list from the GetAccess header.
	 * check whether the incoming string has length more than or equal to 12 or not.
	 * If not show the error message, otherwise split the string to get the producer number and sub producer number
	 * First 7 characters are producer numbers and last 5 characters are sub producers
	 * 
	 */
	private void setProfileDataFromCrp31X1(CAFBean cafBean, HttpServletRequest request) {
		UserInformation userInfo=null;
		String envStr=CAFPropertiesUtil.getEnvironment();
		try{
			UserResource userResource= new UserResource();
			String userId = request.getParameter("userId");
			String externalUserId = request.getParameter("externalUserId");
			//For local testing
			if(null == externalUserId){
				externalUserId="maagt_07";
			}
			userResource.setExternalUserId(externalUserId);
			userResource.setUserId(userId);
			/*ContactChubbDomainManager mgr = new ContactChubbDomainManager();
			ResourceRequestResult result = mgr.retrieveUserInfo(userResource);
			
			userInfo = result.getUserInformation();*/

			if(userInfo==null){
				if(ICAFConstants.LOCAL_ENV.equals(envStr)){
					setProfileDataStub(cafBean, request);
					return;
				}else{
					CAFLogger.logInfo("GA Header info not found for non-local environment: " + envStr, this.getClass().getName(), "setProfileData");
					throw new Exception();
				}
			}
		}catch (Exception e){
			CAFLogger.logWarning("GA Header info not found. Stack trace follows. ", this.getClass().getName(), "setProfileData");
			e.printStackTrace();
			return;
		}
		
		cafBean.setEmailAddress(userInfo.getEmail());
		cafBean.setUserFirstName(userInfo.getGivenName());
		String userType = userInfo.getUserTypeCode();
		String userId = userInfo.getUserid();
		cafBean.setUserType(userType);
		//cafBean.setUserType("CHBEMP");
		cafBean.setUserId(userId);
		//if user is an agent, continue to collect producer numbers; if employee, we're done
		if (!ICAFConstants.AGENT.equalsIgnoreCase(userType)){
			return;
		}
		
		//get the full set of producer numbers.  Per Brad, this is the compete set.  Concept of Primary or First is out of date
		List<ProducerKey> prodKeys = new ArrayList<ProducerKey>();
		List<String> producerNumbers = userInfo.getProducerkeys();
		if (null == producerNumbers || producerNumbers.size() == 0){
			CAFLogger.logInfo("User: " + userId + "of type: " +userType + " has no associated Producer Numbers " , this.getClass().getName(),"setProfileData");
			return;
		}
		for (String concatProdNumber:producerNumbers){
			if (concatProdNumber.length() == ICAFConstants.PRODUCER_KEY_MAX_LENGTH){
				prodKeys.add(new ProducerKey(concatProdNumber));
			
			}
			else 
				CAFLogger.logInfo("Producer Numbers of incorrect length found.  Bypassing add of value: " + concatProdNumber, this.getClass().getName(),"setProfileData");
		}
		CAFLogger.logInfo("Associated Producer Numbers : " + Arrays.toString(prodKeys.toArray()) + " found for user: " + userId, this.getClass().getName(),"setProfileData");
		cafBean.setProducerKeys(prodKeys);
		CAFLogger.logInfo("User: " + userId+ " has related ProducerKey size : " + prodKeys.size(), this.getClass().getName(),"setProfileData");
	
	}
}
