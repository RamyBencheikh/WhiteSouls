package lsg.weapons;

public class Weapon {
    protected String name;
    protected Integer minDamage;
    protected Integer maxDamage;
    protected Integer stamCost;
    protected Integer durability;

    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability)
    {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public Integer getMinDamage() {
        return minDamage;
    }

    public Integer getMaxDamage() {
        return maxDamage;
    }

    public Integer getStamCost() {
        return stamCost;
    }

    public Integer getDurability() {
        return durability;
    }

    private void setDurability(Integer durability) {
        this.durability = durability;
    }

    public void use()
    {
        this.setDurability(durability - 1);
    }


    public Boolean isBroken()
    {
        return this.durability <= 0;
    }


    public String toString(){

        return String.format(this.name + "( min: " + this.minDamage + " max: " + this.maxDamage + " stam: " + this.stamCost + " dur: " + this.durability + ")");
    }
}