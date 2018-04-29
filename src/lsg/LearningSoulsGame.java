package lsg;
import characters.Hero;
import characters.Lycanthrope;
import characters.Character;
import characters.Monster;
import lsg.weapons.*;
import lsg.armor.*;
import lsg.buffs.*;
import consumables.*;
import java.util.Iterator;

import java.util.Scanner;

public class LearningSoulsGame {
    private static boolean choice;
    static final public String BULLET_POINT = "\u2219";
    static Hero hero = new Hero();
    static Monster monster = new Monster();


    public static void main(String[] args) {

       while(!choice) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez-vous cr�er un h�ros ? y/n");
            String res = sc.nextLine();
            if(res.equals("y")) {
                createHeros();
            } else {
                System.out.println("Voulez-vous cr�er un monstre ? y/n");
                res = sc.nextLine();
                if (res.equals("y")) {
                    createMonster();
                } else {
                    choice = true;
                }
            }
            play_v3();
        } 
      /*  Hero hero = new Hero();
        DragonSlayerLeggins dragonSlayerLeggins = new DragonSlayerLeggins();
        hero.setArmorItem(dragonSlayerLeggins, 1);
        BlackWithVeil blackWithVeil = new BlackWithVeil();
        hero.setArmorItem(blackWithVeil, 3);
        float totalArmor = hero.getTotalArmor();
        System.out.println("Total Armor\t" + totalArmor);
        hero.armorToString();
        ArmorItem[] armorList = hero.getArmorItems();
        for (int i=0; i<armorList.length; i++){
            if(armorList[i] !=null) {
                System.out.println("List Armor\t" + armorList[i]);
            }

        }


        hero.printStats();*/
    }

    private static void createHeros () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez-vous nommer votre h�ros ? y/n");
        String res = sc.nextLine();
        if (res.equals("y")) {
            System.out.println("Donnez un nom � votre h�ros");
            String name = sc.nextLine();
            Hero hero = new Hero(name);
            hero.printStats();
            System.out.println("L'heros:\t" + hero.getName() + "est" + ((hero.isAlive()?"\t (ALIVE)":"\t (DEAD)")));
        } else {
            Hero hero = new Hero();
        }

    }
    
    private static void refresh(Character a, Character b) {
    	a.printStats();
    	b.printStats();
    	System.out.println("Veuillez taper entr�e pour continuer :)");
        Scanner scan = new Scanner(System.in);
          scan.nextLine();
    }
 
    private static void heroAttack(Hero hero) {
        while (hero.getStamina() != 0) {
            hero.printStats();
            hero.attack();
            
        }
    }
    
    private static void fight1v1(Character a, Character b) {
    	System.out.println("Le combat commence, que le plus cheat� gagne ! /o/");
    	while (a.getLife() != 0 && b.getLife() != 0 && (a.getStamina() != 0 || b.getStamina() != 0)) {
    		System.out.println(a.getName() + " attaque " + b.getName());
    		aAttackb(a,b);
    		if (a.getLife() != 0 && b.getLife() != 0 && a.getStamina() != 0 && b.getStamina() != 0) {
    			System.out.println(b.getName() + " attaque " + a.getName());
    			aAttackb(b,a);
    			}		
        	if (a.getLife() == 0) {System.out.println(a.getName() + " n'a plus de vie, " + b.getName() + "gagne !");}
        	if (b.getLife() == 0) {System.out.println(b.getName() + " n'a plus de vie" + a.getName() + "gagne !");}
        	if (a.getStamina() == 0) {System.out.println(a.getName() + " n'a plus d'�nergie");}
        	if (b.getStamina() == 0) {System.out.println(b.getName() + " n'a plus d'�nergie");}  
    		}
    	System.out.println("R�sultat :");
    	refresh(a,b);
    	
    }
    
    private static void aAttackb(Character hero, Character monster) {
        
        	refresh(hero, monster);
            monster.getHitWith(hero.attack());
    }
    
    
    private static void monsterAttack(Monster monster) {
        while (monster.getStamina() != 0) {
            monster.printStats();
            monster.attack();
        }
    }

    protected static void play_v1() {
    	Character a,b;
    	a = new Hero();
    	b = new Monster();
    	init(a,b);
    	fight1v1(a, b);
    }
    
    protected static void play_v2() {
    	Hero a;
    	Monster b;
    	a = new Hero();
    	b = new Monster();
    	init(a,b);
    	DragonSlayerLeggins dragonSlayerLeggins = new DragonSlayerLeggins();
        a.setArmorItem(dragonSlayerLeggins, 1);
    	fight1v1(a, b);
    }
    
    protected static void play_v3() {
    	Hero a;
    	Monster b;
    	a = new Hero();
    	b = new Lycanthrope();
    	init(a,b);
    	DragonSlayerLeggins dragonSlayerLeggins = new DragonSlayerLeggins();
        a.setArmorItem(dragonSlayerLeggins, 1);
    	fight1v1(a, b);
    }
    
    
    
    private static void init(Character a, Character b) {
        title();
    	a.setWeapon(new ShotGun());
    	b.setWeapon(new Claw());
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
        }
    }

//    public static void aTable()
//    {
//        MenuBestOfV4 menu = new MenuBestOfV4();
//        menu.init();
//        Iterator<Consumable> it = menu.iterator();
//        while(it.hasNext()){
//            hero.use(it.next());
//            hero.printStats();
//        }
//        System.out.println(hero.getWeapon().toString());
//    }

    public static void title() {
        System.out.println("################################");
        System.out.println("#    THE LEARNING SOULS GAME   # ");
        System.out.println("################################");
        System.out.println();
    }
}
