package leo.webproject.servlet.logAndChoose;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLControl {
	DBConInterf dbconinterf;
	Connection con;
	 java.sql.PreparedStatement ps;
	 ResultSet rs;	  
	
	public ResultSet select(String sql,String para) throws SQLException{
		dbconinterf=new DBCon();
		  try {
			con=dbconinterf.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	      String couNumQuery = sql;
	      ps=con.prepareStatement(couNumQuery);
		  ps.setString(1, para);
	      rs=ps.executeQuery();
		  return rs;		
	}

}
