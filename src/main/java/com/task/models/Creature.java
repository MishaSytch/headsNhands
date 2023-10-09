package com.task.models;

import java.security.InvalidParameterException;
import java.util.Random;

import com.task.services.Attack;


public class Creature {

    public String type;
    public String health;
    public String damage;

    public int countOfDead;

    private int damagePointNow;
    
    public int getDamagePointNow() {
        int tmp = damagePointNow;
        damagePointNow = getDamagePoint();
        return tmp;
    }

    private Random random = new Random();
    private Attack attack = new Attack(this);

    protected boolean alive;

    public boolean isAlive() {
        return alive;
    }

    private final int attackPoint;
    private final int protectionPoint;
    
    private final int[] damagePionts;

    protected int healthPoint;

    public Creature(int attackPoint, int protectionPoint, int healthPoint, int minDamagePiont, int maxDamagePoint) {
        if (attackPoint < 1 || protectionPoint < 0 || healthPoint < 1 || minDamagePiont < 0 || maxDamagePoint <= minDamagePiont) {
            throw new InvalidParameterException();
        }
        
        random = new Random();
        alive = true;
        this.attackPoint = attackPoint;
        this.protectionPoint = protectionPoint;
        this.healthPoint = healthPoint;
        this.damagePionts = new int[]{minDamagePiont, maxDamagePoint};
        damagePointNow = getDamagePoint();
    }

    public void damage(int damage) {
        healthPoint -= damage;
        if (healthPoint < 1) {
            alive = false;
        }
    };

    public void toAttack(Creature enemy) {
        if (enemy.isAlive()) {
            attack.toAttack(enemy);
        }
    }

    public int getAttackPoint() {
        return attackPoint;
    };

    public int getProtectionPoint() {
        return protectionPoint;
    };

    public int getHealthPoint() {
        return healthPoint;
    };

    public int getDamagePoint() {
        return random.nextInt(damagePionts[0], damagePionts[1]);
    };
}
