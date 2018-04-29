package lsg.weapons;
import consumables.repair.RepairKit;
import lsg.bags.Collectible.Collectible;

public class Weapon implements Collectible{
    protected String name;
    protected Integer minDamage;
    protected Integer maxDamage;
    protected Integer stamCost;
    protected Integer durability;

    public static final String DURABILITY_STAT_STRING = " Durability: ";
    public static final String MAX_STAT_STRING = " STAT MAX: ";
    public static final String MIN_STAT_STRING = " STAT MIN: ";
    public static final String STAM_STAT_STRING = " STAM: ";


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
        this.setDurability(this.getDurability() - 1); 
    }


    public Boolean isBroken()
    {
        return this.durability <= 0;
    }


    public String toString(){

        return String.format(this.name + "(" + MIN_STAT_STRING + minDamage + MAX_STAT_STRING + maxDamage + STAM_STAT_STRING + stamCost + DURABILITY_STAT_STRING + durability + ")");
    }

    public void repairDurability(int durability) {
        this.setDurability(durability);
    }

    public void repairWeaponWith(RepairKit kit)
    {
        this.setDurability(this.getDurability() + kit.use());
    }

    public int getWeight() {
        return 2;
    }
}