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
        double elemEff = 1;
        for (ElementType elem : target.getElementTypes()) {
            elemEff = elemEff * (double) ElementEffectivity.getEffectivity(this.getElementType(), elem);
        }
        Double rawDmg = (this.getBasePower() * (double) (source.getCurStats().getAttack()/target.getCurStats().getDefense()) + 2) * (0.85 + (1 - 0.85 * (new Random().nextDouble()))) * elemEff;
        Double dmg;
        if (source.getStatusCondition() != null)  dmg = (source.getStatusCondition().equals(StatusCondition.BURN)) ? (Math.floor(rawDmg)/2):(Math.floor(rawDmg));
        else dmg = (Math.floor(rawDmg));
        Double finalHealth = (target.getCurStats().getHealth() - dmg) < 0 ? 0 : (target.getCurStats().getHealth() - dmg);
        target.getCurStats().setHealth(finalHealth);
        System.out.printf("Dealing %.1f damage!\nThe opponent's %s's health is now: %.1f\n", dmg, target.getName(), finalHealth);
    }

    @Override
    public void specialMove(Monster source, Monster target) {
        double elemEff = 1;
        for (ElementType elem : target.getElementTypes()) {
            elemEff = elemEff * (double) ElementEffectivity.getEffectivity(this.getElementType(), elem);
        }
        Double rawDmg = (this.getBasePower() * (double) (source.getCurStats().getSpecialAttack()/target.getCurStats().getSpecialDefense()) + 2) * (0.85 + (1 - 0.85 * (new Random().nextDouble()))) * elemEff;
        Double dmg;
        if (source.getStatusCondition() != null)  dmg = (source.getStatusCondition().equals(StatusCondition.BURN)) ? (Math.floor(rawDmg)/2):(Math.floor(rawDmg));
        else dmg = (Math.floor(rawDmg));
        Double finalHealth = (target.getCurStats().getHealth() - dmg) < 0 ? 0 : (target.getCurStats().getHealth() - dmg);
        target.getCurStats().setHealth(finalHealth);
        System.out.printf("Dealing %.1f damage!\nThe opponent's %s health is now: %.1f\n", dmg, target.getName(), finalHealth);
    }

    @Override
    public void defaultMove(Monster source, Monster target) {
        normalMove(source, target);
        Double selfDmg = Math.floor((double) source.getStats().getHealth()/4);
        Double selfFinalHealth = (source.getCurStats().getHealth() - selfDmg) < 0 ? 0 : (source.getCurStats().getHealth() - selfDmg);
        source.getCurStats().setHealth(selfFinalHealth);
        System.out.printf("Your %s deals %.1f damage to self!\nIts health is now: %.1f\n", source.getName(), selfDmg, selfFinalHealth);
    }

    @Override
    public void makeAMove(Trainer sourceMaster, Monster source, Monster target) {
        if (this.getTarget().equals(Target.OWN)) {
            target = source;
        }
        boolean success = new SplittableRandom().nextInt(1, 101) <= this.getAccuracy();
        if (success) {
            System.out.printf("%s's %s successfully pulled off the %s move!\n", sourceMaster.getName(), source.getName(), this.getName());
            if (!this.getName().equals("Default")) {
                if (this.getMoveType().equals(MoveType.NORMAL)) {
                    normalMove(source, target);
                } else if (this.getMoveType().equals(MoveType.SPECIAL)) {
                    specialMove(source, target);
                }
                this.decreaseAmmo();
            } else {
                defaultMove(source, target);
            }
        }
        else {
            System.out.printf("%s's %s didn't manage to pull off the %s move...\n", sourceMaster.getName(), source.getName(), this.getName());
        }
    }
    
    @Override
    public void printMove() {
        System.out.printf("%s (%d left) | Type: %s | Element: %s | Accuracy: %d | Priority: %d | Target: %s | Base Power: %.1f\n", this.getName(), this.getAmmunition(), this.getMoveType().name(), this.getElementType().name(), this.getAccuracy(), this.getPriority(), this.getTarget().name(), this.getBasePower());
    }
}
