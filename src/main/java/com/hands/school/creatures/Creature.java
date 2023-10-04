package com.hands.school.creatures;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Creature {
    protected String name;
    @Min(0)
    @Max(30)
    protected int defense;
    @Min(0)
    @Max(30)
    protected int attack;
    @Min(0)
    protected int health;
    @Min(0)
    protected int maxHealth;
    protected List<Integer> damage;

    public Creature(String name, int defense, int attack, int maxHealth, int minDamage, int maxDamage) {
        this.name = name;
        this.defense = defense;
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        damage = new ArrayList<>();
        for (int i = minDamage; i <= maxDamage; i++) {
            damage.add(i);
        }
    }

    public int attackEnemy(Creature defender) {
        int damageOfThisAttack = 0;
        int modificator = attack - defender.getDefense() + 1;
        modificator = Math.max(modificator, 1);
        for (int i = 0; i < modificator; i++) {
            int resultOfThrowingCube = (int) Math.ceil(Math.random() * 6);
            if (resultOfThrowingCube >= 5) {
                int currentDamage = damage.get((int) Math.ceil(Math.random() * damage.size()-1));
                if (defender.getHealth() < currentDamage) {
                    damageOfThisAttack += defender.getHealth();
                    defender.setHealth(0);
                    break;
                } else {
                    defender.setHealth(defender.getHealth() - currentDamage);
                    damageOfThisAttack += currentDamage;
                }
            }
        }
        return damageOfThisAttack;
    }
}
