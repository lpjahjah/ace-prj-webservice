package com.ace.exames.webservice.exceptions;

import javax.xml.ws.WebFault;

import com.ace.exames.core.exceptions.RequiredFieldsException;

@WebFault(name="RequiredFieldsFault")
public class SoapRequiredFieldsException extends RequiredFieldsException {
	private static final long serialVersionUID = 1L;

	public SoapRequiredFieldsException(RequiredFieldsException exception) {
		super(exception.getMessage());
	}
}