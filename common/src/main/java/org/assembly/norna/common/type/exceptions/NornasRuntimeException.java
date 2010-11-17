/**
 * 
 */
package org.assembly.norna.common.type.exceptions;

/**
 * @author emanuel
 *
 *	Generic Class, it represents a RuntimeException in Nornas
 *
 */
public class NornasRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -5714483265255762138L;
	
	public NornasRuntimeException() {	
		super();
	}
	
	public NornasRuntimeException(String message) {	
		super(message);
	}
	
	public NornasRuntimeException(String message, Throwable cause) {	
		super(message,cause);
	}

}
