package Tubes_OOP_1;
import java.util.*;

public class Trainer {
    private String name;
    private List<Monster> monsters;
    private Monster curMonster;
    private int playerMove, playerSwitch;

    public Trainer(String name) {
        this.name = name;
        this.monsters = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            this.monsters.add(Monster.getFromPool(new SplittableRandom().nextInt(1, Monster.getPoolSize())));
        }
        this.curMonster = monsters.remove(0);
        this.playerMove = -1;
        this.playerSwitch = -1;
    }

    public String getName() {
        return this.name;
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    public Monster getCurMonster() {
        return this.curMonster;
    }

    public int getMove() {
        return this.playerMove;
    }

    public void setMove(int playerMove) {
        this.playerMove = playerMove;
    }

    public int getSwitch() {
        return this.playerSwitch;
    }

    public void setSwitch(int playerSwitch) {
        this.playerSwitch = playerSwitch;
    }

    public void switchMonster(int localMonsterId) {
        System.out.printf("%s switched %s with %s\n", this.getName(), this.getCurMonster().getName(), this.getMonsters().get(localMonsterId).getName());
        this.getMonsters().add(this.getCurMonster());
        this.curMonster = this.getMonsters().remove(localMonsterId);
    }
}
