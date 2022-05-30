package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Programador extends Empleado {
	ArrayList<String> tecnologias;

	//Constructor
	public Programador(String dni,String nombre,String ap1,String ap2,GregorianCalendar fecha_nac, Direccion direccion,GregorianCalendar fecha_alta, Oficina oficina,ArrayList<String> tecnologias) {
		super(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina);
		this.setTecnologias(tecnologias);
	}
	
	//Metodos
		@Override
		public int compareTo(Persona o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public boolean nomina() {
			// TODO Auto-generated method stub
			return false;
		}
		

	@Override
		public String toString() {
			return "Programador [tecnologias=" + tecnologias + "]";
		}

	//Getters y setters
	public ArrayList<String> getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(ArrayList<String> tecnologias) {
		this.tecnologias = tecnologias;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
