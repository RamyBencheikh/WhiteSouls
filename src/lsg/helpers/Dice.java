package lsg.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Dice {

    private int faces;
    private Random random;


    public Dice(int faces)
    {
        this.faces = faces;
        random = new Random();
    }

    public Integer roll()
    {
        return random.nextInt(this.faces);
    }


    public static void main(String[] args) {

        Dice d1 = new Dice(50);
        ArrayList<Integer> list = new ArrayList();

        for(int i = 0; i < 500; i++)
        {
            list.add(d1.roll());
        }
        System.out.println(list);
        System.out.println("Min : " + Collections.min(list));
        System.out.println("Max : " + Collections.max(list));

    }
}