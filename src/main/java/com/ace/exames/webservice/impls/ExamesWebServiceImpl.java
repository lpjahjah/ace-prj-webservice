package com.ace.exames.webservice.impls;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ace.exames.core.enums.ExameStatusEnum;
import com.ace.exames.core.exceptions.ExameDeletionException;
import com.ace.exames.core.exceptions.RequiredFieldsException;
import com.ace.exames.core.interfaces.ExamesService;
import com.ace.exames.core.models.Exame;
import com.ace.exames.webservice.exceptions.SoapExameDeletionException;
import com.ace.exames.webservice.exceptions.SoapRequiredFieldsException;
import com.ace.exames.webservice.interfaces.ExamesWebService;


@WebService
public class ExamesWebServiceImpl implements ExamesWebService {
	
	private ExamesService examesService;
	
	public ExamesWebServiceImpl() {
		try {
			Context ctx = new InitialContext();
	        examesService = (ExamesService) ctx.lookup("ejb:\"\"/core-0.0.1-SNAPSHOT/\"\"/ExamesService!com.ace.exames.core.interfaces.ExamesService");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	@WebMethod
	public List<Exame> getExames(int page, int size) {
		return examesService.getExames(page, size);
	}

	@Override
	@WebMethod
	public List<Exame> getAllExamesAtivosOrderedByName() {
		return examesService.getAllExamesAtivosOrderedByName();
	}

	@Override
	@WebMethod
	public List<Exame> searchExames(Integer codigo, String nome, ExameStatusEnum status, int page, int size) {
		return examesService.searchExames(codigo, nome, status, page, size);
	}

	@Override
	@WebMethod
	public Exame getExame(Integer id) {
		return examesService.getExame(id);
	}

	@Override
	@WebMethod
	public void createExame(Exame exame) throws SoapRequiredFieldsException {
		
		try {
			examesService.createExame(exame);
		} catch (RequiredFieldsException e) {
			e.printStackTrace();
			throw new SoapRequiredFieldsException(e);
		}
		
	}

	@Override
	@WebMethod
	public void updateExame(Exame exame) throws SoapRequiredFieldsException {
		try {
			examesService.updateExame(exame);
		} catch (RequiredFieldsException e) {
			e.printStackTrace();
			throw new SoapRequiredFieldsException(e);
		}	
	}

	@Override
	@WebMethod
	public void deleteExame(Integer id) throws SoapExameDeletionException {
		try {
			examesService.deleteExame(id);
		} catch (ExameDeletionException e) {
			e.printStackTrace();
			throw new SoapExameDeletionException(e);
		}
	}
	
}