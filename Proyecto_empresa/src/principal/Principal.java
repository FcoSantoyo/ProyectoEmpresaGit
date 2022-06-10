package principal;
import java.text.ParseException;

import excepciones.ExcepcionDni;
import gui.CentrarVentana;
import gui.VentanaPrincipal;



public class Principal {

	public static void main(String[] args) throws ParseException, ExcepcionDni {
		// TODO Auto-generated method stub
		
		//Conexion a la base de datos
		accesoadatos.Conexion.conectarse();
		
		//Abrir ventana principal
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.setVisible(true);
		CentrarVentana.centrar(vp);
		
		
	}

}
