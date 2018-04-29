package characters;
import lsg.bags.Collectible.Collectible;
import lsg.bags.Collectible.SmallBag;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;
import lsg.helpers.Dice;
import consumables.food.*;
import consumables.drinks.*;
import consumables.Consumable;
import consumables.repair.*;
import lsg.bags.Collectible.Bag;

import java.lang.reflect.Array;


public abstract class Character {

    protected String name;
    protected Integer life;
    protected Integer maxLife;
    protected Integer stamina;
    private String  alive;
    protected Integer maxStamina;
    protected static Integer INSTANCES_COUNT = 1;
    protected Weapon weapon;
    protected Consumable consumable;
    private Bag bag = new SmallBag();

    public static final String LIFE_STAT_STRING = "LIFE: ";
    public static final String STAM_STAT_STRING = "STAMINA: ";
    public static final String PROTEC_STAT_STRING = "PROTECTION: ";
    public static final String BUFF_STAT_STRING = "BUFFS: ";


    Dice d1 = new Dice(101);

    public String getName()
    {
        return this.name;
    }

    public String setName(String name)
    {
        return this.name;
    }

    public Integer getLife()
    {
        return this.life;
    }

    public Integer setLife(Integer life)
    {
        return this.life;
    }

    public Integer getMaxLife()
    {
        return this.maxLife;
    }

    public Integer getStamina()
    {
        return this.stamina;
    }

    public Integer setStamina(Integer stamina)
    {
        this.stamina = stamina;
        return this.stamina;
    }

    public Integer setMaxLife(Integer maxLife)
    {
        return this.maxLife;
    }

    public Integer getMaxStamina()
    {
        return this.maxStamina;
    }

    public Integer setMaxStamina(Integer maxStamina)
    {
        return this.maxStamina;
    }

    public void printStats()
    {
        System.out.println(this.toString());
    }
    
    public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Boolean isAlive()
    {
        if(life == 0)
        {
            return false;
        }else{
            return true;
        }
    }

    public String toString()
    {
        if(isAlive() == false)
        {
            alive = "DEAD";
        }
        else{
            alive = "ALIVE";
        }


        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s", "[" +  this.getClass().getSimpleName() + "] " + name , LIFE_STAT_STRING + life, STAM_STAT_STRING + stamina, PROTEC_STAT_STRING + computeProtection(), BUFF_STAT_STRING + computeBuffValue(), "   (" + alive + ")");
    }

    private int attackWith(Weapon weapon) {
    	int accuracy =  d1.roll();
        int damage = (int)((weapon.getMaxDamage()-weapon.getMinDamage())*(accuracy/100.f));
        
        if (getStamina() == 0 || weapon.isBroken()) {
        	return 0;
        	}
        else {

        	weapon.use();
        
	        if (this.getStamina() < weapon.getStamCost()) {
	        	float ratioStamina;
	           damage = damage+weapon.getMinDamage();
	           ratioStamina = (float)this.getStamina()/weapon.getStamCost();
	           damage = Math.round(damage*ratioStamina);
	           this.setStamina(0);
	        } else {
	        	damage = damage + weapon.getMinDamage();
	        	this.setStamina(this.getStamina()-weapon.getStamCost());
	        }
        }
        
        return (int) (damage + (damage*this.computeBuffValue())/100);
    }
    
    public int attack() {
    	
    	return (this.attackWith(weapon));
    }
    
    public int getHitWith(int value) {
    	if(this.computeProtection() >= 100) {
    		return this.getLife();
    	} else {
    		System.out.println(value);
    		System.out.println(Math.round(value*(1-(this.computeProtection()/100))));
    		value = Math.round(value*(1-(this.computeProtection()/100)));
    		this.life = (value < this.life) ? (this.life-value) : (0);
        	return this.life;
    	}
    	
    }
    
    public static void main(String[] args) {
       

    }
    
    public abstract float computeProtection();

    public abstract float computeBuffValue();

    private void drink(Drink drink)
    {
        System.out.println(this.getName() + " drinks " + drink.toString());
        int sommeVie = this.getLife() + drink.use();
        System.out.println("After use : " + drink.toString());
        if (sommeVie > this.getMaxLife()) {
            this.setLife(this.getMaxLife());
        }
        else {
            this.setLife(sommeVie);
        }
    }

    private void eat(Food food)
    {
        System.out.println(this.getName() + " eats " + food.toString());
        int sommeVie = this.getLife() + food.use();
        System.out.println("After use : " + food.toString());
        System.out.println(this.getMaxLife());
        if (sommeVie > this.getMaxLife()) {
            this.setLife(this.getMaxLife());
        }
        else {
            this.setLife(sommeVie);
        }
    }

    public void use(Consumable consumable)
    {
        if(consumable instanceof Drink)
        {
            this.drink((Drink) consumable);
        }else if (consumable instanceof Food){
            this.eat((Food) consumable);
        }else if(consumable instanceof RepairKit)
        {
            this.repairWeaponWith((RepairKit) consumable);
        }
    }

    private void repairWeaponWith(RepairKit kit)
    {
        System.out.println(this.getName() + " repairs " + this.weapon.toString() + " with " + kit.toString());
        int totalRepair = this.weapon.getDurability() + kit.use();
        System.out.println("After use : " + kit.toString());
        this.weapon.repairDurability(totalRepair);
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }
    public void consume()
    {
        this.use(this.getConsumable());
    }

    public void pickUp(Collectible item) {
        bag.push(item);
    }

    public void printBag() {
        bag.toString();
    }

    public int getBagCapacity() {
        return bag.getWeight();
    }

    public void consumables() {
        consumable.toString();
    }
}