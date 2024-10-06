package models.file;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import utils.Constants;

public class FileHandler {

    public FileHandler() {
        try {
            initFile(Constants.Path.Files.CONSTELLATIONS,
                    new String[] {
                            "Constellation ID",
                            "Stars IDs",
                            "Date" });
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    private static void initFile(String filePath, String[] fileHeaders) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            writer.write(String.join(Constants.SEPARATOR, fileHeaders) + "\n");
            writer.close();
        }
    }

    public static List<String> readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }

    public static void writeFile(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }

    public static void appendToFile(String filePath, String newLine) throws IOException {
        FileWriter fout = new FileWriter(filePath, true);
        BufferedWriter wfbuffer = new BufferedWriter(fout);

        wfbuffer.write(newLine);
        wfbuffer.newLine();
        wfbuffer.close();
    }

}
