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

    public Monster(String[] config) {
        this.name = config[1];
        this.elementTypes = new ArrayList<>();
        for (String s : config[2].split(",")) {
            this.elementTypes.add(ElementType.parse(s));
        }
        String[] stats = config[3].split(",");
        Double[] statsReal = new Double[6];
        for (int i = 0; i < 6; i++) {
            statsReal[i] = Double.parseDouble(stats[i]);
        }
        this.baseStats = new Stats(statsReal[0], statsReal[1], statsReal[2], statsReal[3], statsReal[4], statsReal[5]);
        this.curStats = new Stats(statsReal[0], statsReal[1], statsReal[2], statsReal[3], statsReal[4], statsReal[5]);
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
}
