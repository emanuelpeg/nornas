package org.assembly.nornas.sandbox.model;

import javax.jws.soap.SOAPBinding;

@SOAPBinding
public class Message {
	private String message;

	public Message() {
	}

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}