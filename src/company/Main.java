package company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
    }
}
