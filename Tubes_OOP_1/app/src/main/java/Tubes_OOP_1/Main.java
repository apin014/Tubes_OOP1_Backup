package Tubes_OOP_1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("| Main Menu |");
        System.out.printf("[1] Start Game%n[2] Help%n[3] Exit%n");
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            System.out.print(">> ");
            int opt = scanner.nextInt();
            try {
                if (opt == 1) {
                    System.out.println("Game started!");
                } else if (opt == 2) {
                    System.out.println("This is where the rule of the game is displayed!");
                } else if (opt == 3) {
                    end = true;
                } else {
                    throw new Exception("Option not available!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
