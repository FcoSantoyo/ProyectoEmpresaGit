package principal;

import accesoadatos.Conexion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conexion.conectarse();
		int codigo=4434;
		System.out.println(accesoadatos.RepositorioDireccion.listarDirecciones());
		accesoadatos.RepositorioDireccion.modificarDireccion(codigo, "albariqcoquw", 2, 23400);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
