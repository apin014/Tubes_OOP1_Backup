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
    ELECTRIC,
    ICE,
    DRAGON,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    PSYCHIC,
    DARK;

    public static ElementType parse(String element) {
        return ElementType.valueOf(element);
    }
}
