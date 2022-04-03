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
