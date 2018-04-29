package characters;

import lsg.weapons.*;
import lsg.armor.*;
import lsg.buffs.Ring.*;

public class Hero extends Character {
    private static int MAX_ARMOR_PIECES = 3;
    public static final int MAX_RING_PIECES = 2;
    private ArmorItem[] stuff = new ArmorItem[MAX_ARMOR_PIECES];
    private ArmorItem[] armorItems = new ArmorItem[MAX_ARMOR_PIECES];
    private Ring[] ring = new Ring[MAX_RING_PIECES];
    private Ring[] ringItem = new Ring[MAX_RING_PIECES];

    public Hero(String name) {
        this.name = name;
        this.maxLife = 100;
        this.maxStamina = 50;
        this.life = 100;
        this.stamina = 50;
        this.weapon = new ShotGun();
    }

    public Hero() {
        this.name = "Ynovator";
        this.maxLife = 1000;
        this.maxStamina = 50;
        this.life = 1000;
        this.stamina = 50;
    }

 /*   public String toString() {
        return "[Hero]\t" + this.name + "\t LIFE : " + this.life + "\t STAMINA : " + this.stamina + (isAlive()?"\t (ALIVE)":"\t (DEAD)");
    }*/
    public void setArmorItem(ArmorItem armor, int slot) {
        if (slot >= 0 && slot <= MAX_ARMOR_PIECES) {
            slot -= 1;
            this.stuff[slot] = armor;
        }
    }

    public float getTotalArmor() {
        float totalArmor = 0;
        for (int i=0; i <MAX_ARMOR_PIECES; i++) {
            if (this.stuff[i]!=null) {
                totalArmor += this.stuff[i].getArmorValue();
            }
        }
        return totalArmor;
    }

    public void armorToString() {
        String stuffList="";
        for (int i=0; i < MAX_ARMOR_PIECES; i++) {
            if (this.stuff[i]!=null) {
                stuffList += this.stuff[i].toString()+ "\t";
            } else {
                stuffList += "\tempty\t";
            }
        }
        System.out.println(stuffList + "\tTotal\t" + this.getTotalArmor());
    }



    public ArmorItem[] getArmorItems() {
        for (int i=0; i < MAX_ARMOR_PIECES; i++) {
            if (this.stuff[i] != null) {
                this.armorItems[i] = this.stuff[i];
            }
        }
        return this.armorItems;
    }

    public float computeProtection() {
        return getTotalArmor();
    }

    public void setRing(Ring ring, int slot) {
        if (slot >= 0 && slot < MAX_RING_PIECES) {
            this.ring[slot] = ring;
        }
    }

    public Ring[] getRingItem() {
        for (int slot = 0; slot < MAX_RING_PIECES; slot++) {
            if (this.ring[slot] != null) {
                this.ringItem[slot] = this.ring[slot];
            }
        }
        return this.ringItem;
    }

    public float getTotalBuff() {
        float totalBuff = 0;
        for (int finger = 0; finger < MAX_RING_PIECES; finger++) {
            if (this.ring[finger] != null) {
                totalBuff += this.ring[finger].computeBuffValue();
            }
        }
        return totalBuff;
    }

    public float computeBuffValue() {
        return this.getTotalBuff();
    }

    public void printRing(){
        ring.toString();
    }


}
