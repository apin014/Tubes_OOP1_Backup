package Tubes_OOP_1;

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
        } else {
            if (target.getStatusCondition().equals(affliction)) {
                System.out.println("Cannot afflict target with " + affliction + ": Target already afflicted with the same status condition");
            } else {
                System.out.println("Cannot afflict target with " + affliction + ": Target already afflicted with a different status condition");
            }
        }
    }

    public static void burn(Monster target) {
        double dmg = Math.floor((double) target.getStats().getHealth()/8);
        target.getCurStats().setHealth(target.getCurStats().getHealth() - dmg);
    }
    
    public static void poison(Monster target) {
        double dmg = Math.floor((double) target.getStats().getHealth()/16);
        target.getCurStats().setHealth(target.getCurStats().getHealth() - dmg);
    }

    public static void sleep(Monster target) {/* belum kepikiran*/ }

    public static void paralyze(Monster target) {/* Belum kepikiran juga */}
}
