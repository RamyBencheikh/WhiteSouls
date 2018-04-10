package characters;


public class Hero extends Character {

    public Hero(String name) {
        this.name = name;
        this.maxLife = 100;
        this.maxStamina = 50;
        this.life = 100;
        this.stamina = 50;
    }

    public Hero() {
        this.name = "Ynovator";
        this.maxLife = 100;
        this.maxStamina = 50;
        this.life = 100;
        this.stamina = 50;
    }

    public String toString() {
        return "[Hero]\t" + this.name + "\t LIFE : " + this.life + "\t STAMINA : " + this.stamina + (isAlive()?"\t (ALIVE)":"\t (DEAD)");
    }


}
