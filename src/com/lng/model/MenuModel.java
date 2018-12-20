package com.lng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lng.beans.Menu;

public class MenuModel {
	public static List<Menu> listeMenu = new ArrayList<Menu>();
	
	public int AjouterMenu(String plat, String typeplat, float prix, String desc) throws Exception {
		int i = 0;
		Connection conn = ModelDAO.getConnection();
		try {
			String sql = "INSERT INTO menus(plat,typeplat,prix,description) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, plat);
			ps.setString(2, typeplat);
			ps.setFloat(3, prix);
			ps.setString(4, desc);
		    ps.executeUpdate();
		    i=1;
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} 
	}
	public List<Menu> findAll() {
		List<Menu> menus =new ArrayList<Menu>();
		Connection conn = ModelDAO.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from menus");
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				Menu m = new Menu();
				m.setPlat(rs.getString("plat"));
				m.setTypePlat(rs.getString("typeplat"));
				m.setPrix(rs.getFloat("prix"));
				m.setDesc(rs.getString("description"));
				menus.add(m);
			}
			ps.close();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}
}
