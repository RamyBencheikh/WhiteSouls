package lsg.weapons;

import java.util.Random;


public class Sword extends Weapon{


    public Sword(){
        super("Basic Sword", 5, 10, 20, 100);
    }

    public static void main(String[] args) {
        Weapon epee = new Weapon("Basic Sword", 5, 10, 20, 100);

        System.out.println(epee.toString());
    }
}
