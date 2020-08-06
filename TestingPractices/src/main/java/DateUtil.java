import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public int compareWithToday(Date date){
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        return date.compareTo(today.getTime());
    }
}
