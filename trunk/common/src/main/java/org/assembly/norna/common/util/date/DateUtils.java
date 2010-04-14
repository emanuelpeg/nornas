/**
 * 
 */
package org.assembly.norna.common.util.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author emanuel
 * 
 *  Utils of Date
 *  
 */
public class DateUtils {

	public static Calendar createCalendar(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	
	public static Date createDate(int year, int month, int day) {
		return createCalendar(year, month, day).getTime();
	}
	
}
