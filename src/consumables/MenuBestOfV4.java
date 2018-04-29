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
import java.util.Iterator;
import java.util.LinkedHashSet;


public class MenuBestOfV4 extends LinkedHashSet<Consumable> {
    private String tab = "";

    public void init(){
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
        
        return String.format("MenuBestOfV4 : \n" + this.tab);
    }
    
    public static void main(String[] args) {
        MenuBestOfV4 b4 = new MenuBestOfV4();
        b4.init();
        System.out.println(b4.toString());
    }
}
