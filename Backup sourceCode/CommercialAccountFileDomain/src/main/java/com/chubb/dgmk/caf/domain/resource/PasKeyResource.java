package com.chubb.dgmk.caf.domain.resource;

import com.chubb.dgmk.caf.util.ICAFConstants;

public class PasKeyResource {
	
	
	
	
	public String pasNumber;
	public String pasSubNumber;
	
	public String getPasSubNumber() {
		return pasSubNumber;
	}
	public void setPasSubNumber(String pasSubNumber) {
		this.pasSubNumber = pasSubNumber;
	}
	public String getPasNumber() {
		return pasNumber;
	}
	public void setPasNumber(String pasNumber) {
		this.pasNumber = pasNumber;
	}
	public PasKeyResource(){
		super();
	}
	public PasKeyResource(String concatenatedProducerNumber){
		this.setPasNumber(concatenatedProducerNumber.substring(0, ICAFConstants.PRODUCER_NUMBER_END_LENGTH));
		this.setPasSubNumber(concatenatedProducerNumber.substring(ICAFConstants.PRODUCER_NUMBER_END_LENGTH,ICAFConstants.PRODUCER_KEY_MAX_LENGTH));

	}
	
	public PasKeyResource(String producerNumber, String producerSubNumber){
		this.setPasNumber(producerNumber);
		this.setPasSubNumber(producerSubNumber);
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Pas Number: " + this.getPasNumber());
		sb.append(" Pas SubNumber: " + this.getPasSubNumber());
		
		return sb.toString();
	}

}