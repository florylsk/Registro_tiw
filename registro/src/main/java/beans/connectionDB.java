package beans;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class connectionDB{
	
	public static Connection getConnection() {
	
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("TIWDS");
			con = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	
	
	}
	
	
	
	
	
}