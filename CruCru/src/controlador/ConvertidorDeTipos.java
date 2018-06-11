package controlador;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertidorDeTipos {
	public static final String MENSAJE_DE_ERROR_FECHA_INCORRECTA = "Introduce fecha en formato dia-mes-año";
	public static final String MENSAJE_DE_ERROR_HORA_INCORRECTA = "Introduce hora en formato hora:minutos";
	
	public static java.sql.Date stringToDate(String date) throws ParseException {
		java.sql.Date res;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		java.util.Date fechaUtil = sdf.parse(date);
		res = new java.sql.Date(fechaUtil.getTime());
	    return res;
	}
	public static Time stringToHouer(String hora) throws ParseException {
		Time res;
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setLenient(false);
		Date horaDate = (Date) formatter.parse(hora);
		
		res = new Time(horaDate.getTime());
		return res;
	}
}