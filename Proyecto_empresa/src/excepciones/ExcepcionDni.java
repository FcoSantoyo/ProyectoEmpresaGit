package excepciones;

public class ExcepcionDni extends Exception {

	/**
	 * Devuelve una string de error
	 */
	public ExcepcionDni() {
		super ("Error,DNI inválido");
	}
}
