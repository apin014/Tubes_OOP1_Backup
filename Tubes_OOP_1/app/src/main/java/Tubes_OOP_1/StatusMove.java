package Tubes_OOP_1;

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
    public void makeAMove(Monster source, Monster target) {
        if (this.getTarget().equals(Target.OWN)) {
            target = source;
        }
        if (this.getStatusCondition().equals(StatusCondition.BURN)) {
            StatusCondition.afflict(target, StatusCondition.BURN);
        } else if (this.getStatusCondition().equals(StatusCondition.POISON)) {
            StatusCondition.afflict(target, StatusCondition.POISON);
        } else if (this.getStatusCondition().equals(StatusCondition.SLEEP)) {
            StatusCondition.afflict(target, StatusCondition.SLEEP);
        } else if (this.getStatusCondition().equals(StatusCondition.PARALYZE)) {
            StatusCondition.afflict(target, StatusCondition.PARALYZE);
        } else {
            target.getCurStats().setHealth(target.getStats().getHealth() * (1 + this.statsEffects[0]));
            target.getCurStats().setAttack(target.getCurStats().getAttack() + this.statsEffects[1]);
            target.getCurStats().setDefense(target.getCurStats().getDefense() + this.statsEffects[2]);
            target.getCurStats().setSpecialAttack(target.getCurStats().getSpecialAttack() + this.statsEffects[3]);
            target.getCurStats().setSpecialDefense(target.getCurStats().getSpecialDefense() + this.statsEffects[4]);
            target.getCurStats().setSpeed(target.getCurStats().getSpeed() + this.statsEffects[5]);
        }
    }
}
