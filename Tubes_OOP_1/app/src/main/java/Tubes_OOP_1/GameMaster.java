package Tubes_OOP_1;
import java.util.*;

public class GameMaster {
    class Stopper {
        private boolean end;

        Stopper(boolean end) {
            this.end = end;
        }

        void setEnd(boolean status) {
            this.end = status;
        }
        boolean hasEnded() {
            return this.end;
        } 
    }
    public void game(Scanner console) {
        System.out.print("Insert PLAYER 1's name: ");
        String name1 = console.next();
        System.out.print("Insert PLAYER 2's name: ");
        String name2 = console.next();
        Trainer player1 = new Trainer(name1);
        Trainer player2 = new Trainer(name2);
        System.out.printf("Game starting with %s as PLAYER 1 and %s as PLAYER 2\n", player1.getName(), player2.getName());
        System.out.printf("%s's starting monster is %s\n", player1.getName(), player1.getCurMonster().getName());
        System.out.printf("%s's starting monster is %s\n", player2.getName(), player2.getCurMonster().getName());
        Stopper gameEnd = new Stopper(false);
        while (!gameEnd.hasEnded()) {
            player1.setMove(-1);
            player1.setSwitch(-1);
            player2.setMove(-1);
            player2.setSwitch(-1);
            turn(console, player1, gameEnd);
            if (gameEnd.hasEnded()) {
                break;
            } else {
                turn(console, player2, gameEnd);
                if (gameEnd.hasEnded()) {
                    break;
                }
            }
            if (player1.getSwitch() != -1) {
                player1.switchMonster(player1.getSwitch());
                if (player2.getSwitch() != -1) {
                    player2.switchMonster(player2.getSwitch());
                } else {
                    player2.getCurMonster().getMoves().get(player2.getMove()).makeAMove(player2, player2.getCurMonster(), player1.getCurMonster());
                    deathCheck(player1, player2, console, gameEnd);
                }
            } else {
                if (player2.getSwitch() != -1) {
                    player2.switchMonster(player2.getSwitch());
                    player1.getCurMonster().getMoves().get(player1.getMove()).makeAMove(player1, player1.getCurMonster(), player2.getCurMonster());
                    deathCheck(player2, player1, console, gameEnd);
                } else {
                    Move play1 = player1.getCurMonster().getMoves().get(player1.getMove());
                    Move play2 = player2.getCurMonster().getMoves().get(player2.getMove());
                    if (play1.getPriority() < play2.getPriority()) {
                        player1.getCurMonster().getMoves().get(player1.getMove()).makeAMove(player1, player1.getCurMonster(), player2.getCurMonster());
                        if (isDead(player2.getCurMonster())) {
                            deathCheck(player2, player1, console, gameEnd);
                        } else {
                            player2.getCurMonster().getMoves().get(player2.getMove()).makeAMove(player2, player2.getCurMonster(), player1.getCurMonster());
                            if (isDead(player1.getCurMonster())) {
                                deathCheck(player1, player2, console, gameEnd);
                            }
                        }
                    } else if (play1.getPriority() > play2.getPriority()) {
                        player2.getCurMonster().getMoves().get(player2.getMove()).makeAMove(player2, player2.getCurMonster(), player1.getCurMonster());
                        if (isDead(player1.getCurMonster())) {
                            deathCheck(player1, player2, console, gameEnd);
                        } else {
                            player1.getCurMonster().getMoves().get(player1.getMove()).makeAMove(player1, player1.getCurMonster(), player2.getCurMonster());
                            if (isDead(player2.getCurMonster())) {
                                deathCheck(player2, player1, console, gameEnd);
                            }
                        }
                    } else {
                        if (player1.getCurMonster().getCurStats().getSpeed() > player2.getCurMonster().getCurStats().getSpeed()) {
                            player1.getCurMonster().getMoves().get(player1.getMove()).makeAMove(player1, player1.getCurMonster(), player2.getCurMonster());
                            if (isDead(player2.getCurMonster())) {
                                deathCheck(player2, player1, console, gameEnd);
                            } else {
                                player2.getCurMonster().getMoves().get(player2.getMove()).makeAMove(player2, player2.getCurMonster(), player1.getCurMonster());
                                if (isDead(player1.getCurMonster())) {
                                    deathCheck(player1, player2, console, gameEnd);
                                }
                            }
                        } else if (player1.getCurMonster().getCurStats().getSpeed() < player2.getCurMonster().getCurStats().getSpeed()) {
                            player2.getCurMonster().getMoves().get(player2.getMove()).makeAMove(player2, player2.getCurMonster(), player1.getCurMonster());
                            if (isDead(player1.getCurMonster())) {
                                deathCheck(player1, player2, console, gameEnd);
                            } else {
                                player1.getCurMonster().getMoves().get(player1.getMove()).makeAMove(player1, player1.getCurMonster(), player2.getCurMonster());
                                if (isDead(player2.getCurMonster())) {
                                    deathCheck(player2, player1, console, gameEnd);
                                }
                            }
                        } else {
                            int r = new Random().nextInt(2);
                            if (r == 0) {
                                player1.getCurMonster().getMoves().get(player1.getMove()).makeAMove(player1, player1.getCurMonster(), player2.getCurMonster());
                                if (isDead(player2.getCurMonster())) {
                                    deathCheck(player2, player1, console, gameEnd);
                                } else {
                                    player2.getCurMonster().getMoves().get(player2.getMove()).makeAMove(player2, player2.getCurMonster(), player1.getCurMonster());
                                    if (isDead(player1.getCurMonster())) {
                                        deathCheck(player1, player2, console, gameEnd);
                                    }
                                }
                            } else {
                                player2.getCurMonster().getMoves().get(player2.getMove()).makeAMove(player2, player2.getCurMonster(), player1.getCurMonster());
                                if (isDead(player1.getCurMonster())) {
                                    deathCheck(player1, player2, console, gameEnd);
                                } else {
                                    player1.getCurMonster().getMoves().get(player1.getMove()).makeAMove(player1, player1.getCurMonster(), player2.getCurMonster());
                                    if (isDead(player2.getCurMonster())) {
                                        deathCheck(player2, player1, console, gameEnd);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (player1.getMonsters().size() == 0) {
            if (player2.getMonsters().size() == 0) {
                System.out.printf("%s and %s both had all of their monsters depleted, it's a draw!\n", player1.getName(), player2.getName());
            } else {
                System.out.printf("%s is the only trainer with at least one monster standing, therefore %s is the winner!\n", player2.getName(), player2.getName());
            }
        } else {
            if (player2.getMonsters().size() > 0) {
                System.out.println();
            } else {
                System.out.printf("%s is the only trainer with at least one monster standing, therefore %s is the winner!\n", player1.getName(), player1.getName());
            }
        }
    }

    public void turn(Scanner console, Trainer player, Stopper endStatus) {
        boolean endTurn = false;
        while (!endTurn) {
            try {
                System.out.printf("\n| What is %s going to do? |\n", player.getName());
                System.out.println("[1] Move\n[2] Switch\n[3] View Monsters Info\n[4] View Game Info\n[5] Exit Game");
                System.out.print(">> ");
                int opt = console.nextInt();
                if (opt == 1) {
                    System.out.printf("What is %s's %s going to do?\n", player.getName(), player.getCurMonster().getName());
                    for (int i = 0; i < player.getCurMonster().getMoves().size(); i++) {
                        if (player.getCurMonster().getMoves().get(i).getAmmunition() > 0) {
                            System.out.printf("[%d] ", i);
                            player.getCurMonster().getMoves().get(i).printMove();
                        }
                    }
                    System.out.println("[-1] Cancel");
                    System.out.print(">> ");
                    player.setMove(console.nextInt());
                    if (player.getMove() != -1) endTurn = true;
                    else endTurn = false;
                } else if (opt == 2) {
                    if (player.getMonsters().size() > 0) {
                        System.out.printf("Which monster would %s like to switch %s with?\n", player.getName(), player.getCurMonster().getName());
                        for (int i = 0; i < player.getMonsters().size(); i++) {
                            if (!player.getMonsters().get(i).equals(player.getCurMonster()) && player.getMonsters().get(i).getCurStats().getHealth() > 0) {
                                System.out.printf("[%d] %s ", i, player.getMonsters().get(i).getName());
                                player.getMonsters().get(i).getCurStats().printStats();
                            }
                        }
                        System.out.println("[-1] Cancel");
                        System.out.print(">> ");
                        player.setSwitch(console.nextInt());;
                        if (player.getSwitch() != -1) endTurn = true;
                        else endTurn = false;
                    }
                    else {
                        System.out.printf("%s has no other monster left!\n", player.getName());
                    }
                } else if (opt == 3) {
                    System.out.println("Monsters Info!");
                } else if (opt == 4) {
                    System.out.println("Game Info!");
                } else if (opt == 5) {
                    endStatus.setEnd(true);
                    endTurn = true;
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.err.println(e);
                e.printStackTrace();
            }
        }
    }

    public void statusCheck(Monster monster) {
        StatusCondition.burn(monster);
        StatusCondition.poison(monster);
        StatusCondition.sleep(monster);
        StatusCondition.paralyze(monster);
    }

    public void deathCheck(Trainer player1, Trainer player2, Scanner console, Stopper endStatus) {
        if (isDead(player1.getCurMonster())) {
            if (player1.getMonsters().size() == 0) {
                endStatus.setEnd(true);
            } else {
                deathSwitch(player1, console);
                if (isDead(player2.getCurMonster())) {
                    if (player2.getMonsters().size() == 0) {
                        endStatus.setEnd(true);
                    } else deathSwitch(player2, console);
                }
                else {
                    for (StatusCondition status : StatusCondition.values()) {
                        StatusCondition.statusApply(status, player2.getCurMonster());
                    }
                    if (isDead(player2.getCurMonster())) {
                        if (player2.getMonsters().size() == 0) {
                            endStatus.setEnd(true);
                        } else deathSwitch(player2, console);
                    }
                }
            }
            
        } else {
            for (StatusCondition status : StatusCondition.values()) {
                StatusCondition.statusApply(status, player1.getCurMonster());
            }
            if (isDead(player1.getCurMonster())) {
                if (player1.getMonsters().size() == 0) {
                    endStatus.setEnd(true);
                } else deathSwitch(player1, console);
            }
            if (isDead(player2.getCurMonster())) {
                if (player2.getMonsters().size() == 0) {
                    endStatus.setEnd(true);
                } else deathSwitch(player2, console);
            }
            else {
                for (StatusCondition status : StatusCondition.values()) {
                    StatusCondition.statusApply(status, player2.getCurMonster());
                }
                if (isDead(player2.getCurMonster())) {
                    if (player2.getMonsters().size() == 0) {
                        endStatus.setEnd(true);
                    } else deathSwitch(player2, console);
                }
            }
        }
    }

    public void deathSwitch(Trainer player, Scanner console) {
        System.out.printf("%s's %s's health has dropped to zero...\n", player.getName(), player.getCurMonster().getName());
        System.out.printf("Which monster would %s like to switch %s with?\n", player.getName(), player.getCurMonster().getName());
        for (int i = 0; i < player.getMonsters().size(); i++) {
            if (!player.getMonsters().get(i).equals(player.getCurMonster()) && player.getMonsters().get(i).getCurStats().getHealth() > 0) {
                System.out.printf("[%d] %s", i, player.getMonsters().get(i).getName());
                player.getMonsters().get(i).getCurStats().printStats();
            }
        }
        System.out.print(">> ");
        int localMonsterId = console.nextInt();
        player.switchMonster(localMonsterId);
    }

    public boolean isDead(Monster monster) {
        return monster.getCurStats().getHealth() == 0;
    }
} 
