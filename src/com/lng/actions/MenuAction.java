package com.lng.actions;

import java.util.List;

import com.lng.beans.Menu;
import com.lng.model.MenuModel;
import com.opensymphony.xwork2.ActionSupport;


public class MenuAction  extends ActionSupport{
	
	public String typePlat;
	public String plat;
	public Float prix;
	public String desc;
	MenuModel menuModel = null;
	int resultat = 0;
	public List<Menu> listeMenus = null;
	

	
	public String enregistrer(){
		
		menuModel = new MenuModel();
		try
		{
			resultat = menuModel.AjouterMenu(plat, typePlat, prix, desc);
			if(resultat > 0){
				addActionMessage(getText("app.message.ajoutMenu"));
				return "success";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "input";
	}
		/*return "input";
		if(plat.equals("") || prix == null){
			return "input";
		}
		Menu menu = new Menu(typePlat, plat, prix,desc);
		//MenuModel.listeMenu.add(menu);
		menuModel.addMenu(menu);
		addActionMessage(getText("app.message.ajoutMenu"));
		
		
		return "success";
	}*/
	
	public String lister(){
		menuModel = new MenuModel();
		this.listeMenus = menuModel.findAll();
		return "success";
	}
	
	
	
}
