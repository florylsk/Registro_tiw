package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class registroDAO{
	
	public static int createRegistro(Registro registro) {
		int status=0;
		try {
			Connection con=connectionDB.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into records(username,firstname,lastname,fecha_inicio,fecha_salida) values(?,?,?,?,?)");
			ps.setString(1, registro.getUsername());
			ps.setString(2, registro.getFirstname());
			ps.setString(3, registro.getLastname());
			ps.setString(4, registro.getStartTime());  
			ps.setString(5, registro.getEndTime());  
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Registro> getAllRegistros(){
		List<Registro> registros= new ArrayList<Registro>();
		try {
			Connection con= connectionDB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from records");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Registro r = new Registro(rs.getString("username"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("fecha_inicio"),rs.getString("fecha_salida")); 
				registros.add(r);
			}
			con.close();
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		
		return registros;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}