package ru.f4n.app;

import ru.f4n.app.frame.AppFrame;
import ru.f4n.app.models.User;
import ru.f4n.app.utils.DateFormatUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    /*
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd hh:mm");
     */

    public static void main(String[] args) {
        new AppFrame();
    }
}
