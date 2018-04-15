package com.chubb.dgmk.caf.controller.svlt;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author P62240B
 *	Register the CAFResourceImpl as a JAX-RS receiver
 */
public class CAFJaxRsApplication extends Application {
	
	public CAFJaxRsApplication() {
		
	}

	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(CAFResourceImpl.class);
        return classes;
	}
}
