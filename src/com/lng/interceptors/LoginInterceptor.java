package com.lng.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	//si la session est nulle ou l'authentification n'est pas effectuer
	//la chaine de caractere allowAccess est retourner 
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		
		if(session.get("allowAccess") == null){
			return "allowAccess";
		}else{
			if(!session.isEmpty()){
				return arg0.invoke();
			}else{
				return "allowAccess";
			}
		}
		
	}

}
