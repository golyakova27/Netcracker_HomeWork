public class Clients {

    private String name;
    private String surname;
    private int age;
    private SeasonTicket seasonTicket;

    public Clients() {}

    public Clients(String name, String surname, int age) {

        this.name = name;
        this.surname = surname;

        if (age > 0) {
            this.age = age;
        }
    }

    public Clients(String name, String surname, int age, SeasonTicket seasonTicket) {

        this.name = name;
        this.surname = surname;
        this.seasonTicket = seasonTicket;

        if (age > 0) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SeasonTicket getSeasonTicket() {
        return seasonTicket;
    }

    public void seasonTicket(SeasonTicket seasonTicket) {
        this.seasonTicket = seasonTicket;
    }

    public String getFullName() {
        return getName() + " " + getSurname();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Clients)) {
            return false;
        }

        Clients client = (Clients) obj;
        return name.equals(client.name) && surname.equals(client.surname) &&
                age == client.age && seasonTicket.equals(client.seasonTicket);
    }
}
