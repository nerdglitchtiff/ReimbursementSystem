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
//		Properties props = new Properties();
//		FileInputStream in = new FileInputStream("src/main/resources/connection.properties"); 
//		props.load(in);
		//props.getProperty()
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String details = "jdbc:mariadb://tiffdb.cgils6w1buvq.us-east-2.rds.amazonaws.com:3306/ReimbReqSys?user=tiff&password=flaming0";
			Connection conn = DriverManager.getConnection(details);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

}
