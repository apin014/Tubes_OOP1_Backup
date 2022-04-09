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
        File csv = new File("E:\\Repos\\MyToobes\\Tubes_OOP1_Backup\\Tubes_OOP_1\\app\\src\\main\\java\\resources\\monsterPool.csv");
        CSVReader reader = new CSVReader(csv, ";");
        reader.setSkipHeader(true);
        try {
            List<String[]> list = reader.read();
            for (String[] row : list) {
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
