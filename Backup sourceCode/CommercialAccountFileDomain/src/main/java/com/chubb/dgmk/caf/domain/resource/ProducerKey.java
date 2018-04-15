package com.chubb.dgmk.caf.domain.resource;

import com.chubb.dgmk.caf.util.ICAFConstants;

public class ProducerKey {
	
	public String producerNumber;
	public String producerSubNumber;
	
	public ProducerKey(){
		super();
	}
	public ProducerKey(String concatenatedProducerNumber){
		this.setProducerNumber(concatenatedProducerNumber.substring(0, ICAFConstants.PRODUCER_NUMBER_END_LENGTH));
		this.setProducerSubNumber(concatenatedProducerNumber.substring(ICAFConstants.PRODUCER_NUMBER_END_LENGTH,ICAFConstants.PRODUCER_KEY_MAX_LENGTH));

	}
	
	public ProducerKey(String producerNumber, String producerSubNumber){
		this.setProducerNumber(producerNumber);
		this.setProducerSubNumber(producerSubNumber);
	}
	
	public String getProducerNumber() {
		return producerNumber;
	}
	public void setProducerNumber(String producerNumber) {
		this.producerNumber = producerNumber;
	}
	public String getProducerSubNumber() {
		return producerSubNumber;
	}
	public void setProducerSubNumber(String producerSubNumber) {
		this.producerSubNumber = producerSubNumber;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Producer Number: " + this.getProducerNumber());
		sb.append(" Producer SubNumber: " + this.getProducerSubNumber());
		
		return sb.toString();
	}

}