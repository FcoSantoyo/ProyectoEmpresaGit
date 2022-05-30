package entidades;

public class Direccion {
	String calle;
	String numero;
	String localidad;

	
	
	
	//Constructores
	public Direccion (String calle, String numero, String localidad ) {
		this.setCalle(calle);
		this.setNumero(numero);
		this.setLocalidad(localidad);
	}
	
	//getters y setters
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", localidad=" + localidad + "]";
	}
	
	
	
	
	

	
}
