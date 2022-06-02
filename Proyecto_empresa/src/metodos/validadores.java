package metodos;

public class validadores {
	/**
	 * Método que valida un DNI pasado por parámetro
	 * @param dni
	 * @return
	 */
	public static boolean validaDNI(String dni) {
	
		int miDNI = Integer.parseInt(dni.substring(0,8));
		String letraDNI = dni.substring(8);
		boolean dnivalido=false;
		int resto = 0;
		String miLetra = "";
		String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

		resto = miDNI % 23;

		miLetra = asignacionLetra[resto];
		if (letraDNI.equals(miLetra))
		{
			dnivalido=true;
		}
		return dnivalido;
}
}
