/**
 * 
 */
package org.assembly.nornas.sandbox.exception;

import javax.xml.ws.WebFault;

import org.assembly.norna.common.type.exceptions.NornasException;

/**
 * @author emanuel
 *
 */
@WebFault(name = "SampleException", targetNamespace="org.assembly.norna.NornasException")
public class SampleException extends NornasException {


	private String data;
	
	private static final long serialVersionUID = -4501803536508342941L;

	public SampleException(String data) {
		super();
		this.data = data;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
