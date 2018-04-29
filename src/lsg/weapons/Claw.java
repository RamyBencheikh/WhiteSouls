package lsg.weapons;

public class Claw extends Weapon{
	public Claw(){
        super("Basic Claw", 50, 150, 5, 100);
    }

    public static void main(String[] args) {
        Weapon claw = new Weapon("Basic Claw", 50, 150, 5, 100);

        System.out.println(claw.toString());
    }
}