package ru.f4n.app.frame;

import javax.swing.*;
import java.awt.*;

public class AppFrame {

    public AppFrame(){
        EventQueue.invokeLater(() -> initialize());
    }

    private void initialize() {
        JFrame mainFrame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        mainFrame.setSize(dimension);
        mainFrame.setTitle("Schedule");
        mainFrame.add(new ElementPanael());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
