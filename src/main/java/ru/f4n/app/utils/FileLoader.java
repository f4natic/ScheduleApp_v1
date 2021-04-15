package ru.f4n.app.utils;

import ru.f4n.app.models.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<User> load() {

        Path p = Paths.get("database.txt");
        List<User> usersList = new ArrayList<>();

        try {
            if (Files.exists(p)) {
                Files.lines(p).forEach(s -> {
                    String[] array = s.split("\\*");
                    User user = new User(Long.parseLong(array[0]), array[1], array[2],
                            Integer.parseInt(array[3]), Integer.parseInt(array[4]),
                            Integer.parseInt(array[5]), Integer.parseInt(array[6]),
                            DateFormatUtils.getDate(array[7]), Boolean.parseBoolean(array[8]));
                    usersList.add(user);
                });
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return usersList;
    }
}