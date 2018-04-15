package com.chubb.dgmk.caf.domain.resource;
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.List;

import javax.naming.Context;  
import javax.naming.InitialContext;  
import javax.naming.NamingException;  
  
import com.chubb.dgmk.caf.domain.manager.AccountFileDomainManager;
import com.chubb.dgmk.caf.logger.CAFLogger;
import com.ibm.websphere.cache.EntryInfo;  
import com.ibm.websphere.cache.DistributedMap;  
  
import java.io.ObjectStreamException;  
import java.io.Serializable;  
  
  
public final class CountryDataCache implements Serializable {  
  
  
   
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

static String  jndiName ="cache/country_cache";  
   
/** 
21.  * private variable holds Distributed map of Dynamic cache 
22.  */  
private DistributedMap dynaCache = null;  
   
/** 
26.  * static EntitlementCache instance variable 
27.  */  
 private static CountryDataCache dynamicCache = new CountryDataCache(jndiName);  
 
  
 private CountryDataCache(){  
  super();  
}    
   
 private CountryDataCache(String jndiName) {  
  initializeDynamicCache(jndiName);  
}  
  
   
 public void initializeDynamicCache(String jndiName){  
  
  try {  
   Context context = new InitialContext();  
   dynaCache = (DistributedMap)context.lookup(jndiName);  
     
  } catch (NamingException e) {  
   e.printStackTrace();  
 }  
 }  
    
  public static CountryDataCache getInstanceForDynaCache(){  
   if(dynamicCache==null){  
    dynamicCache=new CountryDataCache(jndiName);  
    return dynamicCache;  
      
   }else{  
    return dynamicCache;  
   }  
     
  }  
   
   
  /** 
   * putInDynamicCache is used put cached objects into Distributed Map 
   */  
 public synchronized void putInDynamicCache(String key, int timeToLive) {  
	 try {
     	CAFLogger.logInfo("Refreshing Cache ", "CountryDataCache", "putInDynamicCache" );
        
        AccountFileDomainManager mgr = new AccountFileDomainManager();
 		ResourceRequestResult result = mgr.retrieveCountryList();
 		HashMap <String,String> countryNameMap = new HashMap <String,String> ();
 		if(result!=null && result.getCountryList()!=null)
 		{
 			List<CountryResource> countryDataList = result.getCountryList();
 			for (CountryResource country : countryDataList)
 			{
 				if (country !=null && country.getCountryCode()!=null && country.getCountryName()!=null)
 					countryNameMap.put(country.getCountryCode(), country.getCountryName());
 			}
 			dynaCache.put(key, countryNameMap,1,timeToLive*60,EntryInfo.NOT_SHARED,null); 
 		}
     } catch (Exception e) {
     	CAFLogger.logSevere("Exception getting country name " + e.getMessage(), "AccounFileDomainManager", "uiResourceFromAccountList" ); 
     }
     CAFLogger.logInfo("Cache Refreshed", "CountryDataCache", "putInDynamicCache" );
      
         
  }  
    
  /** 
  * getFromDynamicCache is used return the CachedObject for the application  
  */  
  public HashMap <String,String> getFromDynamicCache(String key) {  
  HashMap <String,String> keyValue = null;  
   if(dynaCache != null && dynaCache.containsKey(key)) {  
    keyValue = (HashMap<String, String>) dynaCache.get(key);  
   }  
   return keyValue;  
 }  
    
  /** 
  * removeFromDynamicCache is used remove the CachedObject for the application  
  */  
 public void removeFromDynamicCache(String key) {  
   if(dynaCache != null && dynaCache.containsKey(key)) {  
    dynaCache.remove(key);  
   }  
     
  }  
   
  
}  
