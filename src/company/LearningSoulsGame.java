package company;
import java.util.Scanner;

public class LearningSoulsGame {

    public static void main(String[] args) {
        createHeros();
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
        } else {
            Hero hero = new Hero();
            hero.printStats();
        }
        Monster monster = new Monster();
        Monster monster2 = new Monster();
        monster.printStats();
        monster2.printStats();
    }
}
