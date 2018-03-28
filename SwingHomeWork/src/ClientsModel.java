import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClientsModel extends AbstractTableModel {

    private List<Clients> clients = new ArrayList<>();
    private List<SeasonTicket> tickets = new ArrayList<>();

    public ClientsModel() {}

    private int inputTest(Clients client) {

        // проверка Имени
        for (int i = 0; i < client.getName().length(); i++) {
            if (!((client.getName().charAt(i) > 64 && client.getName().charAt(i) < 91) ||
                    (client.getName().charAt(i) > 96 && client.getName().charAt(i) < 123))) {
                return 2;
            }
        }

        // проверка Фамилии
        for (int i = 0; i < client.getSurname().length(); i++) {
            if (!((client.getSurname().charAt(i) > 64 && client.getSurname().charAt(i) < 91) ||
                    (client.getSurname().charAt(i) > 96 && client.getSurname().charAt(i) < 123))) {
                return 3;
            }
        }

        // проверка возраста
        if (client.getAge() > 4 && client.getAge() < 101) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public int addClient(Clients client, SeasonTicket ticket) {

        if (inputTest(client) == 0) {
            clients.add(client);
            tickets.add(ticket);
            fireTableDataChanged();
        }

        return inputTest(client);
    }


    public void removeClient(int index) {

        clients.remove(index);
        tickets.remove(index);

        fireTableDataChanged();
    }

    public int editClient(int index, Clients client) {

        if (inputTest(client) == 0) {

            clients.get(index).setName(client.getName());
            clients.get(index).setSurname(client.getSurname());
            clients.get(index).setAge(client.getAge());

            if (!tickets.get(index).equals(client.getSeasonTicket())) {

                tickets.get(index).setValidity(client.getSeasonTicket().getValidity());
                tickets.get(index).setType(client.getSeasonTicket().getType());
                tickets.get(index).setStartDate(new MyDate());
            }
        }

        fireTableDataChanged();
        return inputTest(client);
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clients client = clients.get(rowIndex);
        SeasonTicket ticket = tickets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getName();
            case 1:
                return client.getSurname();
            case 2:
                return client.getAge();
            case 3:
                return ticket.getTypeOfSeasonTicket();
            case 4:
                return ticket.getValidityStr();
            case 5:
                return ticket.getStartDateToString();
            case 6:
                return ticket.getFinishDateToString();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Имя";
            case 1:
                return "Фамилия";
            case 2:
                return "Возраст";
            case 3:
                return "Тип абонемента";
            case 4:
                return "Срок действия абонемента";
            case 5:
                return "Дата приобретения";
            case 6:
                return "Окончание срока действия";
        }
        return "";
    }

    public Class<?> getColumnClass (int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
        }
        return Object.class;
    }
}
