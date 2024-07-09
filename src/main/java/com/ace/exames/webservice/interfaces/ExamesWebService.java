package com.ace.exames.webservice.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ace.exames.core.enums.ExameStatusEnum;
import com.ace.exames.core.models.Exame;
import com.ace.exames.webservice.exceptions.SoapExameDeletionException;
import com.ace.exames.webservice.exceptions.SoapRequiredFieldsException;


@WebService
public interface ExamesWebService {
	@WebMethod
	List<Exame> getExames(int page, int size);
	
	@WebMethod
	List<Exame> getAllExamesAtivosOrderedByName();

	@WebMethod
	List<Exame> searchExames(Integer codigo, String nome, ExameStatusEnum status, int page, int size);

	@WebMethod
	Exame getExame(Integer id);
	
	@WebMethod
	void createExame(Exame exame) throws SoapRequiredFieldsException;
	
	@WebMethod
	void updateExame(Exame exame) throws SoapRequiredFieldsException;
	
	@WebMethod
	void deleteExame(Integer id) throws SoapExameDeletionException;
}