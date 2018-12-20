package com.lng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lng.beans.Menu;


public class UtilisateurModel {
	

	
	public boolean check(String Username, String password){
		Menu m = null;
		Connection conn = ModelDAO.getConnection(); 
		try {
				PreparedStatement ps = conn.prepareStatement("select * from utilisateurs where username=? and password = ?");
				ps.setString(1, Username);
				ps.setString(2, password);
				ResultSet rs =ps.executeQuery();
				if(rs.next())
				{
					return true;
				}
				ps.close();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;
		
	}
}
