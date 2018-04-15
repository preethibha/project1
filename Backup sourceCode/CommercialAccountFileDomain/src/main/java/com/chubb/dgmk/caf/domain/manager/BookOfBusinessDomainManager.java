package com.chubb.dgmk.caf.domain.manager;

import com.chubb.dgmk.caf.domain.resource.ResourceRequestResult;
import com.chubb.dgmk.caf.jms.accessors.CommercialBookOfBusinessAccessor;

/**
 * <pre>
 * BookOfBusinessDomainManager
 * May 14, 2015
 * 
 * The BookOfBusinessDomainManager is responsible for submitting requests to the 
 * CommercialBookOfBusiness application via MQ. * Requests are one-way to ensure 
 * performance requirements are met.  The CommercialBookOfBusiness application will 
 * send an email containing a spreadsheet of Accounts, Policies and Chubb Contacts for 
 * the requested Producer to the specified email address.  Failure to put a message to 
 * the CommercialBookOfBusiness Request Queue will result in an error being returned to the caller.
 *
 * </pre> 
 */
public class BookOfBusinessDomainManager {
	
	private String errorCode="S";
	private String errorMessage="";
	/**
	 * <pre>
	 * submitBookOfBusinessRequest
	 * 
	 * May 14, 2015
	 * 
	 * This method will get the result from provider service and will
	 * call the method uiResourceFromDomain to map service reply object 
	 * to the UI Resource Object
	 * 
	 * @param producerNumber
	 * @param producerSubNumber
	 * @param emailAddress
	 * @return Result object with status = "S" on successful send. 
	 * If an exception occurs, update status to "E" along with a friendly message.  Append
	 * the exception message for problem reporting
	 * </pre>
	 */
	public ResourceRequestResult submitBookOfBusinessRequest(String producerNumber, String producerSubNumber, String emailAddress){
		
		CommercialBookOfBusinessAccessor accessor = new CommercialBookOfBusinessAccessor();
		
		try {
			accessor.submitBookOfBusinessRequest(producerNumber, producerSubNumber, emailAddress);
		} catch (Exception ex){
			errorCode = "E";
			errorMessage = "Exception occurred processing the submitBookOfBusinessRequest process: " + ex.getMessage();
			
		}
		return uiResourceFromDomain();
						
	}

	/**
	 * <pre>
	 * uiResourceFromDomain
	 * 
	 * May 14, 2015
	 * 
	 * Transform the service reply object to the UI Resource Object
	 * Set the error code and error message.
	 * 
	 * @return ResourceRequestResult
	 * 
	 * </pre>
	 */
	private ResourceRequestResult uiResourceFromDomain() {
		
		ResourceRequestResult requestResult = new ResourceRequestResult();
		requestResult.setStatusCode(errorCode);
		requestResult.setStatusMessage(errorMessage);
		return requestResult;
		
	}
	
}
