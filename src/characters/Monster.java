package characters;

public class Monster {

    private String name;
    private int life, maxLife,stamina, maxStamina;
    private static int INSTANCES_COUNT=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    /**
     * Define the Monster name with the choose of the user
     * @param name: Name of the Monster
     */
    public Monster(String name) {
        this();
        this.name = name;
    }

    /**
     * Define a default Monster name when user not define it
     * Set 10 maxLife and 10 max Stamina
     */
    public Monster() {
        this.name = "YMonster_"+INSTANCES_COUNT;
        this.life = 10;
        this.maxLife = 10;
        this.stamina = 10;
        this.maxStamina = 10;
        INSTANCES_COUNT ++;
    }

    /**
     * @return monster statistics
     */
    public String toString() {
        return "[Monster]\t" + this.name + "\tStamina:\t" + this.stamina + "\tLife:\t" + this.life +
                (this.isALive()?"\t (ALIVE)":"\t (DEAD)");
    }

    /**
     * Print monster statistics
     */
    public void printStats() {
        System.out.println(toString());
    }

    public Boolean isALive() {
        return this.getLife() > 0;
    }
}
