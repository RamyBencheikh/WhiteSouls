package characters;

public class Hero {

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;

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
     * Define the hero name with the choose of the user
     * Set 100 maxLife and 50 max Stamina
     * @param name: Name of the hero
     */
    public Hero(String name) {
        this.name = name;
        this.life = 100;
        this.maxLife = 100;
        this.stamina = 50;
        this.maxStamina = 50;
    }

    /**
     * Define a default hero name when user not define it
     * Set 100 maxLife and 50 max Stamina
     */
    public Hero() {
        this.name = "Ynovator";
        this.life = 100;
        this.maxLife = 100;
        this.stamina = 50;
        this.maxStamina = 50;
    }

    /**
     * @return hero statistics
     */
    public String toString() {
        return "[Hero]\t" + this.name + "\tStamina:\t" + this.stamina + "\tLife:\t" + this.life +
                (this.isALive()?"\t (ALIVE)":"\t (DEAD)");
    }

    /**
     * Print hero statistics
     */
    public void printStats() {
        System.out.println(toString());
    }

    public Boolean isALive() {
        return this.life != 0;
    }
}
