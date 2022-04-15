/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes_OOP_1;
import java.util.*;

/**
 *
 * @author Davin
 */
public abstract class Move {
    private int id;
    private MoveType moveType;
    private String name;
    private ElementType elementType;
    private Integer accuracy, priority, ammunition;
    private Target target;

    private static List<Move> movePool;
    static {
        Move.movePool = new ArrayList<>();
        Move def = new NonStatusMove(0, MoveType.NORMAL, "Default", ElementType.NORMAL, 100, 0, Integer.MAX_VALUE, Target.ENEMY, 50.0);
        movePool.add(def);
    }

    protected enum Target {
        ENEMY, OWN;

        protected static Target parse(String s) {
            if (s.equals("ENEMY")) {
                return ENEMY;
            } else if (s.equals("OWN")) {
                return OWN;
            } else {
                return null;
            }
        }
    }
    
    public Move(int id, MoveType moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, Target target) {
        this.id = id;
        this.moveType = moveType;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.target = target;
    }

    public Move (Move move) {
        this.id = move.id;
        this.moveType = MoveType.parse(move.moveType.toString());
        this.name = move.name;
        this.elementType = ElementType.parse(move.elementType.toString());
        this.accuracy = move.accuracy.intValue();
        this.priority = move.priority.intValue();
        this.ammunition = move.ammunition.intValue();
        this.target = move.target;
    }

    public static void pool(List<String[]> config) {
        for (String[] array : config) {
            int id = Integer.parseInt(array[0]);
            MoveType moveType = MoveType.parse(array[1]);
            String name = array[2];
            ElementType elementType = ElementType.parse(array[3]);
            Integer accuracy = Integer.parseInt(array[4]);
            Integer priority = Integer.parseInt(array[5]);
            Integer ammunition = Integer.parseInt(array[6]);
            Target target = Target.parse(array[7]);
            if (moveType.equals(MoveType.STATUS)) {
                StatusCondition statusCondition = StatusCondition.parse(array[8]);
                String[] statsEffects = array[9].split(",");
                Double[] realStatsEffects = Stats.parseStringArray(statsEffects);
                Move.movePool.add(new StatusMove(id, moveType, name, elementType, accuracy, priority, ammunition, target, statusCondition, realStatsEffects));
            } else {
                Double basePower = Double.parseDouble(array[8]);
                Move.movePool.add(new NonStatusMove(id, moveType, name, elementType, accuracy, priority, ammunition, target, basePower));
            }
        }
    }

    public int getId() {
        return this.id;
    }

    public MoveType getMoveType() {
        return this.moveType;
    }

    public String getName() {
        return this.name;
    }

    public ElementType getElementType() {
        return this.elementType;
    }

    public Integer getAccuracy() {
        return this.accuracy;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public Integer getAmmunition() {
        return this.ammunition;
    }

    public Target getTarget() {
        return this.target;
    }

    public void decreaseAmmo() {
        this.ammunition--;
    }

    public static boolean poolEmpty() {
        return (Move.movePool.isEmpty());
    }

    public static Move getFromPool(int id) {
        return Move.movePool.get(id);
    }

    public abstract void makeAMove(Trainer  source, Trainer target);
    public abstract void printMove();
}
