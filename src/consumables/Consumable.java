/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumables;

import lsg.bags.Collectible.Collectible;


public class Consumable implements Collectible {
    
    private String name;
    private int capacity;
    private String stat;
    
    public Consumable(String name, int capacity, String stat) {
	this.name = name ;
	this.capacity = capacity ;
	this.stat = stat ;
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStat() {
        return stat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStat(String stat) {
        this.stat = stat;
    } 
    
    public String toString()
    {
        return String.format(this.getName() + " [ " + this.getCapacity() + " " + this.getStat() + " points(s) ]");
    }
    
    public int use()
    {
        int capacity = this.getCapacity();
        this.setCapacity(0);
        return capacity;
    }

    public int getWeight() {
        return 1;
    }
}
