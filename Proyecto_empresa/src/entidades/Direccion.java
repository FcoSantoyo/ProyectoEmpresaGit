
package entidades;

public class Direccion {
	int codigo_direccion;
	String nombre_via;
	int numero_via;
	int cod_postal;

	
	
	
	//Constructores
	public Direccion (int codigo_direccion,String nombre_via,int numero_via,int cod_postal) {
	this.setCodigo_direccion(codigo_direccion);
	this.setNombre_via(nombre_via);
	this.setNumero_via(numero_via);
	this.setCod_postal(cod_postal);
	}


	//getters y setters

	public int getCodigo_direccion() {
		return codigo_direccion;
	}




	public void setCodigo_direccion(int codigo_direccion) {
		this.codigo_direccion = codigo_direccion;
	}




	public String getNombre_via() {
		return nombre_via;
	}




	public void setNombre_via(String nombre_via) {
		this.nombre_via = nombre_via;
	}




	public int getNumero_via() {
		return numero_via;
	}




	public void setNumero_via(int numero_via) {
		this.numero_via = numero_via;
	}




	public int getCod_postal() {
		return cod_postal;
	}




	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}

	
	//Metodos
	@Override
	public String toString() {
		return "Direccion [codigo_direccion=" + codigo_direccion + ", nombre_via=" + nombre_via + ", numero_via="
				+ numero_via + ", cod_postal=" + cod_postal + "]";
	}
	
	
	
	

	
}
