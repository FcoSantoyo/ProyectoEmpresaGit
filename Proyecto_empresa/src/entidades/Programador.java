package entidades;

import java.util.ArrayList;

import excepciones.ExcepcionDni;
import metodos.fechas;



public class Programador extends Empleado {
	ArrayList<String> tecnologias;

	//Constructor
	/**
	 * Crea un objeto de tipo Programador
	 * @String dni
	 * @String nombre
	 * @String ap1
	 * @String ap2
	 * @String fecha_nac
	 * @Direccion direccion
	 * @String fecha_alta
	 * @Oficina oficina
	 * @ArrayList tecnologias
	 * @throws ExcepcionDni
	 */
	public Programador(String dni,String nombre,String ap1,String ap2,String fecha_nac, Direccion direccion,String fecha_alta, Oficina oficina,ArrayList<String> tecnologias) throws ExcepcionDni {
		super(dni,nombre,ap1,ap2,fecha_nac,direccion,fecha_alta,oficina);
		this.setTecnologias(tecnologias);
	}

		//Metodos
		@Override
		public int compareTo(Persona o) {
			// TODO Auto-generated method stub
			return 0;
		}
		/**
		 * Devuelve la nomina de un programador dándole un mes,multiplicando ese mes por el número de tecnologías que domina
		 * @int mes
		 * @return
		 */
		public double nominaf(int mes)
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
		return "[" + dni + "]";
		}

	//Getters y setters
	public ArrayList<String> getTecnologias() {
		return tecnologias;
		
}

	public void setTecnologias(ArrayList<String> tecnologias) {
		this.tecnologias = tecnologias;
	}	
}
