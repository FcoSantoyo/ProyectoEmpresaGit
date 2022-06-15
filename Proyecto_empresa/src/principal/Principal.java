package principal;
import java.text.ParseException;
import java.util.Collections;

import accesoadatos.RepositorioVendedor;
import comparadores.ComparadorOFicinamasNomina;
import excepciones.ExcepcionDni;
import gui.CentrarVentana;
import gui.VentanaPrincipal;



public class Principal {

	public static void main(String[] args) throws ParseException, ExcepcionDni {
		// TODO Auto-generated method stub
		
		//Conexion a la base de datos
		accesoadatos.Conexion.conectarse();
		
		System.out.println(accesoadatos.RepositorioVendedor.listarVendedores());
		//Abrir ventana principal
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.setVisible(true);
		CentrarVentana.centrar(vp);
		
		//compaarar vendedores por oficina
		
		Collections.sort(RepositorioVendedor.listarVendedores(),new ComparadorOFicinamasNomina());
	}

}
