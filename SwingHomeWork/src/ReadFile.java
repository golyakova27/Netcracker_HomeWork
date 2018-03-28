import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {

    public static ClientsModel readClients() {

        ClientsModel obj = new ClientsModel();

        try (FileReader reader = new FileReader(System.getProperty("user.dir") + "\\clients.txt")) {
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] clientInfo = line.split("\\s+");

                Validity validity;

                switch (Integer.parseInt(clientInfo[3])) {
                    case 1:
                        validity = Validity.Month;
                        break;
                    case 2:
                        validity = Validity.HalfYear;;
                        break;
                    case 3:
                        validity = Validity.Year;
                        break;
                        default:
                            validity = Validity.Non;
                }

                TypeOfSeasonTicket ticket;

                switch (Integer.parseInt(clientInfo[7])) {
                    case 1:
                        ticket = TypeOfSeasonTicket.Total;
                        break;
                    case 2:
                        ticket = TypeOfSeasonTicket.FullAm;
                        break;
                    case 3:
                        ticket = TypeOfSeasonTicket.FullPm;
                        break;
                    case 4:
                        ticket = TypeOfSeasonTicket.Gym;
                        break;
                    case 5:
                        ticket = TypeOfSeasonTicket.GymAm;
                        break;
                    case 6:
                        ticket = TypeOfSeasonTicket.GymPm;
                        break;
                    case 7:
                        ticket = TypeOfSeasonTicket.Group;
                        break;
                    case 8:
                        ticket = TypeOfSeasonTicket.GroupAm;
                        break;
                    case 9:
                        ticket = TypeOfSeasonTicket.GroupPm;
                        break;
                        default:
                            ticket = TypeOfSeasonTicket.Non;
                }

                MyDate date = new MyDate(Integer.parseInt(clientInfo[6]),
                        Integer.parseInt(clientInfo[5]) - 1, Integer.parseInt(clientInfo[4]));

                obj.addClient(new Clients(clientInfo[0], clientInfo[1], Integer.parseInt(clientInfo[2])),
                        new SeasonTicket(validity, date, ticket));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

        return obj;
    }
}