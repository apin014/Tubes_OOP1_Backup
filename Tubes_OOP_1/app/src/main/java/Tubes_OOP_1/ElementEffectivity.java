package Tubes_OOP_1;
import java.util.HashMap;
import java.util.List;

public class ElementEffectivity {
    public static HashMap<ElementType, Double> fromNormal, fromFighting, fromFire, fromGrass, fromWater, fromElectric, fromIce, fromDragon;
    public static void pool(List<String[]> config) {
        fromNormal = new HashMap<>();
        fromFighting = new HashMap<>();
        fromFire = new HashMap<>();
        fromGrass = new HashMap<>();
        fromWater = new HashMap<>();
        fromElectric = new HashMap<>();
        fromIce = new HashMap<>();
        fromDragon = new HashMap<>();
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
        } else {
            return null;
        }
    }

    public static boolean poolEmpty() {
        return (fromNormal.isEmpty() && fromFighting.isEmpty() && fromFire.isEmpty() && fromGrass.isEmpty() && fromWater.isEmpty() && fromElectric.isEmpty() && fromIce.isEmpty() && fromDragon.isEmpty());
    }
}
