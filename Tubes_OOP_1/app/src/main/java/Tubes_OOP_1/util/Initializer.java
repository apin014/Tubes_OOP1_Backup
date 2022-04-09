package Tubes_OOP_1.util;
import java.util.*;
import java.io.*;
import Tubes_OOP_1.ElementEffectivity;
import Tubes_OOP_1.Move;
import Tubes_OOP_1.Monster;

public class Initializer {
    public static void initialize(String elementEffectivityPath, String movePath, String monsterPath) throws IOException {
        File elementEffectivity = new File(elementEffectivityPath);
        File move = new File(movePath);
        File monster = new File(monsterPath);

        CSVReader reader = new CSVReader(elementEffectivity, ";");
        reader.setSkipHeader(true);
        List<String[]> config = reader.read();
        ElementEffectivity.pool(config);

        reader = new CSVReader(move, ";");
        config = reader.read();
        Move.pool(config);

        reader = new CSVReader(monster, ";");
        config = reader.read();
        Monster.pool(config);
    }
}