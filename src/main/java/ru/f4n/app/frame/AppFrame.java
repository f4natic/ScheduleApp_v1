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
        int width = dimension.width / 2;
        int height = dimension.height / 2;
        mainFrame.setSize(new Dimension(width, height));
        mainFrame.setTitle("Schedule");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
