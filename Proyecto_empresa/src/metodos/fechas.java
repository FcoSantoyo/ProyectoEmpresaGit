package metodos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class fechas {
	/**
	 * Método que convierte una fecha en tipo String a un gregorian calendar.
	 * @String fecha
	 * @return GregorianCalendar
	 */
	public static GregorianCalendar convierteStringFecha (String fecha) {
		
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = Integer.parseInt(fecha.substring(3, 5));	
		int año = Integer.parseInt(fecha.substring(6, 10));
		GregorianCalendar fechap = new GregorianCalendar(año, mes, dia);
	return fechap;
}

	public static String convierteGregorianAstring( GregorianCalendar g)
	    {
	       
	        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");
	 
	        String fechaformada= formato.format(g.getTime());
	 
	        
	        return fechaformada;
	    }
	
	/**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date convierteStringDate(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = new Date();
        fechaDate.setTime(06062022);
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
