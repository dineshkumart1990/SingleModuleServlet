package trng.imcs.utl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeUtil {
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.util.Date convertToUtilDate(String stringDate){
		Date utilDate = null;
		try {
		    utilDate = df.parse(stringDate);
		    return utilDate;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return utilDate;
	}
	
	public static java.sql.Date convertToSqlDate(Date utilDate){
		 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		 return sqlDate; 
	}
}
