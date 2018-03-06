package isg;

import characters.Hero;
import characters.Monster;

import java.util.Scanner;

public class LearningSoulsGame {
    private static boolean choice;

    public static void main(String[] args) {
        while(!choice) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez-vous créer un héros ? y/n");
            String res = sc.nextLine();
            if(res.equals("y")) {
                createHeros();
            } else {
                System.out.println("Voulez-vous créer un monstre ? y/n");
                res = sc.nextLine();
                if (res.equals("y")) {
                    createMonster();
                } else {
                    choice = true;
                }
            }
        }

    }

    private static void createHeros () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez-vous nommer votre héros ? y/n");
        String res = sc.nextLine();
        if (res.equals("y")) {
            System.out.println("Donnez un nom à votre héros");
            String name = sc.nextLine();
            Hero hero = new Hero(name);
            hero.printStats();
            System.out.println("L'heros:\t" + hero.getName() + "est" + ((hero.isALive()?"\t (ALIVE)":"\t (DEAD)")));
        } else {
            Hero hero = new Hero();
            hero.printStats();
        }
    }

    private static void createMonster() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez-vous nommer votre monstre ? y/n");
        String res = sc.nextLine();
        if (res.equals("y")) {
            System.out.println("Donnez un nom à votre monstre");
            String name = sc.nextLine();
            Monster monster = new Monster(name);
            monster.printStats();
        } else {
            Monster monster = new Monster();
            monster.printStats();
        }
    }
}
