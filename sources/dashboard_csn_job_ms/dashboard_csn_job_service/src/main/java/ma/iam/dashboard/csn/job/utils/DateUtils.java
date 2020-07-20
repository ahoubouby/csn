package ma.iam.dashboard.csn.job.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author H.ELKHATEB & Z.BELGHAOUTI & K.ELBAGUARI
 *
 */
public class DateUtils {

	public static String dateToString(Date date){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date);
	}

	public static Date stringToDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
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
	
	public static Date stringToTime(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(date);
	}
	
	public static String dateExecutionToString(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
		return df.format(date);
	}
}
