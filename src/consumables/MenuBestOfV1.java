/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumables;

import consumables.drinks.Coffee;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;


public class MenuBestOfV1 {
    private Consumable[] menu = new Consumable[5];
    
    private void init()
    {
        Hamburger hamburger = new Hamburger();
        Wine wine = new Wine();
        Americain americain = new Americain();
        Coffee coffee = new Coffee();
        Whisky whisky = new Whisky();
        
        this.menu[0] = hamburger;
        this.menu[1] = wine;
        this.menu[2] = americain;
        this.menu[3] = coffee;
        this.menu[4] = whisky;
    }
    
    public String toString()
    {
        return String.format("MenuBestOfV1 : \n 1: " + this.menu[0] + "\n 2: " + this.menu[1] + "\n 3: " + this.menu[2] + "\n 4: " + this.menu[3] + "\n 5: " + this.menu[4]);
    }
    
    public static void main(String[] args) {
        MenuBestOfV1 b1 = new MenuBestOfV1();
        b1.init();
        System.out.println(b1.toString());
    }
}
