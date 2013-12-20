package leo.webproject.servlet.logAndChoose;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginService {

	HashMap<String, Object> map = new HashMap<String, Object>();
	SQLControl sqlcontrol = new SQLControl();
	ResultSet rs = null;
	String query;

	public void dataSet(int couNum, String userName) throws SQLException {
		ResultSet rs = null;
		String query;
		for (int i = 0; i < couNum; i++) {
			map.put("null", false);
		}

		query = "SELECT cname FROM curri WHERE cID=?";
		rs = sqlcontrol.select(query, "*");	
				
		while(map.get(rs.next()) != null) {
			query = "SELECT curri.cname FROM list,student,curri WHERE ?=student.sname AND student.sNo=list.studentNo AND list.courceID=curri.cID";
			if (sqlcontrol.select(query, userName).next()) {				
			}
			rs.beforeFirst();
		}

	}

	public boolean identify(String userName, String password)
			throws SQLException, ClassNotFoundException {
		boolean iden = false;
		query = "SELECT password FROM student WHERE sname=?";
		rs = sqlcontrol.select(query, userName);
		if (rs.next()) {
			String pwd = rs.getString(1);
			if (pwd.equals(password))
				iden = true;
			query = "SELECT COUNT(list.courceID) FROM list,student WHERE student.sname=? AND student.sNO=list.studentNO";
			rs = sqlcontrol.select(query, userName);
			if (rs.next()) {
				dataSet(rs.getInt(1), userName);
			}
		}
		return iden;
	}
}
