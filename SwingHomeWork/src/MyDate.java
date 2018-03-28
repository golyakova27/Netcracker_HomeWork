import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate extends GregorianCalendar {

    MyDate() {
        super();
    }

    MyDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    public String dateToString() {
        if (this.get(Calendar.DAY_OF_MONTH) < 10) {

            if (this.get(Calendar.MONTH) + 1 < 10) {
                return "0" + this.get(Calendar.DAY_OF_MONTH) + "." +
                        "0" + (this.get(Calendar.MONTH) + 1) + "." + this.get(Calendar.YEAR);
            }
            else {
                return "0" + this.get(Calendar.DAY_OF_MONTH) + "." +
                        (this.get(Calendar.MONTH) + 1) + "." + this.get(Calendar.YEAR);
            }
        }
        else {
            if (this.get(Calendar.MONTH) + 1 < 10) {
                return this.get(Calendar.DAY_OF_MONTH) + "." +
                        "0" + (this.get(Calendar.MONTH) + 1) + "." + this.get(Calendar.YEAR);
            }
            else {
                return this.get(Calendar.DAY_OF_MONTH) + "." +
                        (this.get(Calendar.MONTH) + 1) + "." + this.get(Calendar.YEAR);
            }
        }
    }
}
