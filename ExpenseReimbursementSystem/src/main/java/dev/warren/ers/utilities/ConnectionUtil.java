package dev.warren.ers.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection createConnection() {
		try {
			Properties props = new Properties();
<<<<<<< HEAD
			Class.forName("org.mariadb.jdbc.Driver");
=======
>>>>>>> 994bbc83711c1881e1a21b750edbce6082f4e972
			FileInputStream in = new FileInputStream("src/main/resources/connection.properties"); 
			props.load(in);
			String details = props.getProperty("connexion");
			Connection conn = DriverManager.getConnection(details);
			return conn;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;

<<<<<<< HEAD
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
=======
>>>>>>> 994bbc83711c1881e1a21b750edbce6082f4e972
		}

	}

}