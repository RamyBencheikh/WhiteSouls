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
import java.util.HashSet;
import java.util.Iterator;


public class MenuBestOfV3 extends HashSet<Consumable> {
    private String tab = "";

    public void init()
    {
        Hamburger hamburger = new Hamburger();
        Wine wine = new Wine();
        Americain americain = new Americain();
        Coffee coffee = new Coffee();
        Whisky whisky = new Whisky();
    
        this.add(hamburger);
        this.add(wine);
        this.add(americain);
        this.add(coffee);
        this.add(whisky);
    }
    
        
         
    public String toString()
    {
       
        Iterator it = this.iterator();
        int cnt = 0;
        while(it.hasNext())
        {
            cnt++;
            this.tab += cnt + " : " + it.next() + "\n";
        }
        
        return String.format("MenuBestOfV3 : \n" + this.tab);
    }
    
    public static void main(String[] args) {
        MenuBestOfV3 b3 = new MenuBestOfV3();
        b3.init();
        System.out.println(b3.toString());
    }
}
