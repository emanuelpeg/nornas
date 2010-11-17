/**
 * 
 */
package org.assembly.norna.common.type.exceptions.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebFault;
import javax.xml.ws.soap.SOAPFaultException;

/**
 * @author emanuel
 * 
 *         Class that represents a Exception when a user was saved with data of
 *         other user saved.
 * 
 */
@WebFault(name = "DuplicateDataUsersException", targetNamespace = "assembly.norna.NornasException.org")
public class DuplicateDataUsersException extends SOAPFaultException implements
		Serializable {

	private static final long serialVersionUID = 5385710969521153872L;

	private static final String DEFAULT_MESSAGE = "Can not save user data that are being used by another user";

	private List<String> datasDuplicated = new ArrayList<String>();

	public List<String> getDatasDuplicated() {
		return datasDuplicated;
	}

	public DuplicateDataUsersException(List<String> datasDuplicated)
			throws SOAPException {
		super(SOAPFactory.newInstance().createFault(
				DuplicateDataUsersException.DEFAULT_MESSAGE,
				new QName("http://assembly.norna.org/faultcode", "Server")));
		this.datasDuplicated = datasDuplicated;
	}

	public DuplicateDataUsersException(List<String> datasDuplicated,
			Throwable cause) throws SOAPException {
		super(SOAPFactory.newInstance().createFault(
				DuplicateDataUsersException.DEFAULT_MESSAGE,
				new QName("http://assembly.norna.org/faultcode", "Server")));
		this.datasDuplicated = datasDuplicated;
	}

	@Override
	public String toString() {
		return DuplicateDataUsersException.DEFAULT_MESSAGE;
	}

}
