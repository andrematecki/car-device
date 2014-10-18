package br.com.fiap.am.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static final String DATE_PTBR = "dd/MM/yyyy";

	private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String TAG = "DataUtil";

	public static String now(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT, Locale.getDefault());
        Date date = c.getTime();
        return dateFormat.format(date);
	}

	public static String format(Calendar c){
		SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT, Locale.getDefault());
        Date date = c.getTime();
        return dateFormat.format(date);
	}


	public static String format(Calendar c, String format){

		SimpleDateFormat dateFormat = new SimpleDateFormat(format, new Locale("pt", "BR"));
        Date date = c.getTime();
        return dateFormat.format(date);
	}

	public static Calendar getCalendar(String date){
		if(date != null && !date.equals("")){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(FORMAT, Locale.getDefault());
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(date));
				return c;
			} catch (ParseException e) {
				System.out.print(e.getMessage());
			}
		}

		return null;
	}

	public static Calendar getCalendar(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static void add(Calendar date, int days){
		date.add(Calendar.DAY_OF_MONTH, days);
	}

}
