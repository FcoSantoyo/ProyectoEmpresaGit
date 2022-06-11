package entidades;


import java.util.GregorianCalendar;
import java.util.Objects;

import excepciones.ExcepcionDni;
import metodos.validadores;

public abstract class Persona extends ExcepcionDni implements Comparable<Persona> {
	protected  String dni;
	protected  String nombre;
	protected String ap1;
	protected  String ap2;
	protected GregorianCalendar fecha_nac;
	protected Direccion direccion;
	
	
	/**
	 * Constructor para crear un objeto Persona.
	 * @String dni
	 * @String nombre
	 * @String ap1
	 * @String ap2
	 * @GregorianCalendar fecha_nac
	 * @Direccion direccion
	 * @throws ExcepcionDni
	 */
	//Constructores
	public Persona(String dni,String nombre,String ap1,String ap2,GregorianCalendar fecha_nac, Direccion direccion) throws ExcepcionDni
	{
		this.setDni(dni);
		this.setNombre(nombre);
		this.setAp1(ap1);
		this.setAp2(ap2);
		this.setFecha_nac(fecha_nac);
		this.setDireccion(direccion);
	}
	
	
	//Getters and Setters

	public String getDni() {
		return dni;
	}


	public void setDni(String dni) throws ExcepcionDni {
		if (validadores.validaDNI(dni)==true) {
		this.dni = dni;
	}else {
		throw new ExcepcionDni();
	}
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAp1() {
		return ap1;
	}


	public void setAp1(String ap1) {
		this.ap1 = ap1;
	}


	public String getAp2() {
		return ap2;
	}


	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}
	

	public GregorianCalendar getFecha_nac() {
		return fecha_nac;
	}


	public void setFecha_nac(GregorianCalendar fecha_nac) {
		this.fecha_nac = fecha_nac;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	//Hashcode y Equals
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	public boolean equals(Persona o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Persona other = (Persona) o;
		return Objects.equals(dni, other.dni);
	}

	//Compareto
	public int compareTo(Persona o) {
        Persona persona = (Persona)o;       
        return this.dni.compareTo(persona.dni);
           
}  


	//toString
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", ap1=" + ap1 + ", ap2=" + ap2 + ", fecha_nac="
				+ fecha_nac + ", direccion=" + direccion + "]";
	}
	
	
	
	
	
	
	
	
}
