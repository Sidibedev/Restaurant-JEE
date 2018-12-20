package com.lng.test;

import java.util.List;

import com.lng.beans.Menu;
import com.lng.model.MenuModel;
import com.lng.model.UtilisateurModel;


public class test {
	public static void main(String[] args){
		MenuModel metier = new MenuModel();
		/*Menu m = new Menu("riz", "tiep", 1000f, "tiep aka mo nekh");
		metier.addMenu(m);
		System.out.println("Menu ajouter avec succes");*/
		System.out.println("**************Liste des Menus***********");
		List<Menu> menus = metier.findAll();
		for(Menu m1:menus)
		{
			System.out.println(m1.getPlat());
			System.out.println(m1.getTypePlat());
			System.out.println(m1.getPrix());
			System.out.println(m1.getDesc());
		}
		UtilisateurModel user = new UtilisateurModel();
		boolean resul = user.check("tafzer", "tafzer");
		if(resul )
			System.out.println("Bienvenue");
		else
			System.out.println("Utilsateur Introuvable");
	}
	
	
}
