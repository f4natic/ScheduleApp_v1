package ru.f4n.app.frame;

import ru.f4n.app.models.User;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class AppFrame {
    private List<User> userList;

    public AppFrame(List<User> userList){
        this.userList = userList;
        EventQueue.invokeLater(() -> initialize());
    }

    private void initialize() {
        JFrame mainFrame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = dimension.width / 2;
        int height = dimension.height / 2;
        mainFrame.setSize(new Dimension(width, height));
        mainFrame.setTitle("Schedule");
        mainFrame.add(new ElementPanael(userList));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
