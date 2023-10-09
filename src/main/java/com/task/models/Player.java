package com.task.models;


public class Player extends Creature {


    private int chanceToAlive;

    private int healthPoint;

    public Player(int attackPoint, int protectionPoint, int healthPoint, int minDamagePiont, int maxDamagePoint) {
        super(attackPoint, protectionPoint, healthPoint, minDamagePiont, maxDamagePoint);
        chanceToAlive = 4;
        this.healthPoint = healthPoint;
        super.type = "Player";
    }
    
    public void damage(int damage) {
        super.healthPoint -= damage;
        if (super.healthPoint < 1) {
            if (chanceToAlive > 0) {
                chanceToAlive--;
                super.healthPoint = (int)(this.healthPoint * 0.3);
            }
            else super.alive = false;
        }
    };
}
