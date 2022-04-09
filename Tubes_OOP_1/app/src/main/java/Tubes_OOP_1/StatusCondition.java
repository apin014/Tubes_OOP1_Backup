package Tubes_OOP_1;
import java.util.*;

public enum StatusCondition {
    BURN, 
    POISON, 
    SLEEP, 
    PARALYZE;

    public static StatusCondition parse(String s) {
        if (s.equals("BURN")) {
            return BURN;
        } else if (s.equals("POISON")) {
            return POISON;
        } else if (s.equals("SLEEP")) {
            return SLEEP;
        } else if (s.equals("PARALYZE")) {
            return PARALYZE;
        } else {
            return null;
        }
    }

    public static void afflict(Monster target, StatusCondition affliction) {
        if (target.getStatusCondition().equals(null)) {
            target.setStatusCondition(affliction);
            if (affliction.equals(SLEEP)) {
                target.getCurStats().setSkipTurn(new Random().nextInt(6) + 1);
            } else if (affliction.equals(PARALYZE)) {
                target.getCurStats().setSpeed(target.getCurStats().getSpeed() * 0.5);
                List<Integer> chance = new ArrayList<>(4);
                chance.add(1);
                for (int i = 0; i < 3; i++) chance.add(0);
                Collections.shuffle(chance);
                if (chance.get(new Random().nextInt(4)) == 1) {
                    target.getCurStats().setSkipTurn(1);
                }
            }
        } else {
            if (target.getStatusCondition().equals(affliction)) {
                System.out.println("Cannot afflict target with " + affliction + ": Target already afflicted with the same status condition");
            } else {
                System.out.println("Cannot afflict target with " + affliction + ": Target already afflicted with a different status condition");
            }
        }
    }

    public static void relief(Monster target) {
        target.setStatusCondition(null);
    }

    public static void burn(Monster target) {
        if (target.getStatusCondition().equals(BURN)) {
            double dmg = Math.floor((double) target.getStats().getHealth()/8);
            target.getCurStats().setHealth(target.getCurStats().getHealth() - dmg);
        }
    }
    
    public static void poison(Monster target) {
        if (target.getStatusCondition().equals(POISON)) {
            double dmg = Math.floor((double) target.getStats().getHealth()/16);
            target.getCurStats().setHealth(target.getCurStats().getHealth() - dmg);
        }
    }

    public static void sleep(Monster target) {
        if (target.getStatusCondition().equals(SLEEP)) {
            if (target.getCurStats().getSkipTurn() > 0) {
                if (target.getCurStats().getSkipTurn() == 1) {
                    target.getCurStats().decreaseSkipTurn();
                    relief(target);
                }
                else target.getCurStats().decreaseSkipTurn();
            }
        }
    }

    public static void paralyze(Monster target) {
        if (target.getStatusCondition().equals(PARALYZE)) {
            if (target.getCurStats().getSkipTurn() == 1) {
                target.getCurStats().decreaseSkipTurn();
            }
        }
    }
}
