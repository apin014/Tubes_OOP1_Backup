/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tubes_OOP_1;

/**
 *
 * @author Davin
 */
public class Stats {
    private Double healthPoint, attack, defense, specialAttack, specialDefense, speed;
    
    public Stats(Double healthPoint, Double attack, Double defense, Double specialAttack, Double specialDefense, Double speed) {
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }
    
    public Double getHealth() {
        return this.healthPoint;
    }
    
    public void setHealth(Double healthPoint) {
        this.healthPoint = healthPoint;
    }
    
    public Double getAttack() {
        return this.attack;
    }
    
    public void setAttack(Double attack) {
        this.attack = attack;
    }
    
    public Double getDefense() {
        return this.defense;
    }
    
    public void setDefense(Double defense) {
        this.defense = defense;
    }
    
    public Double getSpecialAttack() {
        return this.specialAttack;
    }
    
    public void setSpecialAttack(Double specialAttack) {
        this.specialAttack = specialAttack;
    }
    
    public Double getSpecialDefense() {
        return this.specialDefense;
    }
    
    public void setSpecialDefense(Double specialDefense) {
        this.specialDefense = specialDefense;
    }
    
    public Double getSpeed() {
        return this.speed;
    }
    
    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}