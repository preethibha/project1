package com.chubb.dgmk.caf.domain.resource;

import java.util.Comparator;

public class BranchResource {

	private String branchName;
	private String branchCode;
	

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Comparator for BranchResource (branch) list to sort by branch name
	 */
	public static final Comparator<BranchResource> BranchComparator = new Comparator<BranchResource>(){

		@Override
		public int compare(BranchResource object1, BranchResource object2) {
			return object1.getBranchName().compareTo(object2.getBranchName());
		}

	};
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Branch Name: " + this.getBranchName());
		sb.append("Branch Code: " + this.getBranchCode());
		
		return sb.toString();
	}
}
