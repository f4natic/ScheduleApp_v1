package ru.f4n.app;

import ru.f4n.app.models.User;

import java.io.BufferedReader;
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

    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("yyyy-MM-dd hh:mm");

        Path p = Paths.get("users.fff");

        List<User> usersList = new ArrayList<>();

        Files.lines(p).forEach(s -> {
            String[] array = s.split("\\*");
            try {
                User user = new User(Long.parseLong(array[0]), array[1], array[2],
                                        Integer.parseInt(array[3]), Integer.parseInt(array[4]),
                                        Integer.parseInt(array[5]), Integer.parseInt(array[6]),
                                        dateFormat.parse(array[7]), Boolean.parseBoolean(array[8]));
                usersList.add(user);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        User user = new User(1, "Nicolay", "Ivushkin",
                2, 1, 1200, 600,
                dateFormat.parse("2021-06-15 18:00"), true);
        usersList.add(user);

        Date now = new Date();
        System.out.println(now);
        long l = now.getTime() +86400000;
        now = new Date(l);
        for(User u : usersList) {
            if(u.getNextLessonDate().before(now)) {
                System.out.println(u);
            }
        }

        for(User u : usersList) {
            if(u.getNextLessonDate().after(now)) {
                System.out.println(u);
            }
        }
    }
}
