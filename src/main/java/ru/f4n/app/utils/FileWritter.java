package ru.f4n.app.utils;

import ru.f4n.app.models.User;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class FileWritter {

    private static  BufferedWriter writer;
    public static void write(List<User> userList) {
        try{
            Path p = Paths.get("database.txt");
            createFileIfExists(p);
            writer = Files.newBufferedWriter(p);
            userList.forEach(u ->{
                try {
                    writer.write(u.toString());
                    writer.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createFileIfExists(Path path) throws IOException {
        if(!Files.exists(path)) {
            Files.createFile(path);
        }
    }
}
