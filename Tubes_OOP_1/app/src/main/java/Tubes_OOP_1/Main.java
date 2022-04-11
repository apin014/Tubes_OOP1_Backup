package Tubes_OOP_1;
import java.io.IOException;
import java.util.*;
import Tubes_OOP_1.util.Initializer;

public class Main {
    public static void main(String[] args) {
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
                    System.out.println("This is where the rule of the game is displayed!");
                } else if (opt == 3) {
                    end = true;
                } else {
                    throw new Exception("Option not available!");
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e);
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
