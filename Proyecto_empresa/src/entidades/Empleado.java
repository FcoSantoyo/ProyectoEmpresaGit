package entidades;

import java.util.GregorianCalendar;


abstract class Empleado extends Persona {
	private GregorianCalendar fecha_alta;
	private Oficina oficina;
	
	
	//Constructores
	public Empleado(String dni,String nombre,String ap1,String ap2,GregorianCalendar fecha_nac, Direccion direccion,GregorianCalendar fecha_alta, Oficina oficina) {
		super(dni,nombre,ap1,ap2,fecha_nac,direccion);
		this.setFecha_alta(fecha_alta);
		this.setOficina(oficina);
	}

	
	
	
	//Getters y Setters
	public GregorianCalendar getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(GregorianCalendar fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	//Metodos
	public int antiguedad()
	{
		int antiguedad;
		
		GregorianCalendar fecha_actual = new GregorianCalendar();
		
		antiguedad = fecha_actual.YEAR - this.fecha_alta.YEAR;
		return antiguedad;
	}
	
	
	public  double nomina() {
		double sueldo;
		
		sueldo = 500 + 25 * (antiguedad());
		
		return sueldo;
	}
		
	
	
	@Override
	public String toString() {
		return "Empleado [fecha_alta=" + fecha_alta + ", oficina=" + oficina + "]";
	}
	
	
	
	
	
	}


