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
public class NonStatusMove extends Move implements Actionable {
    private Double basePower;
    
    public NonStatusMove(int id, MoveType moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, Target target, Double basePower) {
        super(id, moveType, name, elementType, accuracy, priority, ammunition, target);
        this.basePower = basePower;
    }
    
    public Double getBasePower() {
        return this.basePower;
    }
    
    @Override
    public void normalMove(Monster source, Monster target) {
        Double rawDmg = (this.getBasePower() * (double) (source.getCurStats().getAttack()/target.getCurStats().getDefense()) + 2) * (0.85 + (1 - 0.85 * (new Random().nextDouble())));
        Double dmg = (source.getStatusCondition().equals(StatusCondition.BURN)) ? (Math.floor(rawDmg)/2):(Math.floor(rawDmg));
        target.getCurStats().setHealth(target.getCurStats().getHealth() - dmg);
    }

    @Override
    public void specialMove(Monster source, Monster target) {
        Double rawDmg = (this.getBasePower() * (double) (source.getCurStats().getSpecialAttack()/target.getCurStats().getSpecialDefense()) + 2) * (0.85 + (1 - 0.85 * (new Random().nextDouble())));
        Double dmg = (source.getStatusCondition().equals(StatusCondition.BURN)) ? (Math.floor(rawDmg)/2):(Math.floor(rawDmg));
        target.getCurStats().setHealth(target.getCurStats().getHealth() - dmg);
    }

    @Override
    public void defaultMove(Monster source, Monster target) {
        normalMove(source, target);
        Double dmg = Math.floor((double) source.getStats().getHealth()/4);
        source.getCurStats().setHealth(source.getCurStats().getHealth() - dmg);
    }

    @Override
    public void makeAMove(Monster source, Monster target) {
        if (this.getMoveType().equals(MoveType.NORMAL)) {
            normalMove(source, target);
        } else if (this.getMoveType().equals(MoveType.SPECIAL)) {
            specialMove(source, target);
        }
    }
}
