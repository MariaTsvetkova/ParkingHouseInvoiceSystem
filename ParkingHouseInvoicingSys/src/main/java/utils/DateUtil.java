package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static int[] devideDateByHours(Date startDate, Date endDate, int month, int startHour, int endHour) {

		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		if (startCalendar.get(Calendar.MONTH) != month) {
			startCalendar.set(Calendar.HOUR, 0);
			startCalendar.set(Calendar.MINUTE, 0);
			startCalendar.set(Calendar.SECOND, 0);
			startCalendar.set(Calendar.DAY_OF_MONTH, 1);
			startCalendar.set(Calendar.MONTH, month);
		} else if (endCalendar.get(Calendar.MONTH) != month) {
			endCalendar.set(Calendar.HOUR, 0);
			endCalendar.set(Calendar.MINUTE, 0);
			endCalendar.set(Calendar.SECOND, 0);
			endCalendar.set(Calendar.DAY_OF_MONTH, 1);
		}

		int HALF_HOUR_MILLISECONDS = 60 * 60 * 500;
		int first = 0;
		int second = 0;

		for (int i = 0; startCalendar.before(endCalendar); i++) {
			if (startCalendar.get(Calendar.HOUR_OF_DAY) >= startHour
					&& endCalendar.get(Calendar.HOUR_OF_DAY) < endHour) {
				first++;
			} else {
				second++;
			}
			startCalendar.setTimeInMillis(startCalendar.getTimeInMillis() + HALF_HOUR_MILLISECONDS);
		}

		int[] arr = { first, second };
		return arr;
	}

}
