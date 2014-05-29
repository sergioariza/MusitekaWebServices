package webServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WS_Login {
	public int login(String email, String password) throws SQLException{
		int resultado = 0;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
		Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/musitekamysql","sariza69", "1234");
		PreparedStatement sentencia = conn.prepareStatement("select * from Usuarios where email = '" + email + "' and password = '" + password +"'");
		ResultSet rs = sentencia.executeQuery();
		if(rs.next()){
			resultado = 1;
		}
		return resultado;		
	}
}