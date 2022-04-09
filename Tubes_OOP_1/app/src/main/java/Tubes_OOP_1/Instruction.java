package Tubes_OOP_1;
import java.util.*;

public enum Instruction {
    MOVE, SWITCH;

    public boolean isMove(Instruction i) {
        return i.equals(MOVE);
    }

    public boolean isSwitch(Instruction i) {
        return i.equals(SWITCH);
    }
}
