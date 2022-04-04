package Tubes_OOP_1;
import java.util.HashMap;
import java.util.List;

public class ElementEffectivity {
    public static HashMap<ElementType, Integer> fromNormal, fromFighting, fromFire, fromGrass, fromWater, fromElectricity, fromIce, fromDragon;
    public static void add(List<String[]> config) {
        for (String[] row : config) {
            if (row[0].equals("NORMAL")) {
                fromNormal.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            } else if (row[0].equals("FIGHTING")) {
                fromFighting.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            } else if (row[0].equals("FIRE")) {
                fromFire.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            } else if (row[0].equals("GRASS")) {
                fromGrass.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            } else if (row[0].equals("WATER")) {
                fromWater.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            } else if (row[0].equals("ELECTRICITY")) {
                fromElectricity.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            } else if (row[0].equals("ICE")) {
                fromIce.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            } else if (row[0].equals("DRAGON")) {
                fromDragon.put(ElementType.parse(row[1]), Integer.parseInt(row[2]));
            }
        }
    }
    
}
