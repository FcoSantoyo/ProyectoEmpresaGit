package metodos;

import java.util.GregorianCalendar;

public class fechas {
	public static GregorianCalendar convierteStringFecha (String fech) {
		
		int dia = Integer.parseInt(fech.substring(0, 2));
		int mes = Integer.parseInt(fech.substring(3, 5));	
		int año = Integer.parseInt(fech.substring(6, 10))-1900;
		GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
	return fecha;
}
}
