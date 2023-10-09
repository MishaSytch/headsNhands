package com.task.models;


public class Monstor extends Creature {

    public Monstor(int attackPoint, int protectionPoint, int healthPoint, int minDamagePiont, int maxDamagePoint) {
        super(attackPoint, protectionPoint, healthPoint, minDamagePiont, maxDamagePoint);
        super.type = "Monstor";
    }
}
