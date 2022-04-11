package Tubes_OOP_1;

import java.util.SplittableRandom;

public class StatusMove extends Move {
    private StatusCondition statusCond;
    private Double[] statsEffects;
    
    public StatusMove(int id, MoveType moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, Target target, StatusCondition statusCond, Double[] statsEffects) {
        super(id, moveType, name, elementType, accuracy, priority, ammunition, target);
        this.statusCond = statusCond;
        this.statsEffects = statsEffects;
    }

    public StatusCondition getStatusCondition() {
        return this.statusCond;
    }

    public Double[] getStatsEffects() {
        return this.statsEffects;
    }

    @Override
    public void makeAMove(Trainer sourceMaster, Monster source, Monster target) {
        if (this.getTarget().equals(Target.OWN)) {
            target = source;
        }
        boolean success = new SplittableRandom().nextInt(1, 101) <= this.getAccuracy();
        if (success) {
            System.out.printf("%s's %s successfully pulled off the %s move!\n", sourceMaster.getName(), source.getName(), this.getName());
            if (this.getStatusCondition() != null) {
                if (this.getStatusCondition().equals(StatusCondition.BURN)) {
                    StatusCondition.afflict(target, StatusCondition.BURN);
                } else if (this.getStatusCondition().equals(StatusCondition.POISON)) {
                    StatusCondition.afflict(target, StatusCondition.POISON);
                } else if (this.getStatusCondition().equals(StatusCondition.SLEEP)) {
                    StatusCondition.afflict(target, StatusCondition.SLEEP);
                } else if (this.getStatusCondition().equals(StatusCondition.PARALYZE)) {
                    StatusCondition.afflict(target, StatusCondition.PARALYZE);
                } 
            } else {
                target.getCurStats().setHealth(target.getStats().getHealth() * (1 + this.statsEffects[0]));
                target.getCurStats().setAttack(target.getCurStats().getAttack() + this.statsEffects[1]);
                target.getCurStats().setDefense(target.getCurStats().getDefense() + this.statsEffects[2]);
                target.getCurStats().setSpecialAttack(target.getCurStats().getSpecialAttack() + this.statsEffects[3]);
                target.getCurStats().setSpecialDefense(target.getCurStats().getSpecialDefense() + this.statsEffects[4]);
                target.getCurStats().setSpeed(target.getCurStats().getSpeed() + this.statsEffects[5]);
            }
        }
        else {
            System.out.printf("%s's %s didn't manage to pull off the %s move...\n", sourceMaster.getName(), source.getName(), this.getName());
        }
    }

    @Override
    public void printMove() {
        if (this.statusCond == null) {
            System.out.printf("%s (%d left) | Type: %s | Element: %s | Accuracy: %d | Priority: %d | Target: %s | Status Condition: -\n", this.getName(), this.getAmmunition(), this.getMoveType().name(), this.getElementType().name(), this.getAccuracy(), this.getPriority(), this.getTarget().name());
        }
        else {
            System.out.printf("%s (%d left) | Type: %s | Element: %s | Accuracy: %d | Priority: %d | Target: %s | Status Condition: %s\n", this.getName(), this.getAmmunition(), this.getMoveType().name(), this.getElementType().name(), this.getAccuracy(), this.getPriority(), this.getTarget().name(), this.getStatusCondition().name());
        }
    }
}
