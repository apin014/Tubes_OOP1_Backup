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
public class Monster {
    private String name;
    private List<ElementType> elementTypes;
    private Stats baseStats;
    private Stats curStats;
    private List<Move> moves;
    private StatusCondition statusCond;
    private static List<Monster> monsterPool;
    static {
        Monster.monsterPool = new ArrayList<>();
    }

    public Monster(String[] array) {
        this.name = array[1];
        this.elementTypes = new ArrayList<>();
        for (String element : array[2].split(",")) {
            this.elementTypes.add(ElementType.parse(element));
        }
        String[] stats = array[3].split(",");
        Double[] statsReal = Stats.parseStringArray(stats);
        this.baseStats = new Stats(statsReal[0], statsReal[1], statsReal[2], statsReal[3], statsReal[4], statsReal[5]);
        this.curStats = new Stats(statsReal[0], statsReal[1], statsReal[2], statsReal[3], statsReal[4], statsReal[5]);
        this.moves = new ArrayList<>();
        this.moves.add(Move.getFromPool(0));
        for (String move : array[4].split(",")) {
            int id = Integer.parseInt(move);
            this.moves.add(Move.getFromPool(id));
        }
    }

    public static void pool(List<String[]> config) {
        Monster.monsterPool.add(null);
        for (String[] array : config) {
            Monster.monsterPool.add(new Monster(array));
        }
    }

    public String getName() {
        return this.name;
    }

    public Stats getStats() {
        return this.baseStats;
    }

    public Stats getCurStats() {
        return this.curStats;
    }

    public List<ElementType> getElementTypes() {
        return this.elementTypes;
    }

    public List<Move> getMoves() {
        return this.moves;
    }

    public StatusCondition getStatusCondition() {
        return this.statusCond;
    }

    public void setStatusCondition(StatusCondition statusCond) {
        this.statusCond = statusCond;
    }

    public static boolean poolEmpty() {
        return (Monster.monsterPool.isEmpty());
    }
    public static Monster getFromPool(int id) {
        return Monster.monsterPool.get(id);
    }

    public static int getPoolSize() {
        return Monster.monsterPool.size();
    }
}
