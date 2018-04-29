package characters;

import lsg.weapons.*;
import lsg.armor.*;

public class Monster  extends Character{
    private static int INSTANCES_COUNT = 0;
    private static float skinThickness = 20;

    public Monster(String name) {
        this();
        this.name = name;
    }


    public Monster() {
        INSTANCES_COUNT ++;
        this.name = "Monster_"+INSTANCES_COUNT;
        this.maxLife = 100;
        this.maxStamina = 10;
        this.life = 100;
        this.stamina = 10;
    }


  /*  public String toString() {
        return "[Monster]\t" + this.name + "\t LIFE : " + this.life + "\t STAMINA : " + this.stamina + (isAlive()?"\t (ALIVE)":"\t (DEAD)");
    }*/
    public static float getSkinThickness() {
        return skinThickness;
    }

    public void setSkinThickness(float skinThickness) {
        Monster.skinThickness = skinThickness;
    }

    public float computeProtection() {
        return getSkinThickness();
    }

    public float computeBuffValue() {
        return 0;
    }

    

}
