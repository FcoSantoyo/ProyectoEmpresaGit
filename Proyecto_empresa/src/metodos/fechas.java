package metodos;

import java.util.GregorianCalendar;

public class fechas {
	public static GregorianCalendar convierteStringFecha (String fecha) {
		
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = Integer.parseInt(fecha.substring(3, 5));	
		int año = Integer.parseInt(fecha.substring(6, 10))-1900;
		GregorianCalendar fechap = new GregorianCalendar(año, mes, dia);
	return fechap;
}
}
