package task4;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 1.06.2017.
 */
public class Birthday {

    private final static int N = 1000 * 60 * 60 * 24;

    /**
     * Method return the different between date and current date in days.
     * @param date
     * @return
     */
    public static long getAgeInDays(Date date) {
        Date currentDate = new Date();
        long tempResult = (currentDate.getTime() - date.getTime());

        long result = tempResult / N;
        result += tempResult % N == 0 ? 0 : 1;
        return result;

    }

    /**
     * Method return the difference between date and current date in month.
     * @param date
     * @return
     */
    public static long getAgeInMonth(Date date){
        Date currentDate=new Date();
        int yearDiff=currentDate.getYear()-date.getYear();
        int monthDiff=currentDate.getMonth()-date.getMonth();
        return 12*yearDiff+monthDiff;
    }

    /**
     * Method return the name of day.
     * @param date
     * @return
     */

    public static String getTheDayOfWeek(Date date){

      return new SimpleDateFormat("EEEE").format(date);
    }
}
