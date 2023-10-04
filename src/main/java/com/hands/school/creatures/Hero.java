package com.hands.school.creatures;

import lombok.Getter;

@Getter
public class Hero extends Creature {
    private int countHeal;

    public Hero(String name, int defense, int attack, int maxHealth, int minDamage, int maxDamage) {
        super(name, defense, attack, maxHealth, minDamage, maxDamage);
        this.countHeal = 0;
    }

    public int heal() {
        health = (health + maxHealth * 30 / 100);
        countHeal++;
        return maxHealth * 30 / 100;
    }
}
