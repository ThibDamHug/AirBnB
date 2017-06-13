package fr.AirBnB.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	protected String url = "jdbc:mysql://localhost/airbnb";
	protected String login = "root";
	protected String pwd = "youpie007";
	protected Connection cn = null;
	protected Statement st = null;
	
	public void seConnecter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			cn = DriverManager.getConnection(url, login, pwd);
			st = cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void seDeconnecter() {
		try {
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
