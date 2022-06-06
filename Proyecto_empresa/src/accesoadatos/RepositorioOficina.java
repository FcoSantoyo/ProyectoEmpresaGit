package accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.Direccion;
import entidades.Oficina;

public class RepositorioOficina {
	Connection conexion = Conexion.conectarse();
	static Statement st=null;
	PreparedStatement ps=null;
	

	//Devuelve una array de oficinas	
	public static ArrayList<Oficina> listarOficinas() {

		ArrayList<Oficina> lista = new ArrayList<Oficina>();
		int codigo;
		String nombre;
		Direccion direccion;
		Oficina a = null;
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("select * from oficina_java2");

			while (rs.next()) {
				codigo = rs.getInt("CODIGO");
				nombre = rs.getString("NOMBRE");
				direccion = accesoadatos.RepositorioDireccion.listarDireccion(rs.getInt("DIRECCION"));

				a=new Oficina(codigo,nombre,direccion);

				lista.add(a);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	//Devuelve una oficina por su codigo
	public static Oficina listarOficina(int codigo) {


		String nombre;
		Direccion direccion;
		Oficina a = null;

		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("select * from oficina_java2 where cod like '"+codigo+"'");

			while (rs.next()) {
				codigo = rs.getInt("CODIGO");
				nombre = rs.getString("NOMBRE");
				direccion = accesoadatos.RepositorioDireccion.listarDireccion(rs.getInt("DIRECCION"));

				a=new Oficina(codigo,nombre,direccion);


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	//Borra una oficina por su codigo
	public static void borraOficina(int codigo) throws SQLException {
		st = accesoadatos.Conexion.conectarse().createStatement();
		ResultSet rs = st.executeQuery("delete from oficina_java2 where cod like '"+codigo+"'");
		st.executeQuery("commit");
}

	//Crea una oficina
public static void creaOficina(Oficina a) {
		
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("insert into oficina_java2 values ('"+a.getCodigo()+"',upper('"+a.getNombre()+"'),upper('"+a.getDireccion()+"'))");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
public static void modificarOficina(Oficina a) {
		
	try {
		st = accesoadatos.Conexion.conectarse().createStatement();
		ResultSet rs = st.executeQuery("update oficina_java2 set nombre='"+a.getNombre()+"', nombreloc='"+a.getDireccion()+"' where cod like '"+a.getCodigo()+"'");
		st.executeQuery("commit");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}
