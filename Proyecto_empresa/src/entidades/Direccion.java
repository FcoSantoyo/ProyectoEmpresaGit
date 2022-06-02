
package entidades;

public class Direccion {
	int codigo_calle;
	String tipo_via;
	String nombre_via;
	int numero;
	String localidad;
	String provincia;

	
	
	
	//Constructores
	public Direccion (int codigo_calle,String tipo_via,String nombre_via,int numero,String localidad,String provincia ) {
	this.setCodigo_calle(codigo_calle);
	this.setTipo_via(tipo_via);
	this.setNombre_via(nombre_via);
	this.setNumero(numero);
	this.setLocalidad(localidad);
	this.setProvincia(provincia);
	}
	
	//getters y setters
	
	public int getCodigo_calle() {
		return codigo_calle;
	}

	public void setCodigo_calle(int codigo_calle) {
		this.codigo_calle = codigo_calle;
	}

	public String getTipo_via() {
		return tipo_via;
	}

	public void setTipo_via(String tipo_via) {
		this.tipo_via = tipo_via;
	}

	public String getNombre_via() {
		return nombre_via;
	}

	public void setNombre_via(String nombre_via) {
		this.nombre_via = nombre_via;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	
	//Métodos
	@Override
	public String toString() {
		return "Direccion [codigo_calle=" + codigo_calle + ", tipo_via=" + tipo_via + ", nombre_via=" + nombre_via
				+ ", numero=" + numero + ", localidad=" + localidad + ", provincia=" + provincia + "]";
	}

	
}
