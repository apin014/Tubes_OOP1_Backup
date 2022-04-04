package Tubes_OOP_1;

public enum StatusCondition {
    BURN, 
    POISON, 
    SLEEP, 
    PARALYZE;

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
