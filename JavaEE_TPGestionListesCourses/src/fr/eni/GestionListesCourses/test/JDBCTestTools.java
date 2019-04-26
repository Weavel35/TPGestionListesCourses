package fr.eni.GestionListesCourses.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.GestionListesCourses.dal.Settings;

public class JDBCTestTools {
	
	private static String urldb;// = "jdbc:sqlserver://localhost:1433;databaseName=PAPETERIE_DB";
	private static String userdb;// = "sa";
	private static String passworddb;// = "Pa$$w0rd";
	private static String driverName;// = "Pa$$w0rd";

	private static Settings settings;
	
	private JDBCTestTools() {
	}
	
	private static void initializeSettings() {
		if(settings == null)
			settings = new Settings();
		
		urldb 		= settings.getProperty("db.url");
		userdb 		= settings.getProperty("db.user");
		passworddb 	= settings.getProperty("db.password");
		driverName 	= settings.getProperty("db.driver");
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver( driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if(urldb == null) {
			initializeSettings();
		}
		return DriverManager.getConnection(urldb, userdb, passworddb);
	}
}
