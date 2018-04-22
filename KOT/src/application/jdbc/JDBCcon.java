package application.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;


public class JDBCcon { 
	public static Connection connect = null;

	public static void connectToDB() throws Exception {
		try {
					// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Setup the connection with the DB
			connect= DriverManager.getConnection("jdbc:mysql://Localhost:3306/KOT?useSSL=true","root","tp607");

		} catch (Exception e) {
			throw e;
		}
	}
	
}
