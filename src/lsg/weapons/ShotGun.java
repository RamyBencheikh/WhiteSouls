package lsg.weapons;

public class ShotGun extends Weapon{
	public ShotGun(){
        super("Basic ShotGun", 6, 20, 5, 100);
    }

    public static void main(String[] args) {
        Weapon shotgun = new Weapon("Basic ShotGun", 6, 20, 5, 100);

        System.out.println(shotgun.toString());
    }
}





