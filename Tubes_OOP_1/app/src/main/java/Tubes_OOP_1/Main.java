package Tubes_OOP_1;
import java.io.*;
import java.util.*;
import Tubes_OOP_1.util.Initializer;

public class Main {
    public static void main(String[] args) {
        if (args[0].substring(0, 4).equals("\\src")) args[0] = System.getProperty("user.dir") + args[0];
        if (args[1].substring(0, 4).equals("\\src")) args[1] = System.getProperty("user.dir") + args[1];
        if (args[2].substring(0, 4).equals("\\src")) args[2] = System.getProperty("user.dir") + args[2];
        try {
            Initializer.initialize(args[0], args[1], args[2]);
            if (ElementEffectivity.poolEmpty() || Move.poolEmpty() || Monster.poolEmpty()) {
                throw new Exception("Empty pool detected!");
            }
        } catch(IOException e) {
            System.err.println(e);
            System.exit(-1);
        } catch(Exception e) {
            System.err.println(e);
            e.printStackTrace();
            System.exit(-1);
        }
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            System.out.println("| Main Menu |");
            System.out.printf("[1] Start Game%n[2] Help%n[3] Exit%n");
            System.out.print(">> ");
            int opt = scanner.nextInt();
            try {
                if (opt == 1) {
                    GameMaster gm = new GameMaster();
                    Scanner console = new Scanner(System.in);
                    gm.game(console);
                } else if (opt == 2) {
                    String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\gameRule.txt";
                    File rule = new File(path);
                    Scanner fileReader = new Scanner(rule);
                    System.out.println("");
                    while (fileReader.hasNextLine()) {
                        System.out.println(fileReader.nextLine());
                    }
                    System.out.println("");
                    fileReader.close();
                } else if (opt == 3) {
                    end = true;
                } else {
                    throw new Exception("Option not available!");
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e);
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println(e);
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                System.err.println(e);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println(e);
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
