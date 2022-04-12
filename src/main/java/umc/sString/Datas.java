package umc.sString;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Datas {
 
	public static void main(String[] args) {
 
			Calendar c = Calendar.getInstance();
			c.set(1988, Calendar.DECEMBER, 28);
			Date dd = ((Date) c.getTime());
			
			//Formata��o de datas
	//		DateFormat df = DateFormat.getDateTimeInstance();
	//		System.out.println(df.format(dd));
	
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.format(dd);
	
			//Internacionaliza��o de datas
			Calendar c2 = Calendar.getInstance();
			c2.set(1988, Calendar.DECEMBER, 28); 
			//Date data1 = c2.getTime();
			DateFormat data2 = DateFormat.getDateInstance(DateFormat.FULL);
			System.out.println(data2.format(data2));
			//LOcale brasil = Locale.getDefault();
			//Locale padrao = new Locale();
			
			
	}

}
