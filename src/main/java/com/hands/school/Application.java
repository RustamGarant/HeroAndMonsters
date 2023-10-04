package com.hands.school;

import com.hands.school.creatures.Creature;
import com.hands.school.creatures.Hero;
import com.hands.school.creatures.Monster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Hero hero = new Hero("hero", 5, 6, 50, 4, 10);
		Creature monster1 = new Monster("monster1", 7, 4, 40, 1, 20);
		Creature monster2 = new Monster("monster2", 2, 6, 30, 5, 7);
		List<Creature> monsters = new ArrayList<>();
		monsters.add(monster1);
		monsters.add(monster2);

		while(hero.getHealth() > 0 && monsters.stream().filter(monster -> monster.getHealth()>0).toList().size()>0){
			for(Creature monster : monsters){
				if(monster.getHealth() > 0) {
					int damageOfHero = hero.attackEnemy(monster);
					System.out.printf("%s attacked %s for %d\n", hero.getName(), monster.getName(), damageOfHero);
					if (monster.getHealth() > 0) {
						int damageOfMonster = monster.attackEnemy(hero);
						System.out.printf("%s attacked %s for %d\n", monster.getName(), hero.getName(), damageOfMonster);
						if (hero.getHealth() <= 0) {
							System.out.printf("%s beat %s!\n", monster.getName(), hero.getName());
							break;
						} else if(hero.getHealth() < hero.getMaxHealth()*70/100 && hero.getCountHeal() < 4){
							int heal = hero.heal();
							System.out.printf("%s healed %d points\n", hero.getName(), heal);
						}
					} else {
						System.out.printf("%s beat %s!\n", hero.getName(), monster.getName());
					}
				}
			}
		}
	}

}
