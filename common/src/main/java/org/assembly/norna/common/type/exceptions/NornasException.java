/**
 * 
 */
package org.assembly.norna.common.type.exceptions;

/**
 * @author emanuel
 * 
 * Generic Class, it represents a Exception in Nornas
 *
 */
public class NornasException extends Exception {

	private static final long serialVersionUID = -2729285474976604781L;

	public NornasException() {	
		super();
	}
	
	public NornasException(String message) {	
		super(message);
	}
	
	public NornasException(String message, Throwable cause) {	
		super(message,cause);
	}
	
}
