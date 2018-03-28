import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing extends JFrame{

    public Swing() {
        JFrame myFrame = new JFrame("Клиенты спортзала");
        myFrame.setMinimumSize(new Dimension(1000, 600));
        myFrame.setLocation(100, 40);
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        myFrame.setLayout(new BorderLayout());

        ClientsModel obj = ReadFile.readClients();
        JTable table = new JTable(obj);
        JScrollPane jScrollPane = new JScrollPane(table);
        myFrame.add(jScrollPane, BorderLayout.CENTER);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        myFrame.add(jPanel, BorderLayout.SOUTH);

        JPanel jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new FlowLayout());
        jPanel.add(jPanelSouth, BorderLayout.SOUTH);

        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(1, 2));
        jPanel.add(jPanelCenter, BorderLayout.CENTER);

        JPanel jPanelName = new JPanel();
        jPanelName.setLayout(new GridLayout(7, 1));
        jPanelCenter.add(jPanelName);

        JPanel jPanelTicket = new JPanel();
        jPanelTicket.setLayout(new GridLayout(3, 1));
        jPanelCenter.add(jPanelTicket);

        JPanel jPanelTicketLabel = new JPanel();
        jPanelTicketLabel.setLayout(new FlowLayout());
        JPanel jPanelTicketType = new JPanel();
        jPanelTicketType.setLayout(new FlowLayout());
        JPanel jPanelTicketValidity = new JPanel();
        jPanelTicketValidity.setLayout(new FlowLayout());

        jPanelTicketLabel.add(new JLabel("Абонемент"));
        jPanelTicket.add(jPanelTicketLabel);
        jPanelTicket.add(jPanelTicketType);
        jPanelTicket.add(jPanelTicketValidity);

        String[] typeTicket = { "-",
                                "Тренажёрный зал + групповые занятия, в любое время",
                                "Тренажёрный зал + групповые занятия, до 16.00",
                                "Тренажёрный зал + групповые занятия, с 16.00",
                                "Тренажёрный зал, в любое время",
                                "Тренажёрный зал, до 16.00",
                                "Тренажёрный зал, с 16.00",
                                "Групповые занятия, в любое время",
                                "Групповые занятия, до 16.00",
                                "Групповые занятия, с 16.00"};
        jPanelTicketType.add(new JLabel("Вид:    "));
        JComboBox type = new JComboBox(typeTicket);
        jPanelTicketType.add(type);

        jPanelTicketValidity.add(new JLabel("Срок действия: "));
        JRadioButton month = new JRadioButton("месяц");
        JRadioButton halfYear = new JRadioButton("полгода");
        JRadioButton year = new JRadioButton("год");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(month);
        buttonGroup.add(halfYear);
        buttonGroup.add(year);
        jPanelTicketValidity.add(month);
        jPanelTicketValidity.add(halfYear);
        jPanelTicketValidity.add(year);

        JButton addData = new JButton("Добавить клиента");
        JButton removeData = new JButton("Удалить клиента");
        removeData.setEnabled(false);
        JButton editData = new JButton("Изменить");
        editData.setEnabled(false);
        JButton clean = new JButton("Очистить поля");
        jPanelSouth.add(addData);
        jPanelSouth.add(removeData);
        jPanelSouth.add(editData);
        jPanelSouth.add(clean);

        JPanel jPanelNameLabel = new JPanel();
        jPanelNameLabel.setLayout(new FlowLayout());
        jPanelNameLabel.add(new JLabel("Имя *:"));
        jPanelName.add(jPanelNameLabel);

        JPanel jPanelNameField = new JPanel();
        jPanelNameField.setLayout(new FlowLayout());
        JTextField jNameField =  new JTextField(20);
        jPanelNameField.add(jNameField);
        jPanelName.add(jPanelNameField);

        JPanel jPanelSurnameLabel = new JPanel();
        jPanelSurnameLabel.setLayout(new FlowLayout());
        jPanelSurnameLabel.add(new JLabel("Фамилия *:"));
        jPanelName.add(jPanelSurnameLabel);

        JPanel jPanelSurnameField = new JPanel();
        jPanelSurnameField.setLayout(new FlowLayout());
        JTextField jSurnameField =  new JTextField(20);
        jPanelSurnameField.add(jSurnameField);
        jPanelName.add(jPanelSurnameField);

        JPanel jPanelAgeLabel = new JPanel();
        jPanelAgeLabel.setLayout(new FlowLayout());
        jPanelAgeLabel.add(new JLabel("Возраст *:"));
        jPanelName.add(jPanelAgeLabel);

        JPanel jPanelAgeField = new JPanel();
        jPanelAgeField.setLayout(new FlowLayout());
        JTextField jAgeField =  new JTextField(20);
        jPanelAgeField.add(jAgeField);
        jPanelName.add(jPanelAgeField);

        JLabel remark = new JLabel("    * - поля обязательные для заполнения");
        jPanelName.add(remark);


        addData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // кнопка реагирует, только когда поля заполнены
                if (jNameField.getText().isEmpty() || jSurnameField.getText().isEmpty() || jAgeField.getText().isEmpty()) {
                    return;
                }

                Validity validity = Validity.Non;
                TypeOfSeasonTicket ticket = TypeOfSeasonTicket.Non;

                // проверяю, какой тип абонемента возвращает ComboBox
                switch (type.getSelectedIndex()) {
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
                }

                // проверяю, какой срок абонемента возвращает RadioButton
                if (type.getSelectedIndex() != 0) {

                    if (month.isSelected()) {
                        validity = Validity.Month;
                    }

                    if (halfYear.isSelected()) {
                        validity = Validity.HalfYear;
                    }

                    if (year.isSelected()) {
                        validity = Validity.Year;
                    }
                }

                // метод addClient() проверяет правильность ввода имени, фамилии (только буквы без пробелов) и возраста (от 5 до 100 лет)
                // при неверном вводе возвращает int от 1 до 3, при верном - 0 и добавляет клиента
                switch (obj.addClient(new Clients(jNameField.getText(), jSurnameField.getText(), Integer.parseInt(jAgeField.getText())),
                        new SeasonTicket(validity, new MyDate(), ticket))) {

                    case 1:
                        JOptionPane.showMessageDialog(myFrame, "Некорректный ввод возраста. \nВведите число от 5 до 100.",
                                                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                        jAgeField.setText("");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(myFrame, "Некорректный ввод имени. \nИмя должно содержать только латинские буквы, без пробелов.",
                                "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                        jNameField.setText("");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(myFrame, "Некорректный ввод фамилии. \nФамилия должна содержать только латинские буквы, без пробелов.",
                                "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                        jSurnameField.setText("");
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(myFrame, "Данные успешно записаны.",
                                "Сообщение", JOptionPane.PLAIN_MESSAGE);
                        jNameField.setText("");
                        jSurnameField.setText("");
                        jAgeField.setText("");

                }

                buttonGroup.clearSelection();
                type.setSelectedIndex(0);
                WriteFile.writeClients(obj);
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int viewIndex = table.getSelectedRow();
                if(viewIndex != -1) {

                    int modelIndex = table.convertRowIndexToModel(viewIndex);

                    jNameField.setText(obj.getValueAt(modelIndex, 0).toString());
                    jSurnameField.setText(obj.getValueAt(modelIndex, 1).toString());
                    jAgeField.setText(obj.getValueAt(modelIndex, 2).toString());


                    if (obj.getValueAt(modelIndex, 3) != null) {

                        switch (obj.getValueAt(modelIndex, 3).toString()) {

                            case "Тренажёрный зал + групповые занятия, в любое время":
                                type.setSelectedIndex(1);
                                break;
                            case "Тренажёрный зал + групповые занятия, до 16.00":
                                type.setSelectedIndex(2);
                                break;
                            case "Тренажёрный зал + групповые занятия, с 16.00":
                                type.setSelectedIndex(3);
                                break;
                            case "Тренажёрный зал, в любое время":
                                type.setSelectedIndex(4);
                                break;
                            case "Тренажёрный зал, до 16.00":
                                type.setSelectedIndex(5);
                                break;
                            case "Тренажёрный зал, с 16.00":
                                type.setSelectedIndex(6);
                                break;
                            case "Групповые занятия, в любое время":
                                type.setSelectedIndex(7);
                                break;
                            case "Групповые занятия, до 16.00":
                                type.setSelectedIndex(8);
                                break;
                            case "Групповые занятия, с 16.00":
                                type.setSelectedIndex(9);
                        }
                    }

                    if (obj.getValueAt(modelIndex, 4) != null) {

                        switch (obj.getValueAt(modelIndex, 4).toString()) {

                            case "На месяц":
                                month.setSelected(true);
                                break;
                            case "На полгода":
                                halfYear.setSelected(true);
                                break;
                            case "На год":
                                year.setSelected(true);
                        }
                    }
                }

                removeData.setEnabled(true);
                editData.setEnabled(true);
            }
        });

        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeData.setEnabled(false);
                editData.setEnabled(false);
                jNameField.setText("");
                jSurnameField.setText("");
                jAgeField.setText("");
                buttonGroup.clearSelection();
                type.setSelectedIndex(0);
            }
        });

        editData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // кнопка реагирует, только когда поля заполнены
                if (jNameField.getText().isEmpty() || jSurnameField.getText().isEmpty() || jAgeField.getText().isEmpty()) {
                    return;
                }

                Validity validity = Validity.Non;
                TypeOfSeasonTicket ticket = TypeOfSeasonTicket.Non;

                // проверяю, какой тип абонемента возвращает ComboBox
                switch (type.getSelectedIndex()) {
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
                }

                // проверяю, какой срок абонемента возвращает RadioButton
                if (type.getSelectedIndex() != 0) {

                    if (month.isSelected()) {
                        validity = Validity.Month;
                    }

                    if (halfYear.isSelected()) {
                        validity = Validity.HalfYear;
                    }

                    if (year.isSelected()) {
                        validity = Validity.Year;
                    }
                }

                int viewIndex = table.getSelectedRow();
                if(viewIndex != -1) {

                    int modelIndex = table.convertRowIndexToModel(viewIndex);

                    switch (obj.editClient(modelIndex, new Clients(jNameField.getText(), jSurnameField.getText(),
                            Integer.parseInt(jAgeField.getText()), new SeasonTicket(validity, new MyDate(), ticket)))) {

                        case 1:
                            JOptionPane.showMessageDialog(myFrame, "Некорректный ввод возраста. \nВведите число от 5 до 100.",
                                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                            jAgeField.setText("");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(myFrame, "Некорректный ввод имени. \nИмя должно содержать только латинские буквы, без пробелов.",
                                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                            jNameField.setText("");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(myFrame, "Некорректный ввод фамилии. \nФамилия должна содержать только латинские буквы, без пробелов.",
                                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                            jSurnameField.setText("");
                            break;
                        case 0:
                            JOptionPane.showMessageDialog(myFrame, "Данные успешно изменены.",
                                    "Сообщение", JOptionPane.PLAIN_MESSAGE);
                            removeData.setEnabled(false);
                            editData.setEnabled(false);
                            jNameField.setText("");
                            jSurnameField.setText("");
                            jAgeField.setText("");
                            buttonGroup.clearSelection();
                            type.setSelectedIndex(0);
                            WriteFile.writeClients(obj);
                    }
                }

            }
        });

        removeData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int viewIndex = table.getSelectedRow();
                if(viewIndex != -1) {

                    int modelIndex = table.convertRowIndexToModel(viewIndex);
                    obj.removeClient(modelIndex);
                    JOptionPane.showMessageDialog(myFrame, "Запись удалена.",
                            "Сообщение", JOptionPane.PLAIN_MESSAGE);
                }

                removeData.setEnabled(false);
                editData.setEnabled(false);
                jNameField.setText("");
                jSurnameField.setText("");
                jAgeField.setText("");
                buttonGroup.clearSelection();
                type.setSelectedIndex(0);
                WriteFile.writeClients(obj);
            }
        });

        myFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
            }
        });
    }
}
