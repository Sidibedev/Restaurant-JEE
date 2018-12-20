package com.lng.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lng.model.UtilisateurModel;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private String username = "";
	private String password= "";
	UtilisateurModel utilisateurModel = null;
	boolean resultat = false;
	private Map<String, Object> session = null;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
	public String authentifier(){
		utilisateurModel = new UtilisateurModel();
		resultat = utilisateurModel.check(username, password);
		if(resultat == true){
			this.session = getSession();
			session.put("allowAccess", "true");
			return SUCCESS;
		}
		addFieldError("username", getText("app.login.echec"));
		return INPUT;
	}
	public Map<String, Object> getSession() {
		return session==null?new HashMap<String , Object>():session;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String deconnecter(){
		this.session.clear();
		return SUCCESS;
	}
	

}
