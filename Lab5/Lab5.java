/*
 * A game development company is creating a GameCharacter class that has an abstract method attack() and a final method respawn(). The respawn() method must work the same for all characters, but different characters should have different attack styles.
 * 1. Create an abstract class GameCharacter with an abstract method attack().


2. Add a final method respawn() to ensure all characters respawn the same way.


3. Implement the attack() method in subclasses like Warrior and Mage.
 */

 import java.util.Random;

abstract class GameCharacter {
    String name;
    int health;
    int energy;

    GameCharacter(String name, int health, int energy) {
        this.name = name;
        this.health = health;
        this.energy = energy;
    }

    abstract void attack();
    abstract void unleashPower();

    final void respawn() {
        this.health = 100;
        this.energy = 50;
        System.out.println(name + " has respawned with full health and energy!");
    }

    void endureHit(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has fallen in battle!");
            respawn();
        } else {
            System.out.println(name + " now has " + health + " HP.");
        }
    }

    void shield() {
        System.out.println(name + " is shielding against the attack!");
        endureHit(new Random().nextInt(10)); // Random damage between 0-9
    }
}

class Warrior extends GameCharacter {
    Warrior(String name) {
        super(name, 130, 70);
    }

    @Override
    void attack() {
        if (energy >= 10) {
            System.out.println(name + " slashes fiercely with a blade!");
            energy -= 10;
        } else {
            System.out.println(name + " lacks the stamina to attack!");
        }
    }

    @Override
    void unleashPower() {
        if (energy >= 30) {
            System.out.println(name + " executes a DEVASTATING STRIKE, shaking the battlefield!");
            energy -= 30;
        } else {
            System.out.println(name + " is too drained for a special move!");
        }
    }
}

class Mage extends GameCharacter {
    Mage(String name) {
        super(name, 90, 100);
    }

    @Override
    void attack() {
        if (energy >= 15) {
            System.out.println(name + " hurls a surge of arcane energy!");
            energy -= 15;
        } else {
            System.out.println(name + " is too weak to cast spells!");
        }
    }

    @Override
    void unleashPower() {
        if (energy >= 40) {
            System.out.println(name + " conjures a CELESTIAL STORM, engulfing the enemies!");
            energy -= 40;
        } else {
            System.out.println(name + " lacks the magical force for this spell!");
        }
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("King");
        Mage mage = new Mage("Queen");

        warrior.attack();
        mage.attack();

        System.out.println("\nAn enemy emerges and attacks!");
        warrior.endureHit(30);
        mage.endureHit(50);

        System.out.println("\nThe fight rages on...");
        warrior.unleashPower();
        mage.unleashPower();

        System.out.println("\nWarrior prepares for impact!");
        warrior.shield();

        System.out.println("\nMage braces for the next move.");
    }
}
