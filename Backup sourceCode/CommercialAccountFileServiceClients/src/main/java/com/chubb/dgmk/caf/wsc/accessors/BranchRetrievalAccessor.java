package com.chubb.dgmk.caf.wsc.accessors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.chubb.dgmk.caf.domain.model.Branch;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;

import ei.core.extendedbranch.ExtendedBranch;
import ei.corporate.branch_retrieval_crp2x1_http.BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy;
import ei.corporate.branch_retrieval_crp2x1_http.GetBranchListSimpleFaultReplyMsg;
import ei.corporate.get_branch_list_reply_crp2x1.GetBranchListReply;

/**
 * <pre>
 * BranchRetrievalAccessor
 * May 7, 2015
 * 
 * The BranchRetrievalAccessor class is responsible for retrieving the list of 
 * branches available on the database.  Data is obtained from a back-end
 * datastore via an ICC service call.
 *
 * </pre> 
 */
public class BranchRetrievalAccessor implements ICAFConstants {

	/**
	 * <pre>
	 * getEndpoint
	 * May 7, 2015
	 * 
	 * This method is used to get BranchRetrieval service end point URL
	 * 
	 * @return the end point for the BranchRetrieval service from
	 * the properties file.
	 * 
	 * </pre>
	 */
	public String getEndpoint() {

		String endpoint = CAFPropertiesUtil.getBranchRetrievalEndpoint();
		CAFLogger.logInfo("Endpoint returned for branchRetrievalEndpoint: " + endpoint, "BranchRetrievalAccessor", "getEndpoint");

		return endpoint;
	}

	/**
	 * <pre>
	 * getBranches
	 * May 7, 2015
	 * 
	 * This method will call the ICC provider service and will get
	 * the list of branch from it
	 * 
	 * @return the list of AtChubb US-Producing branches
	 * </pre>
	 */

	public List<Branch> getBranches() throws Exception {

		String endpoint = getEndpoint();
		ArrayList<Branch> branches = new ArrayList<Branch>();

		BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy proxy = new BranchRetrievalCRP2X1HTTP_BranchRetrievalCRP2X1HttpPortProxy();
		proxy._getDescriptor().setEndpoint(endpoint);

		//call the service

		try {
			XMLGregorianCalendar providerRequest = buildRequest();
			String displayproviderRequest = setDateFormat (providerRequest);
			CAFLogger.logInfo("Request object is "+displayproviderRequest, "BranchRetrievalAccessor", "buildRequest" );
			GetBranchListReply reply = proxy.getBranchList(providerRequest);
			
			//build the domain object from the service reply
			branches = domainObjectFromProviderReply(reply);

		} catch (GetBranchListSimpleFaultReplyMsg simpleFault) {
			String msg ="Fault returned from BranchRetrievalCRP2X1Http: " + simpleFault.getFaultInfo().getFaultMessageText(); 
			CAFLogger.logSevere(msg, "BranchRetrievalAccessor", "getBranches");
			throw simpleFault;

		} catch (Exception e) {
			String msg = "Exception occurred calling BranchRetrievalCRP2X1Http: " + e;
			CAFLogger.logSevere(msg, "BranchRetrievalAccessor", "getBranches");
			e.printStackTrace();
			throw e;

		}
		return branches;

	}
	
	  private String setDateFormat(XMLGregorianCalendar date){
		 
		  if (date != null)
		  {
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
			GregorianCalendar gc = date.toGregorianCalendar();
			String formatted_date = sdf.format(gc.getTime());
			
			return formatted_date;
		  }
		  else 
		  {
			 return null;
		  }
		}


	/**
	 * <pre>
	 * buildRequest
	 * May 7, 2015
	 * 
	 * This method is used to prepare request object for service provider.
	 * 
	 * @return the XMLGregorianCalendar Object
	 * @throws Exception 
	 * </pre>
	 */

	private XMLGregorianCalendar buildRequest() throws Exception {

		XMLGregorianCalendar asOfDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
		return asOfDate;

	}

	
	/**
	 * <pre>
	 * domainObjectFromProviderReply
	 * May 7, 2015
	 * 
	 * This method will map the ICC provider reply GetBranchListReply to
	 * list of Branch CAF domain objects.
	 * 
	 * @param GetBranchListReply
	 * @return a list of Branch domain objects
	 * 
	 * </pre>
	 */

	private ArrayList<Branch> domainObjectFromProviderReply(GetBranchListReply reply) {

		ArrayList<Branch> branches = new ArrayList<Branch>();
		List<ExtendedBranch> branchList = reply.getExtendedBranch();

		for (ExtendedBranch extendedBranch:branchList){
			Branch branch = new Branch();
			branch.setBranchAbbreviation(extendedBranch.getBranchAbbreviation());
			branch.setBranchCode(extendedBranch.getBranchCode());
			branch.setBranchFaxNumber(extendedBranch.getBranchFaxNumber());
			branch.setBranchMailingLabelName(extendedBranch.getBranchMailingLabelName());
			branch.setBranchName(extendedBranch.getBranchName());
			branch.setBranchNumber(extendedBranch.getBranchNumber());
			branch.setBranchPhoneNumber(extendedBranch.getBranchPhoneNumber());
			branch.setForeignBranchIndicator(extendedBranch.getForeignBranchIndicator());
			branch.setZoneNumber(extendedBranch.getZoneNumber());
			branches.add(branch);
		}

		CAFLogger.logInfo("Domain object built from CRP2X1 response",  "BranchRetrievalAccessor", "domainObjectFromProviderReply");

		return branches;

	}

}
