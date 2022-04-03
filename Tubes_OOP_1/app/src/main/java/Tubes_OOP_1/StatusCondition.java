package Tubes_OOP_1;

public enum StatusCondition {
    BURN, 
    POISON, 
    SLEEP, 
    PARALYZE;

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
