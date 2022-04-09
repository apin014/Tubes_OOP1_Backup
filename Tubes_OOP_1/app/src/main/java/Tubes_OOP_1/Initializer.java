package Tubes_OOP_1;
import java.io.File;
import java.util.*;
import java.io.*;
import Tubes_OOP_1.util.CSVReader;

public class Initializer {
    public static List<String[]> toList(String path, boolean withHeader) {
        File file = new File(path);
        CSVReader csv = new CSVReader(file, ";");
        csv.setSkipHeader(withHeader);
        try {
            return csv.read();
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
