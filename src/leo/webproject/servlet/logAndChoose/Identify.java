package leo.webproject.servlet.logAndChoose;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Identify {
	public boolean identify(String userName, String password) throws SQLException, ClassNotFoundException{
	boolean iden=false;

	  ResultSet rspsw = null;
	
	  DBConInterf dbconinterf=new DBCon();
	  Connection con=dbconinterf.getConnection();
	  String query = "SELECT password FROM student WHERE sname=?";
	  // HERE SHOLD ADD A IF SENTENSE TO TELL WHETHER QUERY IS NULL 
	  java.sql.PreparedStatement ps = con.prepareStatement(query);
	  ps.setString(1, userName);
	  rspsw=ps.executeQuery();
	  
	  if(rspsw.next()){
	  String pwd=rspsw.getString(1);	
	  if(pwd.equals(password))
			  iden=true;
	  }

	System.out.println(password);
	  
	  return iden;

}
}
