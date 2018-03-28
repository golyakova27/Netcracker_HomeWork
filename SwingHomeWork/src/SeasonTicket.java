import java.util.Calendar;

public class SeasonTicket {

    private Validity validity;         // продолжительность действия абонемента
    private MyDate startDate;
    private MyDate finishDate;
    private TypeOfSeasonTicket type;   // вид абонемента

    public SeasonTicket() {}

    public SeasonTicket(Validity validity, MyDate date, TypeOfSeasonTicket type) {
        this.validity = validity;
        this.startDate = date;
        this.type = type;
        this.finishDate = (MyDate) date.clone();

        switch (validity) {
            case Month:
                finishDate.add(Calendar.MONTH, 1);
                break;
            case HalfYear:
                finishDate.add(Calendar.MONTH, 6);
                break;
            case Year:
                finishDate.add(Calendar.YEAR, 1);
        }
    }

    public TypeOfSeasonTicket getType() {
        return type;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setType(TypeOfSeasonTicket type) {
        this.type = type;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    public String getTypeOfSeasonTicket() {

        switch (type) {
            case Total:
                return "Тренажёрный зал + групповые занятия, в любое время";
            case FullAm:
                return "Тренажёрный зал + групповые занятия, до 16.00";
            case FullPm:
                return "Тренажёрный зал + групповые занятия, с 16.00";
            case Gym:
                return "Тренажёрный зал, в любое время";
            case GymAm:
                return "Тренажёрный зал, до 16.00";
            case GymPm:
                return "Тренажёрный зал, с 16.00";
            case Group:
                return "Групповые занятия, в любое время";
            case GroupAm:
                return "Групповые занятия, до 16.00";
            case GroupPm:
                return "Групповые занятия, с 16.00";
        }

        return null;
    }

    public String getValidityStr() {
        switch (validity) {
            case Month:
                return "На месяц";
            case HalfYear:
                return "На полгода";
            case Year:
                return "На год";
        }

        return null;
    }

    public MyDate getStartDate() {
        return startDate;
    }

    public void setStartDate(MyDate startDate) {
        this.startDate = startDate;
    }

    public String getStartDateToString() {
        return startDate.dateToString();
    }

    public String getFinishDateToString() {
        return finishDate.dateToString();
    }

    @Override
    public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SeasonTicket)) {
                return false;
            }

            SeasonTicket ticket = (SeasonTicket) obj;
            return validity == ticket.validity && type == ticket.type;
    }
}
