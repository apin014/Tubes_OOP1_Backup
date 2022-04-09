/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes_OOP_1;
import java.util.List;
import java.io.*;
import Tubes_OOP_1.util.CSVReader;

/**
 *
 * @author Davin
 */
public class CSVReaderTest {
    public static void main(String[] args) {
        File moveCsv = new File(args[0]);
        CSVReader reader = new CSVReader(moveCsv, ";");
        reader.setSkipHeader(true);

        File monsterCsv = new File(args[1]);
        CSVReader reader2 = new CSVReader(monsterCsv, ";");
        reader2.setSkipHeader(true);
        try {
            List<String[]> list = reader.read();
            for (String[] row : list) {
                for(String col : row) {
                    System.out.print(col);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------------------");
            List<String[]> list2 = reader2.read();
            for (String[] row : list2) {
                for(String col : row) {
                    System.out.print(col);
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
