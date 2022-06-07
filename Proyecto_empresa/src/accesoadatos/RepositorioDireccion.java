package accesoadatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidades.Direccion;


public class RepositorioDireccion {

	static Connection conexion = Conexion.conectarse();
	static Statement st=null;
	static PreparedStatement ps=null;
	
	//Devuelve una direccion por su codigo
	public static Direccion listarDireccion(int codigo){
		int codigo_direccion;
		String nombre_via;
		int numero_via;
		int cod_postal;
		Direccion a = null;
		
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("SELECT * from direccion_java where cod_direccion= '"+codigo+"'");

			while(rs.next()) {
				codigo_direccion =rs.getInt("cod_direccion");
				nombre_via = rs.getString("nombre_via");
				numero_via = rs.getInt("num_via");
				cod_postal = rs.getInt("cod_postal");
				a= new Direccion(codigo_direccion,nombre_via,numero_via,cod_postal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	
	//Devuelve todas las direcciones
	public static ArrayList<Direccion> listarDirecciones(){
		
		ArrayList<Direccion> listado = new ArrayList<Direccion>();
		int codigo_direccion;
		String nombre_via;
		int numero_via;
		int cod_postal;
		Direccion a = null;
		
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("SELECT * from direccion_java");
			
			while(rs.next()) {
				codigo_direccion =rs.getInt("cod_direccion");
				nombre_via = rs.getString("nombre_via");
				numero_via = rs.getInt("num_via");
				cod_postal = rs.getInt("cod_postal");
				a= new Direccion(codigo_direccion,nombre_via,numero_via,cod_postal);
				listado.add(a);
	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listado;
	}
	//Crea una direccion nueva
	public static void crearDireccion(Direccion d){
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("insert into direccion_java values ('"+d.getCodigo_direccion()+"',upper('"+d.getNombre_via()+"'),'"+d.getNumero_via()+"','"+d.getCod_postal()+"')");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void modificarDireccion(Direccion d){
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("update direccion_java set nombre_via='"+d.getNombre_via()+"',num_via='"+d.getNumero_via()+"',cod_postal='"+d.getCod_postal()+"' where cod_direccion like '"+d.getCodigo_direccion()+"'");
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		//Borra una direccion por su codigo
		public void borrarDireccion(int codigo_direccion) throws SQLException{
			
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("delete from direccion_java where cod_direccion like '"+codigo_direccion+"'");
			st.executeQuery("commit");
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
