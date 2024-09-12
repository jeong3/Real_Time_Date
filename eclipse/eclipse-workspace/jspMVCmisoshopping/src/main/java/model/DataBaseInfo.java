package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseInfo {
	
		String jdbcURL;
		String jdbcDriver;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		String sql;
		
		public DataBaseInfo() {
			jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
			jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		}
		public Connection getConnection() {
			Connection co = null;
			try {
				Class.forName(jdbcDriver);
				co = DriverManager.getConnection(jdbcURL,"miso","1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return co;
		}

		
		public void close() {
			if(rs!=null)try {rs.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
			if(con!=null)try {con.close();} catch (Exception e) {e.printStackTrace();}
		}
}
