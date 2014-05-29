package webServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD

public class WS_Navegacion {
	public String listadoItems(int nivel, int idProducto) throws SQLException{
		String resultado = "";
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
		Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/musitekamysql","sariza69", "1234");
		PreparedStatement sentencia;
		
		switch(nivel){
			case 2:
				String strInt2 = String.valueOf(idProducto);
				sentencia = conn.prepareStatement("select * from Productos where idproducto = '" + strInt2 + "'" );
				break;
			case 1:
				String strInt1 = String.valueOf(idProducto);
				sentencia = conn.prepareStatement("select * from Subclasesproductos where idclaseproducto = '" + strInt1 + "'" );
				break;
			case 0:
			default:
				sentencia = conn.prepareStatement("select * from Clasesproductos");
				break;
		}
		
		ResultSet rs = sentencia.executeQuery();
		
		while(rs.next()){
			switch(nivel){
				case 2:
					resultado = resultado + rs.getString("MARCA") + " " + rs.getString("MODELO") + ";";
					break;
				case 1:
					resultado = resultado + rs.getString("DESCSUBCLASEPRODUCTO") + ";";
					break;
				case 0:
				default:				
					resultado = resultado + rs.getString("DESCCLASEPRODUCTO") + ";";
					break;
			}			
		}
		
		return resultado;
	}
	
	public String obtenerClase(int idClase) throws SQLException{
		String resultado = "";
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
		Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/musitekamysql","sariza69", "javamysql");
		PreparedStatement sentencia = conn.prepareStatement("select * from Clasesproductos where idclaseproducto = '" + idClase + "'" );
		
		ResultSet rs = sentencia.executeQuery();
		resultado = resultado + rs.getString("LINK") + ";";
		
		return resultado;
	}
	
	public String links(int idClase) throws SQLException{
		String resultado = "";
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
		Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/musitekamysql","sariza69", "javamysql");
		PreparedStatement sentencia = conn.prepareStatement("select * from Clasesproductos where idclaseproducto = '" + idClase + "'" );
		
		ResultSet rs = sentencia.executeQuery();
		resultado = resultado + rs.getString("LINK") + ";";
		
		return resultado;
	}
=======
import java.util.ArrayList;

public class WS_Navegacion {
    public Item[] listadoItems(int nivel, int idProducto) throws SQLException {
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/musitekamysql",
			"sariza69", "1234");
	PreparedStatement sentencia;

	switch (nivel) {
	case 2:
	    String strInt2 = String.valueOf(idProducto);
	    sentencia = conn.prepareStatement("select * from Productos where idproducto = '"
			    + strInt2 + "'");
	    break;
	case 1:
	    String strInt1 = String.valueOf(idProducto);
	    sentencia = conn.prepareStatement("select scp.IDSUBCLASEPRODUCTO, scp.DESCSUBCLASEPRODUCTO, cp.LINK AS LINKCLASEPRODUCTO, scp.LINK AS LINKSUBCLASEPRODUCTO from musitekamysql.clasesproductos AS cp, musitekamysql.subclasesproductos AS scp where cp.IDCLASEPRODUCTO = scp.IDCLASEPRODUCTO and cp.IDCLASEPRODUCTO = '"
			    + strInt1 + "'");
	    break;
	case 0:
	default:
	    sentencia = conn.prepareStatement("select * from Clasesproductos");
	    break;
	}

	ArrayList<Item> listaItems = new ArrayList<Item>();
	ResultSet rs = sentencia.executeQuery();
	Item itemAux;

	while (rs.next()) {
	    switch (nivel) {
	    case 2:
		itemAux = new Item();
		itemAux.setIdItem(rs.getInt("IDPRODUCTO"));
		itemAux.setDescItem(rs.getString("MARCA") + " " + rs.getString("MODELO"));
		itemAux.setLinkUrlImagen("http://musitekaweb.musiteka.cloudbees.net/Imagenes/Productos/"
			+ itemAux.getIdItem() + ".png");
		break;
	    case 1:
		itemAux = new Item();
		itemAux.setIdItem(rs.getInt("IDSUBCLASEPRODUCTO"));
		itemAux.setDescItem(rs.getString("DESCSUBCLASEPRODUCTO"));
		itemAux.setLinkUrlImagen("http://musitekaweb.musiteka.cloudbees.net/Imagenes/Subproductos/"
			+ rs.getString("LINKCLASEPRODUCTO") + "/"
			+ rs.getString("LINKSUBCLASEPRODUCTO") + ".jpg");
		break;
	    case 0:
	    default:
		itemAux = new Item();
		itemAux.setIdItem(rs.getInt("IDCLASEPRODUCTO"));
		itemAux.setDescItem(rs.getString("DESCCLASEPRODUCTO"));
		itemAux.setLinkUrlImagen("http://musitekaweb.musiteka.cloudbees.net/Imagenes/ClasesProductos/"
			+ rs.getString("LINK") + ".jpg");
		break;
	    }

	    listaItems.add(itemAux);
	}

	int longitud = listaItems.size();
	Item arrayItems[] = new Item[longitud];
	listaItems.toArray(arrayItems);

	return arrayItems;
    }
>>>>>>> 9119b6589a795322e004e6cd2092f2cbd389289d
}
