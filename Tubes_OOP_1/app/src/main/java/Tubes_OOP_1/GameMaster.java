package Tubes_OOP_1;
import java.util.*;

public class GameMaster {
    public void game(Scanner console) {
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
        turn(console, player1, player1Move, player1Switch);
        turn(console, player2, player2Move, player2Switch);
        if (player1Switch != -1) {
            player1.switchMonster(player1Switch);
            player1Switch = -1;
            if (player2Switch != -1) {
                player2.switchMonster(player2Switch);
                player2Switch = -1;
            } else {
                player2.getCurMonster().getMoves().get(player2Move).makeAMove(player2.getCurMonster(), player1.getCurMonster());
            }
        } else {
            if (player2Switch != -1) {
                player2.switchMonster(player2Switch);
                player2Switch = -1;
                player1.getCurMonster().getMoves().get(player1Move).makeAMove(player1.getCurMonster(), player2.getCurMonster());
            } else {
                Move play1 = player1.getCurMonster().getMoves().get(player1Move);
                Move play2 = player2.getCurMonster().getMoves().get(player2Move);
            }
        }
        
    }

    public void turn(Scanner console, Trainer player, int playerMove, int playerSwitch) {
        boolean endTurn = false;
        while (!endTurn) {
            System.out.printf("\n| What is %s going to do? |\n", player.getName());
            System.out.println("[1] Move\n[2] Switch\n[3] View Monsters Info\n[4] View Game Info");
            System.out.print(">>");
            int opt = console.nextInt();
            if (opt == 1) {
                System.out.printf("What is %s's %s going to do?\n", player.getName(), player.getCurMonster().getName());
                for (int i = 0; i < player.getCurMonster().getMoves().size(); i++) {
                    System.out.printf("[%d] %s (%d left)\n", i, player.getCurMonster().getMoves().get(i).getName(), player.getCurMonster().getMoves().get(i).getAmmunition());
                }
                System.out.print(">> ");
                playerMove = console.nextInt();
                endTurn = true;
            } else if (opt == 2) {
                System.out.printf("Which monster would %s like to switch %s with?\n", player.getName(), player.getCurMonster().getName());
                for (int i = 0; i < player.getMonsters().size(); i++) {
                    if (!player.getMonsters().get(i).equals(player.getCurMonster())) {
                        System.out.printf("[%d] %s", i, player.getMonsters().get(i));
                    }
                }
                System.out.print(">> ");
                playerSwitch = console.nextInt();
                endTurn = true;
            } else if (opt == 3) {
                System.out.println("Monsters Info!");
            } else if (opt == 4) {
                System.out.println("Game Info!");
            }
        }
    }

    public void statusCheck(Monster monster) {
        StatusCondition.burn(monster);
        StatusCondition.poison(monster);
        StatusCondition.sleep(monster);
        StatusCondition.paralyze(monster);
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
