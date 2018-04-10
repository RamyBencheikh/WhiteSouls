package characters;

public class Monster  extends Character{
    private static int INSTANCES_COUNT = 0;

    public Monster(String name) {
        this();
        this.name = name;
    }


    public Monster() {
        INSTANCES_COUNT ++;
        this.name = "Monter_"+INSTANCES_COUNT;
        this.maxLife = 10;
        this.maxStamina = 10;
        this.life = 10;
        this.stamina = 10;
    }


    public String toString() {
        return "[Monster]\t" + this.name + "\t LIFE : " + this.life + "\t STAMINA : " + this.stamina + (isAlive()?"\t (ALIVE)":"\t (DEAD)");
    }


}
