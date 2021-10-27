package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	static Connexion instance;
	private Connection cnx ;
	
	private Connexion()
	{
		try {
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
			System.out.println("yeees");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public Connection getConne()
	{
		return cnx;
	}
	public static Connexion getInstance()
	{
		if(instance == null)
		{
			instance = new Connexion();
		}
			return instance;
		
	}

}
