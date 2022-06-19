package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import excepciones.ExcepcionDni;


public abstract class Empleado extends Persona {
	public String fecha_alta;
	public Oficina oficina;
	
	/**
	 * Constructor para crear un objeto de tipo Empleado.
	 * @String dni
	 * @String nombre
	 * @String ap1
	 * @String ap2
	 * @GregorianCalendar fecha_nac
	 * @Direccion direccion
	 * @GregorianCalendar fecha_alta
	 * @Oficina oficina
	 * @throws ExcepcionDni
	 */
	//Constructores
	public Empleado(String dni,String nombre,String ap1,String ap2,String fecha_nac,Direccion direccion,String fecha_alta, Oficina oficina) throws ExcepcionDni {
		super(dni,nombre,ap1,ap2,fecha_nac,direccion);
		this.setFecha_alta(fecha_alta);
		this.setOficina(oficina);
	}

	
	
	
	//Getters y Setters
	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	/**
	 * Calcula la antiguedad de un empleado (restando el año actual menos el que se dio de alta) devolviendo un tipo int
	 * @return int
	 */
	public int antiguedad() {
        int antiguedad;

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);

        try {
            Date dateFechaALta = formato.parse(fecha_alta);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar calFechaALta = Calendar.getInstance();
        int calFechaa = calFechaALta.get(Calendar.YEAR); 

        antiguedad = año - calFechaa;

        return antiguedad;

    }

	
	/**
	 * Calcula una nomina de un trabajador multiplicada por la antiguedad.
	 * @return Double
	 */
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


