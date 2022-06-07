package principal;



import java.util.GregorianCalendar;

import accesoadatos.Conexion;
import entidades.Direccion;
import entidades.Oficina;
import entidades.Vendedor;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conexion.conectarse();

		
		int codigo_direccion=3344;
		String nombre_via="Albatrence";
		int numero_via=10;
		int cod_postal=23006;
		Direccion a;
		a = new Direccion(codigo_direccion,nombre_via,numero_via,cod_postal);
		
		System.out.println(accesoadatos.RepositorioDireccion.listarDirecciones());
		
		
		
		int codigo=2345;
		String nombrep="MIPERROFRANCES";
		
		Oficina o = null;
		o=new Oficina(codigo,nombrep,a);
		String dni="77370255A";
		//accesoadatos.RepositorioOficina.creaOficina(o);
		System.out.println(accesoadatos.RepositorioOficina.listarOficina(codigo));
		
		System.out.println(accesoadatos.RepositorioVendedor.listarVendedores());
	}

}
