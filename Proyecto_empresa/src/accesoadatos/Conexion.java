package accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	Statement st;
	ResultSet rs;
	
	public static Connection conectarse(){
		 Connection conex = null;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conex = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","fran","despertador5");
    } catch (SQLException | ClassNotFoundException ex) {
        System.out.println("No se ha podido conectar...");
    }
    return conex;
	}
}
