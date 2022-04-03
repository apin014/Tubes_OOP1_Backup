/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes_OOP_1;

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

    enum Target {
        ENEMY, OWN;
    }
    
    public Move(int id, MoveType moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, Target target) {
        this.id  = id;
        this.moveType = moveType;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.target = target;
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

    public abstract void makeAMove(Monster source, Monster target);
}
