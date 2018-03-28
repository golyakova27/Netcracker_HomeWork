import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeClients(ClientsModel obj) {

        File file = new File("clients.txt");
        FileWriter fr = null;

        String[] str = new String[obj.getRowCount()];

        for (int i = 0; i < obj.getRowCount(); i++) {

            str[i] = "";

            for (int j = 0; j < 3; j++) {
                str[i] += obj.getValueAt(i,j).toString() + " ";
            }

            if (obj.getValueAt(i, 4) != null) {

                switch (obj.getValueAt(i, 4).toString()) {

                    case "На месяц":
                        str[i] += "1 ";
                        break;
                    case "На полгода":
                        str[i] += "2 ";
                        break;
                    case "На год":
                        str[i] += "3 ";
                }
            }
            else {
                str[i] += "0 ";
            }

            String date = obj.getValueAt(i, 5).toString();
            date = date.replace('.', ' ');

            str[i] += date;

            if (obj.getValueAt(i, 3) != null) {

                switch (obj.getValueAt(i, 3).toString()) {

                    case "Тренажёрный зал + групповые занятия, в любое время":
                        str[i] += " 1";
                        break;
                    case "Тренажёрный зал + групповые занятия, до 16.00":
                        str[i] += " 2";
                        break;
                    case "Тренажёрный зал + групповые занятия, с 16.00":
                        str[i] += " 3";
                        break;
                    case "Тренажёрный зал, в любое время":
                        str[i] += " 4";
                        break;
                    case "Тренажёрный зал, до 16.00":
                        str[i] += " 5";
                        break;
                    case "Тренажёрный зал, с 16.00":
                        str[i] += " 6";
                        break;
                    case "Групповые занятия, в любое время":
                        str[i] += " 7";
                        break;
                    case "Групповые занятия, до 16.00":
                        str[i] += " 8";
                        break;
                    case "Групповые занятия, с 16.00":
                        str[i] += " 9";
                }
            }
            else {
                str[i] += " 0";
            }
        }

        try {
            fr = new FileWriter(file);
            for (int i = 0; i < obj.getRowCount(); i++) {
                fr.write(str[i] + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
