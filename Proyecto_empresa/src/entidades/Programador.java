package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import excepciones.ExcepcionDni;



public class Programador extends Empleado {
	ArrayList<String> tecnologias;

	//Constructor
	public Programador(String dni,String nombre,String ap1,String ap2,GregorianCalendar fecha_nac, Direccion direccion,GregorianCalendar fecha_alta, Oficina oficina,ArrayList<String> tecnologias) throws ExcepcionDni {
		super(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina);
		this.setTecnologias(tecnologias);
	}

		//Metodos
		@Override
		public int compareTo(Persona o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public double nomina(int mes)
		{
			double nomina=0;
			double sueldo= super.nomina();
			int numero_tec = tecnologias.size();
			boolean mes30= mes==4 ||mes==6 ||mes==9 ||mes==11;
			boolean mes31=mes==1 ||mes==3 ||mes==5 ||mes==7 ||mes==8 ||mes==10 ||mes==12;
			if(mes30)
			{
				nomina = sueldo + 5 * 30 + 20 * numero_tec;
			}
			else if(mes31)
			{
				nomina= sueldo + 5 * 31 + 20 * numero_tec;
			}
			else
			{
				nomina = sueldo + 5  *28 + 20 * numero_tec;
			}
			return nomina;
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
