//package com.ace.exames.webservice.validators;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
//import com.ace.exames.core.exceptions.LoginException;
//import com.ace.exames.core.interfaces.AuthenticationService;
//import com.sun.xml.wss.impl.callback.PasswordValidationCallback;
//
//public class ServerPasswordValidator implements PasswordValidationCallback.PasswordValidator {
//	
//	private AuthenticationService authService;
//	
//	public ServerPasswordValidator() {
//		try {
//			Context ctx = new InitialContext();
//			authService = (AuthenticationService) ctx.lookup("ejb:\"\"/core-0.0.1-SNAPSHOT/\"\"/AuthenticationService!com.ace.exames.core.interfaces.AuthenticationService");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//    public boolean validate(PasswordValidationCallback.Request request) {
//        PasswordValidationCallback.PlainTextPasswordRequest plainTextRequest = 
//            (PasswordValidationCallback.PlainTextPasswordRequest) request;
//        String username = plainTextRequest.getUsername();
//        String password = plainTextRequest.getPassword();
//        
//        boolean response = true;
//
//        try {
//			authService.login(username, password);
//		} catch (LoginException e) {
//			response = false;
//		}
//       
//        return response;
//    }
//}
