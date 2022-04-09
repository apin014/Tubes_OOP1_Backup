package Tubes_OOP_1;
import java.util.*;

public class Trainer {
    private String name;
    private List<Monster> monsters;

    public Trainer(String name) {
        this.name = name;
        this.monsters = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            this.monsters.add(Monster.getFromPool(new Random().nextInt(Monster.getPoolSize()-1) + 1));
        }
    }
}
