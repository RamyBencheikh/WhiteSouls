package characters;

import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public class Character {

    protected String name;
    protected Integer life;
    protected Integer maxLife;
    protected Integer stamina;
    private String  alive;
    protected Integer maxStamina;
    protected static Integer INSTANCES_COUNT = 1;

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


        return String.format("%-20s%-20s%-20s%-20s", "[" +  this.getClass().getSimpleName() + "] " + name ,"LIFE " + life, "STAMINA " + stamina, "(" + alive + ")");
    }

    public int attackWith(Weapon weapon) {
        int stam = getStamina();

        if (stam ==0) return 0;
        if (weapon.isBroken()) return 0;

        weapon.use();

        if (stam > 0) {
            setStamina(stam - weapon.getStamCost());
            if (getStamina() < 0) {
                setStamina(0);
            }
        }

        int current = d1.roll(); // Précision
        int damage = (weapon.getMaxDamage()-weapon.getMinDamage())*(current/100);

    }

    public static void main(String[] args) {
        Character bla = new Character();
        System.out.println(bla.d1.roll());

    }

}