package pagecode.bean;

import java.util.ArrayList;
import java.util.List;

import com.chubb.dgmk.caf.domain.resource.PasKeyResource;
import com.chubb.dgmk.caf.domain.resource.ProducerKey;

/**
 * @author P62240B
 * The CAFBean holds onto userType and all related producers for the logged in user.
 * If the user is not of type 'Agent', the list of related producers will be empty.
 */
public class CAFBean {
	
	public String userType;
	public List<ProducerKey> producerKeys;
	public List<PasKeyResource> pasKeys;
	public String emailAddress;
	public String userId;
	public String userFirstName="";
	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<ProducerKey> getProducerKeys() {
		if (producerKeys == null)
			setProducerKeys(new ArrayList<ProducerKey>());
		return producerKeys;
	}

	public void setProducerKeys(List<ProducerKey> producerKeys) {
		this.producerKeys = producerKeys;
	}
	
	
	public List<PasKeyResource> getPasKeys() {
		if (pasKeys == null)
			setPasKeys(new ArrayList<PasKeyResource>());
		return pasKeys;
	}

	public void setPasKeys(List<PasKeyResource> pasKeys) {
		this.pasKeys = pasKeys;
	}
	public void addPassKey(String producerNumber, String subProducerNumber){
		PasKeyResource key = new PasKeyResource(producerNumber, subProducerNumber);
		getPasKeys().add(key);
	}

	public void addProducerKey(String producerNumber, String subProducerNumber){
		ProducerKey key = new ProducerKey(producerNumber, subProducerNumber);
		getProducerKeys().add(key);
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	

}
