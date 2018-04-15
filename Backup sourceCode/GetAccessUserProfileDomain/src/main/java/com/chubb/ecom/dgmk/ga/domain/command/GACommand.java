package com.chubb.ecom.dgmk.ga.domain.command;

import com.chubb.ecom.dgmk.ga.exception.GAUserProfileAuthenticationException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileFieldFormatException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackSuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileRollbackUnsuccessfulException;
import com.chubb.ecom.dgmk.ga.exception.GAUserProfileSystemException;

public interface GACommand {

	/**
	 * Execute method.
	 *
	 * @throws GAUserProfileSystemException the gA user profile system exception
	 * @throws GAUserProfileAuthenticationException the gA user profile authentication exception
	 * @throws GAUserProfileFieldFormatException the gA user profile field format exception
	 */
	public void execute() throws GAUserProfileSystemException, GAUserProfileAuthenticationException, GAUserProfileFieldFormatException;

	/**
	 * Undo method.
	 *
	 * @param errorMsg the original error msg
	 * @throws GAUserProfileRollbackSuccessfulException the gA user profile rollback successful exception
	 * @throws GAUserProfileRollbackUnsuccessfulException the gA user profile rollback unsuccessful exception
	 */
	public void undo(String errorMsg) throws GAUserProfileRollbackSuccessfulException, GAUserProfileRollbackUnsuccessfulException;
}
