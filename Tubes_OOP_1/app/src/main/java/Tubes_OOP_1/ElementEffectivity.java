package Tubes_OOP_1;
import java.util.HashMap;
import java.util.List;

public class ElementEffectivity {
    public static HashMap<ElementType, Double> fromNormal, fromFighting, fromFire, fromGrass, fromWater, fromElectric, fromIce, fromDragon, fromFlying, fromPoison, fromGround, fromRock, fromBug, fromGhost, fromSteel, fromPsychic, fromDark;
    public static void pool(List<String[]> config) {
        fromNormal = new HashMap<>();
        fromFighting = new HashMap<>();
        fromFire = new HashMap<>();
        fromGrass = new HashMap<>();
        fromWater = new HashMap<>();
        fromElectric = new HashMap<>();
        fromIce = new HashMap<>();
        fromDragon = new HashMap<>();
        fromFlying = new HashMap<>();
        fromPoison = new HashMap<>();
        fromGround = new HashMap<>();
        fromRock = new HashMap<>();
        fromBug = new HashMap<>();
        fromGhost = new HashMap<>();
        fromSteel = new HashMap<>();
        fromPsychic = new HashMap<>();
        fromDark = new HashMap<>();
        for (String[] row : config) {
            if (row[0].equals("NORMAL")) {
                fromNormal.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("FIGHTING")) {
                fromFighting.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("FIRE")) {
                fromFire.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("GRASS")) {
                fromGrass.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("WATER")) {
                fromWater.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("ELECTRIC")) {
                fromElectric.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("ICE")) {
                fromIce.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("DRAGON")) {
                fromDragon.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("FLYING")) {
                fromFlying.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("POISON")) {
                fromPoison.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("GROUND")) {
                fromGround.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("ROCK")) {
                fromRock.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("BUG")) {
                fromBug.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("GHOST")) {
                fromGhost.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("STEEL")) {
                fromSteel.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("PSYCHIC")) {
                fromPsychic.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            } else if (row[0].equals("DARK")) {
                fromDark.put(ElementType.parse(row[1]), Double.parseDouble(row[2]));
            }
        }
    }
    public static Double getEffectivity(ElementType attElmt, ElementType rcvElmt) {
        if (attElmt.equals(ElementType.NORMAL)) {
            return fromNormal.get(rcvElmt);
        } else if (attElmt.equals(ElementType.FIGHTING)) {
            return fromFighting.get(rcvElmt);
        } else if (attElmt.equals(ElementType.FIRE)) {
            return fromFire.get(rcvElmt);
        } else if (attElmt.equals(ElementType.GRASS)) {
            return fromGrass.get(rcvElmt);
        } else if (attElmt.equals(ElementType.WATER)) {
            return fromWater.get(rcvElmt);
        } else if (attElmt.equals(ElementType.ELECTRIC)) {
            return fromElectric.get(rcvElmt);
        } else if (attElmt.equals(ElementType.ICE)) {
            return fromIce.get(rcvElmt);
        } else if (attElmt.equals(ElementType.DRAGON)) {
            return fromDragon.get(rcvElmt);
        } else if (attElmt.equals(ElementType.FLYING)) {
            return fromFlying.get(rcvElmt);
        } else if (attElmt.equals(ElementType.POISON)) {
            return fromPoison.get(rcvElmt);
        } else if (attElmt.equals(ElementType.GROUND)) {
            return fromGround.get(rcvElmt);
        } else if (attElmt.equals(ElementType.ROCK)) {
            return fromRock.get(rcvElmt);
        } else if (attElmt.equals(ElementType.BUG)) {
            return fromBug.get(rcvElmt);
        } else if (attElmt.equals(ElementType.GHOST)) {
            return fromGhost.get(rcvElmt);
        } else if (attElmt.equals(ElementType.STEEL)) {
            return fromSteel.get(rcvElmt);
        } else if (attElmt.equals(ElementType.PSYCHIC))  {
            return fromPsychic.get(rcvElmt);
        } else if (attElmt.equals(ElementType.DARK)) {
            return fromDark.get(rcvElmt);
        } else {
            return (double) 1;
        }
    }

    public static boolean poolEmpty() {
        return (fromNormal.isEmpty() && fromFighting.isEmpty() && fromFire.isEmpty() && fromGrass.isEmpty() && fromWater.isEmpty() && fromElectric.isEmpty() && fromIce.isEmpty() && fromDragon.isEmpty());
    }
}
