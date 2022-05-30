package entidades;

import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Persona implements Comparable<Persona> {
	protected  String dni;
	protected  String nombre;
	protected String ap1;
	protected  String ap2;
	protected GregorianCalendar fecha_nac;
	protected Direccion direccion;
	
	
	
	//Constructores
	public Persona(String dni,String nombre,String ap1,String ap2,GregorianCalendar fecha_nac, Direccion direccion)
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


	public void setDni(String dni) {
		this.dni = dni;
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}


	//toString
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", ap1=" + ap1 + ", ap2=" + ap2 + ", fecha_nac="
				+ fecha_nac + ", direccion=" + direccion + "]";
	}
	
	
	
	
	
	
	
	
}
