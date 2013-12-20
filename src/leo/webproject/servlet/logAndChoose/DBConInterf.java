package leo.webproject.servlet.logAndChoose;
import java.sql.Connection;
import java.sql.SQLException;

public interface DBConInterf {
	public Connection getConnection() throws SQLException;
	public void closeConnection(Connection conn) throws SQLException; 
}
