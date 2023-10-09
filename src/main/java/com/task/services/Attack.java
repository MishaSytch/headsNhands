package com.task.services;

import java.util.Random;

import com.task.models.Creature;

public class Attack {

    private Random random;

    private Creature attacking;

    public Attack(Creature attacking) {
        this.attacking = attacking;
        random = new Random();
    }

    public void toAttack(Creature enemy) {

        int attackDamagePoint = attacking.getDamagePointNow();
        int enemyDamagePoint = enemy.getDamagePointNow();
        int modifierDamage = attackDamagePoint - enemyDamagePoint + 1;

        int countOfBrick = 0;
        for (int i = 0; i < modifierDamage; i++) {
            if (random.nextInt(1, 7) > 4)
                countOfBrick++;
            
            if (countOfBrick > 1) {
                enemy.damage(attackDamagePoint);
                break;
            }
        }
    }
}
