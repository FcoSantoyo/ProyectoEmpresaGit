package accesoadatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import entidades.Direccion;
import entidades.Oficina;

import entidades.Vendedor;
import excepciones.ExcepcionDni;

public class RepositorioVendedor {
	Connection conexion = Conexion.conectarse();
	static Statement st=null;
	
	
	/**
	 * Devuelve todos los vendedores de la base de datos en una array
	 * @return arraylist de vendedores
	 * @throws ParseException
	 * @throws ExcepcionDni
	 */
public static ArrayList<Vendedor> listarVendedores() throws ParseException, ExcepcionDni {
		
		ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
		String dni;
		String nombre;
		String ap1;
		String ap2;
		String fecha_nac;
		Direccion direccion;
		String fecha_alta;
		Oficina oficina;
		String zona;
		Vendedor vendedor = null;
		
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("select p.dni, p.nombre, p.ap1, p.ap2, p.fecha_nac, p.direccion,e.fecha_alta, e.oficina, v.zonas from persona_java p join empleado_java2 e on p.dni=e.dni join vendedor_java v on e.dni=v.dni");
			
			while (rs.next()) {
				dni = rs.getString("DNI");
				nombre = rs.getString("NOMBRE");
				ap1 = rs.getString("AP1");
				ap2 = rs.getString("AP2");
				fecha_nac = metodos.fechas.convierteDateString(rs.getDate("fecha_nac"));
				direccion = accesoadatos.RepositorioDireccion.listarDireccion(rs.getInt("DIRECCION"));
				fecha_alta = metodos.fechas.convierteDateString(rs.getDate("fecha_alta"));
				oficina = accesoadatos.RepositorioOficina.listarOficina(rs.getInt("OFICINA"));
				zona = rs.getString("ZONAS");
 
				vendedor=new Vendedor(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina,zona);
				
				lista.add(vendedor);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
/**
 * Devuelve un vendedor por su dni
 * @param dni
 * @return Vendedor
 * @throws ExcepcionDni
 */
public static Vendedor listarVendedor(String dni) throws ExcepcionDni {

	String nombre;
	String ap1;
	String ap2;
	String fecha_nac;
	Direccion direccion;
	String fecha_alta;
	Oficina oficina;
	String zona;
	Vendedor vendedor = null;


	try {
		st = accesoadatos.Conexion.conectarse().createStatement();
		ResultSet rs = st.executeQuery("select p.dni, p.nombre, p.ap1, p.ap2, p.fecha_nac, p.direccion,e.fecha_alta,e.oficina, v.zonas from persona_java p join empleado_java2 e on p.dni=e.dni join vendedor_java v on e.dni=v.dni where p.dni like upper ('"+dni+"')");

		while (rs.next()) {
			dni = rs.getString("DNI");
			nombre = rs.getString("NOMBRE");
			ap1 = rs.getString("AP1");
			ap2 = rs.getString("AP2");
			fecha_nac = metodos.fechas.convierteDateString(rs.getDate("fecha_nac"));
			direccion = accesoadatos.RepositorioDireccion.listarDireccion(rs.getInt("DIRECCION"));
			fecha_alta = metodos.fechas.convierteDateString(rs.getDate("fecha_alta"));
			oficina = accesoadatos.RepositorioOficina.listarOficina(rs.getInt("OFICINA"));
			zona = rs.getString("ZONAS");

			vendedor=new Vendedor(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina,zona);

		}
		st.executeQuery("commit");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return vendedor;
}
/**
 * Borra un vendedor con su dni dado por parametro
 * @param dni
 * @throws SQLException
 */
public static void borrarVendedor(String dni) throws SQLException {
	st = accesoadatos.Conexion.conectarse().createStatement();
	st.executeQuery("delete from vendedor_java where dni like '"+dni+"'");
	st.executeQuery("delete from empleado_java2 where dni like '"+dni+"'");
	st.executeQuery("delete from persona_java where dni like '"+dni+"'");
	st.executeQuery("commit");
	
}
	
/**
 * Inserta un vendedor en la base de datos 
 * @param v
 */
public static void creaVendedor(Vendedor v) {
	
	try {
		st = accesoadatos.Conexion.conectarse().createStatement();
		st.executeQuery("insert into persona_java values (upper('"+v.getDni()+"'), upper('"+v.getNombre()+"'), upper('"+v.getAp1()+"'), upper('"+v.getAp2()+"'),('"+v.getFecha_nac()+"'),upper('"+v.getDireccion().getCodigo_direccion()+"'))");
		st.executeQuery("insert into empleado_java2 values (upper('"+v.getDni()+"'), ('"+v.getFecha_alta()+"'), "+v.getOficina().getCodigo()+")");
		st.executeQuery("insert into vendedor_java values (upper('"+v.getDni()+"'), upper('"+v.getZona()+"'))");
		st.executeQuery("commit");
		
		  JOptionPane.showMessageDialog(null, "Se ha creado el Vendedor.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "Error :" + e);
	}
}
/**
 * Modifica un vendedor
 * @param v
 */
public static void modificarVendedor(Vendedor v) {
	
	try {
		st = accesoadatos.Conexion.conectarse().createStatement();
		st.executeQuery("update vendedor_java set zonas="+v.getZona()+"'");
		st.executeQuery("update empleado_java2 set fecha_alta="+v.getFecha_alta()+", oficina="+v.getOficina().getCodigo()+" where dni like '"+v.getDni()+"'");
		st.executeQuery("update persona_java set nombre="+v.getNombre()+", ap1=upper('"+v.getAp1()+"'),upper('"+v.getFecha_nac()+"'),upper('"+v.getDireccion().getCodigo_direccion()+"') where dni like '"+v.getDni()+"'");
		st.executeQuery("commit");
		
		 JOptionPane.showMessageDialog(null, "Se ha	modificado el Vendedor.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "Error :" + e);
	}
}


}
