package com.chubb.dgmk.caf.wsc.accessors;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.chubb.dgmk.caf.util.CAFPropertiesUtil;
import com.chubb.dgmk.caf.util.ICAFConstants;
import ei.core.country.Country;
import ei.corporate.get_country_list_reply_crp10x1.GetCountryListReply;
import ei.country.country_retrieval_crp10x1_http.CountryRetrievalCRP10X1HTTP_CountryRetrievalCRP10X1HttpPortProxy;
import ei.country.country_retrieval_crp10x1_http.GetCountryListSimpleFaultReplyMsg;

public class CountryRetrievalAccessor  implements ICAFConstants{
	
	

	/**
	 * <pre>
	 * CountryRetrievalAccessor
	 * Aug 08, 2015
	 * 
	 * The CountryRetrievalAccessor class is responsible for retrieving the list of 
	 * countries available on the database.  Data is obtained from a back-end
	 * datastore via an ICC service call.
	 *
	 * </pre> 
	 */
	

		/**
		 * <pre>
		 * getEndpoint
		 * May 7, 2015
		 * 
		 * This method is used to get CountryRetrieval service end point URL
		 * 
		 * @return the end point for the CountryRetrieval service from
		 * the properties file.
		 * 
		 * </pre>
		 */
		public String getEndpoint() {

			String endpoint = CAFPropertiesUtil.getCountryRetrievalEndpoint();
		//	String endpoint = "http://EICNTRYRETREIVALCRP10X1S/CorporateServicesWeb/sca/CountryRetrievalCRP10X1Http" ;
			CAFLogger.logInfo("Endpoint returned for CountryRetrievalEndpoint: " + endpoint, "CountryRetrievalAccessor", "getEndpoint");

			return endpoint;
		}

		/**
		 * <pre>
		 * getCountries
		 * May 7, 2015
		 * 
		 * This method will call the ICC provider service and will get
		 * the list of country from it
		 * 
		 * @return the list of AtChubb US-Producing countries
		 * </pre>
		 */

		public List<Country> getCountries() throws Exception {

			String endpoint = getEndpoint();
			List<Country> countries = new ArrayList<Country>();

			CountryRetrievalCRP10X1HTTP_CountryRetrievalCRP10X1HttpPortProxy proxy = new CountryRetrievalCRP10X1HTTP_CountryRetrievalCRP10X1HttpPortProxy();
			proxy._getDescriptor().setEndpoint(endpoint);

			//call the service

			try {
				XMLGregorianCalendar providerRequest = buildRequest();
				String displayproviderRequest = setDateFormat (providerRequest);
				CAFLogger.logInfo("Request object is "+displayproviderRequest, "CountryRetrievalAccessor", "buildRequest" );
				GetCountryListReply reply = proxy.getCountryList(providerRequest);
				
				//build the domain object from the service reply
				countries = domainObjectFromProviderReply(reply);

			} catch (GetCountryListSimpleFaultReplyMsg simpleFault) {
				String msg ="Fault returned from CountryRetrievalCRP2X1Http: " + simpleFault.getFaultInfo().getFaultMessageText(); 
				CAFLogger.logSevere(msg, "CountryRetrievalAccessor", "getCountries");
				throw simpleFault;

			} catch (Exception e) {
				String msg = "Exception occurred calling CountryRetrievalCRP2X1Http: " + e;
				CAFLogger.logSevere(msg, "CountryRetrievalAccessor", "getCountries");
				e.printStackTrace();
				throw e;

			}

			return countries;

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

			GregorianCalendar gcal = new GregorianCalendar();
			XMLGregorianCalendar asOfDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			return asOfDate;

		}

		
		/**
		 * <pre>
		 * domainObjectFromProviderReply
		 * May 7, 2015
		 * 
		 * This method will map the ICC provider reply GetCountryListReply to
		 * list of Country CAF domain objects.
		 * 
		 * @param GetCountryListReply
		 * @return a list of Country domain objects
		 * 
		 * </pre>
		 */

		private ArrayList<Country> domainObjectFromProviderReply(GetCountryListReply reply) {

			ArrayList<Country> countries = new ArrayList<Country>();
	//		HashMap <String ,String> countryMap = new HashMap<String,String>();
			List<Country> countryList = reply.getCountry();
			
			for (Country countryData:countryList){
				Country country = new Country();
				country.setCountryCode(countryData.getCountryCode());
				country.setCountryName(countryData.getCountryName());
			
				
				countries.add(country);
			}

			CAFLogger.logInfo("Domain object built from CRP10X1 response",  "CountryRetrievalAccessor", "domainObjectFromProviderReply");

			return countries;

		}



}
