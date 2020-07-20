package ma.iam.dashboard.csn.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public class DateUtils {

	public static String dateToString(Date date){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date);
	}

	public static String dateToString(Date date, String format){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	public static Date stringToDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(date);
	}

	public static Date stringToDate(String date, String Format) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat(Format);
		return sdf.parse(date);
	}
	
	public static String dateTimeFrTiretToString(Date date){
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		return df.format(date);
	}
	
	public static String dateTimeFileName(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		return df.format(date);
	}
	
	public static Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}
}
