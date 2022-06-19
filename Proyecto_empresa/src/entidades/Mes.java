package entidades;

import java.util.ArrayList;

public class Mes {
	String nombre;
	int posicion;
	
	
	
	public Mes (String nombre, int posicion) {
		this.setNombre(nombre);
		this.setPosicion(posicion);
	}



	
	
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getPosicion() {
		return posicion;
	}



	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}






	@Override
	public String toString() {
		return "" + nombre + "";
	}
	
	
	
	public static ArrayList<Mes> losMeses() {
		ArrayList<Mes> m = new ArrayList<Mes>();
		
		
		String enero= "Enero";
		int posicion = 1;
		Mes e = new Mes(enero,posicion);
		
		String Febrero= "Febrero";
		int posicion2 = 2;
		Mes f = new Mes(Febrero,posicion2);
		
		String Marzo= "Marzo";
		int posicion3 = 3;
		Mes mar = new Mes(Marzo,posicion3);
		
		String Abril= "Abril";
		int posicion4 = 4;
		Mes a = new Mes(Abril,posicion4);
		
		String Mayo = "Mayo";
		int posicion5 = 5;
		Mes ma = new Mes(Mayo,posicion5);
		
		
		String Junio= "Junio";
		int posicion6 = 6;
		Mes j = new Mes(Junio,posicion6);
		
		String Julio= "Julio";
		int posicion7 = 7;
		Mes jl = new Mes(Julio,posicion7);
		
		String Agosto= "Agosto";
		int posicion8 = 8;
		Mes ag = new Mes(Agosto,posicion8);
		
		String Septiembre= "Septiembre";
		int posicion9 = 9;
		Mes s = new Mes(Septiembre,posicion9);
		
		String Octubre= "Octubre";
		int posicion10 = 10;
		Mes o = new Mes(Octubre,posicion10);
		
		String Noviembre= "Noviembre";
		int posicion11 = 11;
		Mes n = new Mes(Noviembre,posicion11);
		
		String Diciembre= "Diciembre";
		int posicion12 = 12;
		Mes d = new Mes(Diciembre,posicion12);
		
		
		m.add(e);
		m.add(f);
		m.add(mar);
		m.add(a);
		m.add(ma);
		m.add(j);
		m.add(jl);
		m.add(ag);
		m.add(s);
		m.add(o);
		m.add(n);
		m.add(d);
		
		
		return m;
	}
	
	
}

