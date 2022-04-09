package Tubes_OOP_1;

public enum MoveType {
    NORMAL, SPECIAL, STATUS;

    public static MoveType parse(String s) {
        if (s.equals("NORMAL")) {
            return NORMAL;
        } else if (s.equals("SPECIAL")) {
            return SPECIAL;
        } else if (s.equals("STATUS")) {
            return STATUS;
        } else {
            return null;
        }
    }
}
