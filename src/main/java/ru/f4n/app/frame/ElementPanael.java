package ru.f4n.app.frame;

import ru.f4n.app.frame.table_model.AppTableModel;
import ru.f4n.app.models.User;

import javax.swing.*;
import java.util.List;

public class ElementPanael extends JPanel {

    private JTable mainTable;
    private GroupLayout groupLayout;
    private JScrollPane scrollPane;

    private JButton addUser;

    public ElementPanael() {}
    public ElementPanael(List<User> userList) {
        groupLayout = new GroupLayout(this);
        setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        AppTableModel tableModel = new AppTableModel(userList);
        mainTable = new JTable(tableModel);
        scrollPane = new JScrollPane(mainTable);

        addUser = new JButton("Добавить пользователя");

        initialize();
    }

    private void initialize() {
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                .addComponent(scrollPane)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                .addComponent(scrollPane)
        );
    }
}
