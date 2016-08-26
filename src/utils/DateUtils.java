/**
 * @description 
 * @date 2016-8-21
 * @author hxg	
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getFormatDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
}
