
package entidades;

public class Oficina {
	int codigo;
	String nombre;
	Direccion direccion;
	
	
	//Constructores
	public Oficina (int codigo, String nombre, Direccion direccion) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setDireccion(direccion);
	}
	
	
	//Getters y setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Código=" + codigo + ", Nombre=" + nombre + ", Direccion=" + direccion + "";
	}
	
	
	
	
}
