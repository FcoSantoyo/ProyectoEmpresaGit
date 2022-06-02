package accesoadatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import entidades.Direccion;
import entidades.Oficina;
import entidades.Programador;

public class RepositorioProgramador {
	Connection conexion = Conexion.conectarse();
	static Statement st=null;
	
public static ArrayList<Programador> selectCliente(Direccion direccion,Oficina oficina,ArrayList<String> tecnologias){
		
		ArrayList<Programador> listado = new ArrayList<Programador>();
		String dni;
		String nombre;
		String ap1;
		String ap2;
		Date fecha_nac;
		Date fecha_alta; 
		Programador a = null;
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM CLIENTEPROG");
			
			while (rs.next()) {
				dni = rs.getString("DNI");
				nombre = rs.getString("NOMBRE");
				ap1 = rs.getString("APELLIDO1");
				ap2 = rs.getString("APELLIDO2");
				fecha_nac = rs.getDate();
				direccion =
				fecha_alta =
				oficina =
				tecnologias =
				
				a = new Programador(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina,tecnologias);
				listado.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listado;
	}
	
}
