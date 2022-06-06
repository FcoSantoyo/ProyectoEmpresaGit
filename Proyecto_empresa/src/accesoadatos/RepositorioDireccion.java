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
		
		Direccion a = null;
		
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("SELECT * from direccion_java where cod_direccion= '"+codigo+"'");
			
			while(rs.next()) {
				a= new Direccion(rs.getInt("cod_direccion"),rs.getString("nombre_via"),rs.getInt("num_via"),rs.getInt("cod_postal"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	
	
	//Devuelve todas las direcciones
	public static ArrayList<Direccion> listarDirecciones(){
		
		ArrayList<Direccion> listado = new ArrayList<Direccion>();
		Direccion a = null;
		
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("SELECT * from direccion_java");
			
			while(rs.next()) {
				a= new Direccion(rs.getInt("cod_direccion"),rs.getString("nombre_via"),rs.getInt("num_via"),rs.getInt("cod_postal"));
				listado.add(a);
	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listado;
	}
	//Crea una direccion nueva
	public void crearDireccion(int codigo_direccion, String nombre_via, int num_via, int cod_postal){
		
		try {
			ps = conexion.prepareStatement("INSERT INTO direccion_java VALUES(?,?,?,?)");
			ps.setInt(1, codigo_direccion);
			ps.setString(2, nombre_via);
			ps.setInt(3, num_via);
			ps.setInt(4, cod_postal);
			
			
			int resultado = ps.executeUpdate();
			if(resultado>0) {
				JOptionPane.showMessageDialog(null, "Direccion creada correctamente");
			}else{
				JOptionPane.showMessageDialog(null, "ERROR,No se pudo crear, falta algun dato");
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void modificarDireccion(int codigo_direccion, String nombre_via, int num_via, int cod_postal){
		
		try {
				ps = conexion.prepareStatement("UPDATE direccion_java set nombre_via=?, num_via=?, cod_postal=? where cod_direccion=?");
				
				ps.setString(1, nombre_via);
				ps.setInt(2, num_via);
				ps.setInt(3, cod_postal);
				ps.setInt(4, codigo_direccion);
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Direccion actualizada.");
				}else{
					JOptionPane.showMessageDialog(null, "ERROR,No se pudo actualizar la direccion.");
				}
			
			
			conexion.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error :"+ex);
		}
	}
		//Borra una direccion por su codigo
		public void borrarDireccion(int codigo_direccion){
			
			try {
				ps = conexion.prepareStatement("DELETE FROM direccion_java where cod_direccion=?");
				ps.setInt(1, codigo_direccion);
				
				int resultado = ps.executeUpdate();
				
				if(resultado>0) {
					JOptionPane.showMessageDialog(null, "Direccion eliminada.");
				}else{
					JOptionPane.showMessageDialog(null, "ERROR,No se pudo eliminar");
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Error :"+ex);
			}
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
