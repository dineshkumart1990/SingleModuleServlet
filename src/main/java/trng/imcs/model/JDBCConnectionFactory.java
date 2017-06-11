package trng.imcs.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionFactory {

	Properties credentialProps = null;
	Connection conn;
	

	public Connection createConnection() throws IOException {
		Properties credentialsProps = null;
		credentialsProps = new Properties();
		ClassLoader classLoader = getClass().getClassLoader();
		
		java.io.InputStream stream = classLoader.getResourceAsStream("credentials.properties");
		if (stream == null) {
			System.out.println("connection");
		}

		credentialsProps.load(stream);
		
		String url = credentialsProps.getProperty("connectionUrl");
		String user = credentialsProps.getProperty("userName");
		String password = credentialsProps.getProperty("password");
		
		Connection conn = null;
		//boolean connStatus = false;
		
		
		try {
			Class.forName(credentialsProps.getProperty("driver.name"));
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;

	}
}