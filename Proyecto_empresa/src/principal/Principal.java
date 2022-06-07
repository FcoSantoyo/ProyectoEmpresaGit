package principal;



import java.text.ParseException;
import java.util.Date;

import accesoadatos.Conexion;
import entidades.Direccion;
import entidades.Oficina;
import entidades.Vendedor;
import excepciones.ExcepcionDni;



public class Principal {

	public static void main(String[] args) throws ParseException, ExcepcionDni {
		// TODO Auto-generated method stub
		
		Conexion.conectarse();

		System.out.println(accesoadatos.RepositorioVendedor.listarVendedores());
	}

}
