package ru.f4n.app.frame.table_model;

import ru.f4n.app.models.User;
import ru.f4n.app.utils.DateFormatUtils;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.List;

public class AppTableModel extends AbstractTableModel {
    private String[] columnTitle = {"id", "Имя", "Фамиля",
                                    "Куплено занятий", "Проведено занятий",
                                    "Оплачено", "Остаток", "Дата следующего занятия", "Ученик"
                                    };
    private List<User> data;

    public AppTableModel(List<User> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnTitle.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result;
        User user = data.get(rowIndex);
        switch(columnIndex) {
            case 0:
                result = (Object) user.getId();
                break;
            case 1:
                result = (Object) user.getFirstName();
                break;
            case 2:
                result = (Object) user.getLastName();
                break;
            case 3:
                result = (Object) user.getPurchasedClasses();
                break;
            case 4:
                result = (Object) user.getConductedClasses();
                break;
            case 5:
                result = (Object) user.getPaid();
                break;
            case 6:
                result = (Object) user.getResidue();
                break;
            case 7:
                result = (Object) DateFormatUtils.getStringDate(user.getNextLessonDate());
                break;
            case 8:
                result = (Object) user.isStudent();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + columnIndex);
        }
        return result;
    }

    // Return Column Name
    public String getColumnName(int columnIndex) {
        return columnTitle[columnIndex];
    }

    // Class representation in a table
    @Override
    public Class<?> getColumnClass(int columnIndex) {
//        return super.getColumnClass(columnIndex);
        return getValueAt (0, columnIndex) .getClass ();
    }

    // Editable Cell
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(
                columnIndex != 1 && columnIndex != 2 &&
                columnIndex != 3 && columnIndex != 5 &&
                columnIndex != 7 && columnIndex != 8
        ) {
            return false;
        }
        return true;
    }

    //Set value in table
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        User user = data.get(rowIndex);

        switch(columnIndex) {
            case 1:
                user.setFirstName((String) value);
                break;
            case 2:
                user.setLastName((String) value);
                break;
            case 3:
                user.setPurchasedClasses((int) value);
                break;
            case 4:
                user.setConductedClasses((int) value);
                break;
            case 5:
                user.setPaid((int) value);
                user.setResidue(user.getResidue() + (int)value);
                updateTable();
                break;
            case 6:
                user.setResidue(user.getResidue() - (int) value);
                updateTable();
                break;
            case 7:
                user.setNextLessonDate(DateFormatUtils.getDate((String)value));
                break;
            case 8:
                user.setStudent((boolean) value);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + columnIndex);
        }
    }

    public void deleteRow(int rowIndex) {
        data.remove(rowIndex);
        updateTable();
    }

    public void updateTable() {
        fireTableDataChanged();
    }
}
