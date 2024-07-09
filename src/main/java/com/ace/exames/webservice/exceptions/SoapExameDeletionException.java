package com.ace.exames.webservice.exceptions;

import javax.xml.ws.WebFault;

import com.ace.exames.core.exceptions.ExameDeletionException;

@WebFault(name="ExameDeletionFault")
public class SoapExameDeletionException extends ExameDeletionException {
	private static final long serialVersionUID = 1L;

	public SoapExameDeletionException(ExameDeletionException exception) {
		super(exception.getMessage());
	}
	
}