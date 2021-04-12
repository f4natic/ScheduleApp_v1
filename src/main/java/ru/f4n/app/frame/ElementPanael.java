package ru.f4n.app.frame;

import ru.f4n.app.frame.table_model.AppTableModel;
import ru.f4n.app.models.User;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class ElementPanael extends JPanel {

    private JTable mainTable;
    private GroupLayout groupLayout;
    private JScrollPane scrollPane;

    private JCheckBox showToday;
    private JButton addUser;
    private JButton deleteUser;
    private JButton spendLesson;

    public ElementPanael() {}

    public ElementPanael(List<User> userList) {
        groupLayout = new GroupLayout(this);
        setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        AppTableModel tableModel = new AppTableModel(userList);
        mainTable = new JTable(tableModel);
        scrollPane = new JScrollPane(mainTable);
        TableColumn purchasedColumn = mainTable.getColumnModel().getColumn(3);
        JComboBox<Integer> purchasedClasses = new JComboBox<>();
        purchasedClasses.addItem(1);
        purchasedClasses.addItem(2);
        purchasedClasses.addItem(4);
        purchasedColumn.setCellEditor(new DefaultCellEditor(purchasedClasses));

        showToday = new JCheckBox("Показать, записанных на сегодня");

        addUser = new JButton("Добавить пользователя");
        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(
                        userList.size() + 1,
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        new Date(),
                        false
                );
                userList.add(user);
                tableModel.updateTable();
            }
        });

        deleteUser = new JButton("Удалить пользователя");
        deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainTable.getSelectedRow() > -1){
                    tableModel.deleteRow(mainTable.getSelectedRow());
                }else return;
            }
        });

        spendLesson = new JButton("Провести урок");

        initialize();
    }

    private void initialize() {
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup()
                .addComponent(scrollPane)
                .addGroup(
                        groupLayout.createSequentialGroup()
                                .addGroup(
                                        groupLayout.createParallelGroup()
                                                .addComponent(showToday)
                                                .addComponent(spendLesson)

                                )
                                .addGroup(
                                        groupLayout.createParallelGroup()
                                                .addComponent(addUser)
                                                .addComponent(deleteUser)

                                )
                )
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                .addComponent(scrollPane)
                .addGroup(
                        groupLayout.createParallelGroup()
                                .addGroup(
                                        groupLayout.createSequentialGroup()
                                                .addComponent(showToday)
                                                .addComponent(spendLesson)
                                )
                                .addGroup(
                                        groupLayout.createSequentialGroup()
                                                .addComponent(addUser)
                                                .addComponent(deleteUser)
                                )
                )
        );
    }
}
