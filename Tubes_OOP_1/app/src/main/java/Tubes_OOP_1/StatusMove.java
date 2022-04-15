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

    public StatusMove (StatusMove move) {
        super(move);
        this.statusCond = (move.statusCond != null) ? StatusCondition.parse(move.statusCond.toString()) : null;
        this.statsEffects = new Double[move.statsEffects.length];
        for (int i = 0; i < move.statsEffects.length; i++) {
            this.statsEffects[i] = move.statsEffects[i].doubleValue();
        }
    }

    public StatusCondition getStatusCondition() {
        return this.statusCond;
    }

    public Double[] getStatsEffects() {
        return this.statsEffects;
    }

    @Override
    public void makeAMove(Trainer  source, Trainer target) {
        if (this.getTarget().equals(Target.OWN)) {
            target = source;
        }
        if (source.getCurMonster().getCurStats().getSkipTurn() <= 0) {
            boolean success = new SplittableRandom().nextInt(1, 101) <= this.getAccuracy();
            if (success) {
                System.out.printf("%s's %s successfully pulled off the %s move!\n", source.getName(), source.getCurMonster().getName(), this.getName());
                if (this.getStatusCondition() != null) {
                    if (this.getStatusCondition().equals(StatusCondition.BURN)) {
                        StatusCondition.afflict(target.getCurMonster(), StatusCondition.BURN);
                    } else if (this.getStatusCondition().equals(StatusCondition.POISON)) {
                        StatusCondition.afflict(target.getCurMonster(), StatusCondition.POISON);
                    } else if (this.getStatusCondition().equals(StatusCondition.SLEEP)) {
                        StatusCondition.afflict(target.getCurMonster(), StatusCondition.SLEEP);
                    } else if (this.getStatusCondition().equals(StatusCondition.PARALYZE)) {
                        StatusCondition.afflict(target.getCurMonster(), StatusCondition.PARALYZE);
                    } 
                } else {
                    target.getCurMonster().getCurStats().setHealth(target.getCurMonster().getStats().getHealth() * (1 + ((double) this.statsEffects[0]/100)));
                    target.getCurMonster().getCurStats().setAttack(target.getCurMonster().getCurStats().getAttack() + this.statsEffects[1]);
                    target.getCurMonster().getCurStats().setDefense(target.getCurMonster().getCurStats().getDefense() + this.statsEffects[2]);
                    target.getCurMonster().getCurStats().setSpecialAttack(target.getCurMonster().getCurStats().getSpecialAttack() + this.statsEffects[3]);
                    target.getCurMonster().getCurStats().setSpecialDefense(target.getCurMonster().getCurStats().getSpecialDefense() + this.statsEffects[4]);
                    target.getCurMonster().getCurStats().setSpeed(target.getCurMonster().getCurStats().getSpeed() + this.statsEffects[5]);
                }
            }
            else {
                System.out.printf("%s's %s didn't manage to pull off the %s move...\n", source.getName(), source.getCurMonster().getName(), this.getName());
            }
        }
        else {
            System.out.printf("%s's %s is is unable to move for some reason\n", source.getName(), source.getCurMonster().getName());
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
