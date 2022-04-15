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
        if (target.getStatusCondition() == null) {
            target.setStatusCondition(affliction);
            if (affliction.equals(SLEEP)) {
                target.getCurStats().setSkipTurn(new Random().nextInt(6) + 1);
            } else if (affliction.equals(PARALYZE)) {
                target.getCurStats().setSpeed(target.getCurStats().getSpeed() * 0.5);
                List<Integer> chance = new ArrayList<>(4);
                chance.add(1);
                for (int i = 0; i < 3; i++) chance.add(0);
                Collections.shuffle(chance);
                if (chance.get(new SplittableRandom().nextInt(4)) == 1) {
                    target.getCurStats().setSkipTurn(1);
                }
            }
            System.out.printf("%s is afflicted by %s!\n", target.getName(), affliction.name()); 
        } else {
            if (target.getStatusCondition().equals(affliction)) {
                System.out.printf("Cannot afflict %s with " + affliction + ": Target already afflicted with the same status condition\n", target.getName());
            } else {
                System.out.printf("Cannot afflict %s with " + affliction + ": Target already afflicted with a different status condition\n", target.getName());
            }
        }
    }

    public static void statusApply(StatusCondition status, Monster target) {
        if (status != null) {
            if (status.equals(BURN)) {
                burn(target);
            } else if (status.equals(POISON)) {
                poison(target);
            } else if (status.equals(SLEEP)) {
                sleep(target);
            } else if (status.equals(PARALYZE)) {
                paralyze(target);
            }
        }
    }

    public static void relief(Monster target) {
        target.setStatusCondition(null);
    }

    public static void burn(Monster target) {
        if (target.getStatusCondition() != null) {
            if (target.getStatusCondition().equals(BURN)) {
                System.out.printf("%s is burning!\n", target.getName());
                double dmg = Math.floor((double) target.getStats().getHealth()/8);
                Double finalHealth = (target.getCurStats().getHealth() - dmg) < 0 ? 0 : (target.getCurStats().getHealth() - dmg);
                target.getCurStats().setHealth(finalHealth);
                System.out.printf("receiving %.1f damage!\nHealth is now %.1f", dmg, finalHealth);
            }
        }
    }
    
    public static void poison(Monster target) {
        if (target.getStatusCondition() != null) {
            if (target.getStatusCondition().equals(POISON)) {
                System.out.printf("%s is poisoned!", target.getName());
                double dmg = Math.floor((double) target.getStats().getHealth()/16);
                Double finalHealth = (target.getCurStats().getHealth() - dmg) < 0 ? 0 : (target.getCurStats().getHealth() - dmg);
                target.getCurStats().setHealth(finalHealth);
                System.out.printf("receiving %.1f damage!\nHealth is now %.1f", dmg, finalHealth);
            }
        }
    }

    public static void sleep(Monster target) {
        if (target.getStatusCondition() != null) {
            if (target.getStatusCondition().equals(SLEEP)) {
                if (target.getCurStats().getSkipTurn() > 0) {
                    if (target.getCurStats().getSkipTurn() == 1) {
                        target.getCurStats().decreaseSkipTurn();
                        relief(target);
                        System.out.printf("%s is no longer afflicted by SLEEP\n", target.getName());
                    }
                    else {
                        System.out.printf("%s is still sleeping...\n", target.getName());
                        target.getCurStats().decreaseSkipTurn();
                    }
                }
            }
        }
    }

    public static void paralyze(Monster target) {
        if (target.getStatusCondition() != null) {
            if (target.getStatusCondition().equals(PARALYZE)) {
                System.out.printf("%s is paralyzed...\n", target.getName());
                if (target.getCurStats().getSkipTurn() == 1) {
                    target.getCurStats().decreaseSkipTurn();
                }
            }
        }
    }
}
