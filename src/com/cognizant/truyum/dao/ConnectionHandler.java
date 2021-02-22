package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("F:\\truyum_Divahar-main\\src\\connection.properties"));

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/truyum_data", prop);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return con;
	}

}
