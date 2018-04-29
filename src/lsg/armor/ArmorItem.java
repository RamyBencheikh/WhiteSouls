package lsg.armor;
import lsg.bags.Collectible.Collectible;

public abstract class ArmorItem implements Collectible{
    private String name;
    private float armorValue;

    public String getName() {
        return name;
    }

    public float getArmorValue() {
        return armorValue;
    }

    public ArmorItem (String name, float value) {
        this.name = name;
        this.armorValue = value;
    }

    public String toString() {
        return this.name + "(" + this.armorValue + ")";
    }

    public int getWeight() {
        return 4;
    }
}

