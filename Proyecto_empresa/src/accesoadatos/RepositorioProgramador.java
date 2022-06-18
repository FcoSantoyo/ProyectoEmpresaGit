package accesoadatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import entidades.Direccion;
import entidades.Oficina;
import entidades.Programador;
import excepciones.ExcepcionDni;

public class RepositorioProgramador {
	Connection conexion = Conexion.conectarse();
	static Statement st=null;
	
	//Devuelve una array de vendedores
public static ArrayList<Programador> listarProgramadores() throws ExcepcionDni {
		
		ArrayList<Programador> lista = new ArrayList<Programador>();
		String dni;
		String nombre;
		String ap1;
		String ap2;
		String fecha_nac;
		Direccion direccion;
		String fecha_alta;
		Oficina oficina;
		ArrayList<String> tecnologia = new ArrayList<String>();
		String [] tecno;
		Programador programador = null;
		
		
		try {
			st = accesoadatos.Conexion.conectarse().createStatement();
			ResultSet rs = st.executeQuery("select p.dni, p.nombre, p.ap1, p.ap2, p.fecha_nac, p.direccion, e.fecha_alta, e.oficina, pr.tecnologias from persona_java p join empleado_java2 e on p.dni=e.dni join programador_java pr on e.dni=pr.dni");
			
			while (rs.next()) {
				dni = rs.getString("DNI");
				nombre = rs.getString("NOMBRE");
				ap1 = rs.getString("AP1");
				ap2 = rs.getString("AP2");
				fecha_nac = metodos.fechas.convierteDateString(rs.getDate("fecha_nac"));
				direccion = accesoadatos.RepositorioDireccion.listarDireccion(rs.getInt("DIRECCION"));
				fecha_alta = metodos.fechas.convierteDateString(rs.getDate("fecha_alta"));
				oficina = accesoadatos.RepositorioOficina.listarOficina(rs.getInt("OFICINA"));
				tecno = rs.getString("tecnologias").split("/");
				for (int i = 0; i < tecno.length; i++)
			        tecnologia.add(tecno[i]);
				programador=new Programador(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina,tecnologia);
				
				lista.add(programador);
			}
			st.executeQuery("commit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
//Listar un vendedor por su dni
public static Programador listarProgramador(String dni) throws ExcepcionDni {

	String nombre;
	String ap1;
	String ap2;
	String fecha_nac;
	Direccion direccion;
	String fecha_alta;
	Oficina oficina;
	Programador programador = null;
	String [] tecno;
	ArrayList<String> tecnologia = new ArrayList<String>();
	


	try {
		st = accesoadatos.Conexion.conectarse().createStatement();
		ResultSet rs = st.executeQuery("select p.dni, p.nombre, p.ap1, p.ap2, p.fecha_nac, p.direccion, e.oficina, pr.tecnologias from persona_java p join empleado_java2 e on p.dni=e.dni join programador_java pr on e.dni=pr.dni where p.dni like upper ('"+dni+"')");

		while (rs.next()) {
			dni = rs.getString("DNI");
			nombre = rs.getString("NOMBRE");
			ap1 = rs.getString("AP1");
			ap2 = rs.getString("AP2");
			fecha_nac = metodos.fechas.convierteDateString(rs.getDate("fecha_nac"));
			direccion = accesoadatos.RepositorioDireccion.listarDireccion(rs.getInt("DIRECCION"));
			fecha_alta = metodos.fechas.convierteDateString(rs.getDate("fecha_alta"));
			oficina = accesoadatos.RepositorioOficina.listarOficina(rs.getInt("OFICINA"));
			tecno = rs.getString("tecnologias").split("/");
			for (int i = 0; i < tecno.length; i++)
		        tecnologia.add(tecno[i]);
			programador=new Programador(dni,nombre,ap1, ap2,fecha_nac,direccion,fecha_alta,oficina,tecnologia);

		}
		st.executeQuery("commit");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return programador;
}
//Borra un vendedor con ese dni
public static void borrarProgramador(String dni) throws SQLException {
	st = accesoadatos.Conexion.conectarse().createStatement();
	st.executeQuery("delete from programador_java where dni like '"+dni+"'");
	st.executeQuery("delete from empleado_java2 where dni like '"+dni+"'");
	st.executeQuery("delete from persona_java where dni like '"+dni+"'");
	st.executeQuery("commit");
	
	
}
	
//Crear un empleado
public static void creaProgramador(Programador p) {
	
	try {
		st = accesoadatos.Conexion.conectarse().createStatement();
		st.executeQuery("insert into persona_java values (upper('"+p.getDni()+"'), upper('"+p.getNombre()+"'), upper('"+p.getAp1()+"'), upper('"+p.getAp2()+"'),('"+p.getFecha_nac()+"'),upper('"+p.getDireccion().getCodigo_direccion()+"'))");
		st.executeQuery("insert into empleado_java2 values (upper('"+p.getDni()+"'), ('"+p.getFecha_alta()+"'), "+p.getOficina().getCodigo()+")");
		st.executeQuery("insert into programador_java values (upper('"+p.getDni()+"'), upper('"+p.getTecnologias()+"'))");
		st.executeQuery("commit");
		
		  JOptionPane.showMessageDialog(null, "Se ha creado el Programador.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error :" + e);
		}
}
public static void modificarProgramador(Programador p) {
	
	try {
		st = accesoadatos.Conexion.conectarse().createStatement();
		st.executeQuery("update programador_java set zona="+p.getTecnologias()+"'");
		st.executeQuery("update empleado_java2 set fecha_alta="+p.getFecha_alta()+", oficina="+p.getOficina().getCodigo()+" where dni like '"+p.getDni()+"'");
		st.executeQuery("update persona_java set nombre="+p.getNombre()+", ap1=upper('"+p.getAp1()+"'),upper('"+p.getFecha_nac()+"'),upper('"+p.getDireccion().getCodigo_direccion()+"') where dni like '"+p.getDni()+"'");
		st.executeQuery("commit");

		  JOptionPane.showMessageDialog(null, "Se ha modificado el Programador.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error :" + e);
		}
}
	
}
