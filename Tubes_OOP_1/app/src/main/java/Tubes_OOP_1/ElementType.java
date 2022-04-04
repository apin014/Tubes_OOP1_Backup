/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes_OOP_1;

/**
 *
 * @author Davin
 */
public enum ElementType {
    NORMAL,
    FIGHTING,
    FIRE,
    GRASS,
    WATER,
    ELECTRICITY,
    ICE,
    DRAGON;

    public static ElementType parse(String element) {
        if (element.equals("NORMAL")) {
            return NORMAL;
        } else if (element.equals("FIGHTING")) {
            return FIGHTING;
        } else if (element.equals("FIRE")) {
            return FIRE;
        } else if (element.equals("GRASS")) {
            return GRASS;
        } else if (element.equals("WATER")) {
            return WATER;
        } else if (element.equals("ELECTRICITY")) {
            return ELECTRICITY;
        } else if (element.equals("ICE")) {
            return ICE;
        } else if (element.equals("DRAGON")) {
            return DRAGON;
        } else {
            return null;
        }
    }
}
