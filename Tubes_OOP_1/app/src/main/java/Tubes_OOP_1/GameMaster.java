package Tubes_OOP_1;
import java.util.*;

public class GameMaster {
    public static void game(Scanner console) {
        System.out.print("Insert PLAYER 1's name: ");
        String name1 = console.next();
        System.out.print("Insert PLAYER 2's name: ");
        String name2 = console.next();
        Trainer player1 = new Trainer(name1);
        Trainer player2 = new Trainer(name2);
        int player1Move = -1;
        int player2Move = -1;
        int player1Switch = -1;
        int player2Switch = -1;
        System.out.printf("Game starting with %s as PLAYER 1 and %s as PLAYER 2\n", player1.getName(), player2.getName());
        boolean endTurn = false;
        while (!endTurn) {
            System.out.printf("| What is %s going to do? |\n", player1.getName());
                System.out.println("[1] Move\n[2] Switch\n[3] View Monsters Info\n[4] View Game Info");
                System.out.print(">>");
                int opt = console.nextInt();
                if (opt == 1) {
                    System.out.printf("What is %s's %s going to do?\n", player1.getName(), player1.getCurMonster().getName());
                    for (int i = 0; i < player1.getCurMonster().getMoves().size(); i++) {
                        System.out.printf("[%d] %s (%d left)\n", i, player1.getCurMonster().getMoves().get(i).getName(), player1.getCurMonster().getMoves().get(i).getAmmunition());
                    }
                    System.out.print(">> ");
                    player1Move = console.nextInt();
                    endTurn = true;
                } else if (opt == 2) {
                    System.out.printf("Which monster would %s like to switch %s with?\n", player1.getName(), player1.getCurMonster().getName());
                    for (int i = 0; i < player1.getMonsters().size(); i++) {
                        if (!player1.getMonsters().get(i).equals(player1.getCurMonster())) {
                            System.out.printf("[%d] %s", i, player1.getMonsters().get(i));
                        }
                    }
                    System.out.print(">> ");
                    player1Switch = console.nextInt();
                    endTurn = true;
                }
        }
    }
    /*
    public static void turn(Scanner console, Trainer primary, Trainer secondary) {
        boolean endTurn = false;
        while (!endTurn) {
                System.out.printf("| What is %s going to do? |\n", primary.getName());
                System.out.println("[1] Move\n[2] Switch\n[3] View Monsters Info\n[4] View Game Info");
                System.out.print(">>");
                int opt = console.nextInt();
                if (opt == 1) {
                    System.out.printf("What is %s's %s going to do?\n", primary.getName(), primary.getCurMonster().getName());
                    for (int i = 0; i < primary.getCurMonster().getMoves().size(); i++) {
                        System.out.printf("[%d] %s (%d left)\n", i, primary.getCurMonster().getMoves().get(i).getName(), primary.getCurMonster().getMoves().get(i).getAmmunition());

                    }
                } else if (opt == 2) {
                    
                }
        }
        
    } */
} 
