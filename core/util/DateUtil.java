package com.doer.mraims.core.util;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Component("dateUtil")
public class DateUtil {

	@Synchronized
	public String formatDateToString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			log.error("An exception occured while format date : ", e);
			return null;
		}
	}
	
	@Synchronized
	public Date parseStringToDate(String strDate, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(strDate);
		} catch (Exception e) {
			log.error("An exception occured while parse date : ", e);
			return null;
		}
	}
	
	@Synchronized
	public static String staticFormatDateToString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	public String getMonthOfYear() {
		String monthStartDate = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		int month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10) {
			monthStartDate = (calendar.get(Calendar.YEAR) + 1900) + "-0" + month;
		} else {
			monthStartDate = (calendar.get(Calendar.YEAR) + 1900) + "-" + month;
		}

		return monthStartDate;
	}

	public String getStringDateFromDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			String dateStr = simpleDateFormat.format(date);
			return dateStr;
		} catch (Exception e) {
			return null;
		}
	}

	public String getStringDateFromDateMMDDHHMMSS(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");

		try {
			String dateStr = simpleDateFormat.format(date);
			return dateStr;
		} catch (Exception e) {
			return null;
		}
	}

	public static synchronized String getStringDateFromDateYYYYMMDDHHMMSS(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		try {
			String dateStr = simpleDateFormat.format(date);
			return dateStr;
		} catch (Exception e) {
			return null;
		}
	}
	
	

	public static String getStringDateFromDateYYYYMMDD(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		try {
			String dateStr = simpleDateFormat.format(date);
			return dateStr;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getStringDateFromDateYYYYMMDDDashed(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			String dateStr = simpleDateFormat.format(date);
			return dateStr;
		} catch (Exception e) {
			return null;
		}
	}

	public String getStringDateFromDateYYYY(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

		try {
			String dateStr = simpleDateFormat.format(date);
			return dateStr;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getStringDateFromDateYYYYMMDDTZ(String strDate) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(strDate, inputFormatter);
		

		try {
			String formattedDate = outputFormatter.format(date);
			return formattedDate;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDateStrFromYYMMDDHHmm(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmm");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy, hh:mm a");
        try {
            Date date = formatter.parse(dateStr);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	    return null;
	}
	
	// format 24hre ex. 12:12 , 17:15
    private  String  HOUR_FORMAT = "HH:mm";

    public  String getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfHour = new SimpleDateFormat(HOUR_FORMAT);
        String hour = sdfHour.format(cal.getTime());
        return hour;
    }

    /**
     * @param  target  hour to check
     * @param  start   interval start
     * @param  end     interval end
     * @return true    true if the given hour is between
     */
    public  boolean isHourInInterval(String target, String start, String end) {
        return ((target.compareTo(start) >= 0)
                && (target.compareTo(end) <= 0));
    }

    /**
     * @param  start   interval start
     * @param  end     interval end
     * @return true    true if the current hour is between
     */
    public  boolean isNowInInterval(String start, String end) {
        return isHourInInterval
            (getCurrentHour(), start, end);
    }

}
