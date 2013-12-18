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
	  String query = "SELECT student.password FROM student WHERE student.sname=?";
	  java.sql.PreparedStatement ps = con.prepareStatement(query);
	  ps.setString(1, userName);
	  rspsw=ps.executeQuery();
	  	 
	  if(rspsw.getString(3)==password)
	  iden=true;
	  return iden;
}
}
