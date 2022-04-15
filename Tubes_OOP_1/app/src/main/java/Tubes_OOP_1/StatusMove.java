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
                    Double healthIncrease = Math.floor(target.getCurMonster().getStats().getHealth() * ((double) this.statsEffects[0]/100));
                    Double health = (target.getCurMonster().getCurStats().getHealth() + healthIncrease) <= target.getCurMonster().getStats().getHealth() ? target.getCurMonster().getCurStats().getHealth() + healthIncrease : target.getCurMonster().getStats().getHealth();
                    target.getCurMonster().getCurStats().setHealth(health);
                    target.getCurMonster().getCurStats().setAttack(Math.floor(target.getCurMonster().getCurStats().getAttack() * Stats.convertToBuff(this.statsEffects[1])));
                    target.getCurMonster().getCurStats().setDefense(Math.floor(target.getCurMonster().getCurStats().getDefense() * Stats.convertToBuff(this.statsEffects[2])));
                    target.getCurMonster().getCurStats().setSpecialAttack(Math.floor(target.getCurMonster().getCurStats().getSpecialAttack() * Stats.convertToBuff(this.statsEffects[3])));
                    target.getCurMonster().getCurStats().setSpecialDefense(Math.floor(target.getCurMonster().getCurStats().getSpecialDefense() * Stats.convertToBuff(this.statsEffects[4])));
                    target.getCurMonster().getCurStats().setSpeed(Math.floor(target.getCurMonster().getCurStats().getSpeed() * Stats.convertToBuff(this.statsEffects[5])));
                    if (target.equals(source)) {
                        if (healthIncrease > 0) {
                            System.out.printf("Your %s's health is restored by %.1f, its health is now %.1f\n", target.getCurMonster().getName(), healthIncrease, target.getCurMonster().getCurStats().getHealth());
                        }
                        if (Stats.convertToBuff(this.statsEffects[1]) > 1) {
                            System.out.printf("Your %s's attack is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[1]));
                        } else if (Stats.convertToBuff(this.statsEffects[1]) < 1) {
                            System.out.printf("Your %s's attack is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[1]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[2]) > 1) {
                            System.out.printf("Your %s's defense is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[2]));
                        } else if (Stats.convertToBuff(this.statsEffects[2]) < 1) {
                            System.out.printf("Your %s's defense is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[2]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[3]) > 1) {
                            System.out.printf("Your %s's special attack is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[3]));
                        } else if (Stats.convertToBuff(this.statsEffects[3]) < 1) {
                            System.out.printf("Your %s's special attack is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[3]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[4]) > 1) {
                            System.out.printf("Your %s's special defense is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[4]));
                        } else if (Stats.convertToBuff(this.statsEffects[4]) < 1) {
                            System.out.printf("Your %s's special defense is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[4]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[5]) > 1) {
                            System.out.printf("Your %s's speed is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[5]));
                        } else if (Stats.convertToBuff(this.statsEffects[5]) < 1) {
                            System.out.printf("Your %s's speed is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[5]));
                        }
                    } else {
                        if (healthIncrease > 0) {
                            System.out.printf("Opponent's %s's health is restored by %.1f, its health is now %.1f\n", target.getCurMonster().getName(), healthIncrease, target.getCurMonster().getCurStats().getHealth());
                        }
                        if (Stats.convertToBuff(this.statsEffects[1]) > 1) {
                            System.out.printf("Opponent's %s's attack is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[1]));
                        } else if (Stats.convertToBuff(this.statsEffects[1]) < 1) {
                            System.out.printf("Opponent's %s's attack is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[1]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[2]) > 1) {
                            System.out.printf("Opponent's %s's defense is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[2]));
                        } else if (Stats.convertToBuff(this.statsEffects[2]) < 1) {
                            System.out.printf("Opponent's %s's defense is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[2]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[3]) > 1) {
                            System.out.printf("Opponent's %s's special attack is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[3]));
                        } else if (Stats.convertToBuff(this.statsEffects[3]) < 1) {
                            System.out.printf("Opponent's %s's special attack is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[3]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[4]) > 1) {
                            System.out.printf("Opponent's %s's special defense is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[4]));
                        } else if (Stats.convertToBuff(this.statsEffects[4]) < 1) {
                            System.out.printf("Opponent's %s's special defense is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[4]));
                        }
                        if (Stats.convertToBuff(this.statsEffects[5]) > 1) {
                            System.out.printf("Opponent's %s's speed is increased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[5]));
                        } else if (Stats.convertToBuff(this.statsEffects[5]) < 1) {
                            System.out.printf("Opponent's %s's speed is decreased by %.1f\n", target.getCurMonster().getName(), Stats.convertToBuff(this.statsEffects[5]));
                        }
                    }
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
            System.out.printf("%s (%d left) | Type: %s | Element: %s | Accuracy: %d | Priority: %d | Target: %s | Stats Effects: <Health: +%.1f of Max HP> <Attack: *%.1f> <Defense: *%.1f> <Special Attack: *%.1f> <Special Defense: *%.1f> <Speed: *%.1f>\n", this.getName(), this.getAmmunition(), this.getMoveType().name(), this.getElementType().name(), this.getAccuracy(), this.getPriority(), this.getTarget().name(), (double) this.statsEffects[0]/100, Stats.convertToBuff(this.statsEffects[1]), Stats.convertToBuff(this.statsEffects[2]), Stats.convertToBuff(this.statsEffects[3]), Stats.convertToBuff(this.statsEffects[4]), Stats.convertToBuff(this.statsEffects[5]));
        }
        else {
            System.out.printf("%s (%d left) | Type: %s | Element: %s | Accuracy: %d | Priority: %d | Target: %s | Status Condition: %s\n", this.getName(), this.getAmmunition(), this.getMoveType().name(), this.getElementType().name(), this.getAccuracy(), this.getPriority(), this.getTarget().name(), this.getStatusCondition().name());
        }
    }
}