package com.chubb.ecom.dgmk.ga.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PasswordGeneratorTest {

	@Test
	public void testGenerateTempPassword() {
		
		String tempPassword = PasswordGenerator.generateTempPassword();
		
		System.out.println(tempPassword);
		
		assertEquals(8, tempPassword.length());		
	}
	
}
