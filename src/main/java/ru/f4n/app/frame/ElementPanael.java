package ru.f4n.app.frame;

import ru.f4n.app.frame.table_model.AppTableModel;
import ru.f4n.app.models.User;
import ru.f4n.app.utils.FileLoader;
import ru.f4n.app.utils.FileWritter;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.stream.Collectors;

public class ElementPanael extends JPanel {

    private JTable mainTable;
    private GroupLayout groupLayout;
    private JScrollPane scrollPane;

    private JCheckBox showToday;
    private JButton spendLesson;

    private JButton addUser;
    private JButton deleteUser;

    private JButton saveIn;
    private JButton readOn;
    private List<User> userList = new ArrayList<>();;

    public ElementPanael() {
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

        showToday = new JCheckBox("Показать учеников, записанных на сегодня");
        showToday.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(showToday.isSelected()) {
                    List<User> list = userList.stream().filter(u ->
                            u.getNextLessonDate().before(new Date(new Date().getTime() + 86400000)) &&
                                    u.getNextLessonDate().after(new Date(new Date().getTime() - 86400000))&&
                                    u.isStudent()
                    ).collect(Collectors.toList());
                    tableModel.setData(list);
                    tableModel.updateTable();
                }else {
                    tableModel.setData(userList);
                    tableModel.updateTable();
                }
            }
        });

        spendLesson = new JButton("Провести урок");
        spendLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = mainTable.getSelectedRow();
                if(rowIndex < 0) return;
                int value = (int) tableModel.getValueAt(rowIndex, 4) + 1;
                tableModel.setValueAt(value, rowIndex, 4);
                int result = (int) tableModel.getValueAt(rowIndex, 5) / (int) tableModel.getValueAt(rowIndex,3);
                tableModel.setValueAt(result, rowIndex, 6);
            }
        });

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

        saveIn = new JButton("Сохранить в БД");
        saveIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWritter.write(userList);
            }
        });
        readOn = new JButton("Прочитать из БД");
        readOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userList = FileLoader.load();
                tableModel.setData(userList);
                tableModel.updateTable();
            }
        });

        initialize();
    }

    private void initialize() {
        groupLayout.linkSize(SwingConstants.HORIZONTAL, showToday, addUser, deleteUser, saveIn, readOn);
        groupLayout.linkSize(SwingConstants.VERTICAL, showToday, addUser, deleteUser, saveIn, readOn);
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
                                .addGroup(
                                        groupLayout.createParallelGroup()
                                                .addComponent(saveIn)
                                                .addComponent(readOn)

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
                                .addGroup(
                                        groupLayout.createSequentialGroup()
                                                .addComponent(saveIn)
                                                .addComponent(readOn)
                                )
                )
        );
    }
}
