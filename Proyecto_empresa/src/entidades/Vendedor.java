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


	public double nomina (int mes)
	{
		double nomina=0;
		if (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) 
		{
		nomina= super.nomina()+6*31;	
		}
		else if (mes==4 || mes==6 || mes==9 || mes==11 )
		{
			nomina= super.nomina()+6*30;
		}
		else if (mes==2)
		{
			nomina= super.nomina()+6*28;
		}
		
		return nomina;
	}
		
	//Getters y setters
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
}