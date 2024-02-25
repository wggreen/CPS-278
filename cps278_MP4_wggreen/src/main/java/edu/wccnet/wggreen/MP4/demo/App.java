package edu.wccnet.wggreen.MP4.demo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";

		String user = "root";
		String pass = "Skipper!0";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!!!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
