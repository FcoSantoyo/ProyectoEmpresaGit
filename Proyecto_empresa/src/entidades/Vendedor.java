package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Vendedor extends Empleado {
	String zona;
	
	//Constructores
	public Vendedor(String dni,String nombre,String ap1,String ap2,GregorianCalendar fecha_nac, Direccion direccion,GregorianCalendar fecha_alta, Oficina oficina,ArrayList<String> tecnologias) {
		super(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina);
		this.setZona(zona);	
	}
		
		
	//Metodos
	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String toString() {
		return "Vendedor [zona=" + zona + "]";
	}


	@Override
	public boolean nomina() {
		// TODO Auto-generated method stub
		return false;
	}
		
	//Getters y setters
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
}