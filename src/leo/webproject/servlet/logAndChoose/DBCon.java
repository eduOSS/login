package leo.webproject.servlet.logAndChoose;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

import javax.servlet.http.HttpServlet;

public class DBCon implements DBConInterf{

	private String url;
	private String user;
	private String passwd;
	public DBCon(){
		url="jdbc:mysql://localhost:3306/test";//The url is of this syntax: jdbc:subprotocol:subname
		user="root";
		passwd="123456";
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url,user,passwd);

	}
	
	public void closeConnection(Connection conn) throws SQLException{
		conn.close();
		
	}
	
	
}
