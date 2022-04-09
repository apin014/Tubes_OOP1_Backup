package Tubes_OOP_1;
import java.util.*;

public class Trainer {
    private String name;
    private List<Monster> monsters;
    private Monster curMonster;

    public Trainer(String name) {
        this.name = name;
        this.monsters = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            this.monsters.add(Monster.getFromPool(new Random().nextInt(Monster.getPoolSize()-1) + 1));
        }
        this.curMonster = monsters.get(0);
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

    public void switchMonster(int localMonsterId) {
        System.out.printf("%s switched %s with %s\n", this.getName(), this.getCurMonster().getName(), this.getMonsters().get(localMonsterId));
        this.curMonster = this.getMonsters().get(localMonsterId);
    }
}
