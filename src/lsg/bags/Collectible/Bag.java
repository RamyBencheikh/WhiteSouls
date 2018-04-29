/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsg.bags.Collectible;

import java.util.HashSet;
import java.util.Iterator;
import lsg.LearningSoulsGame;


public class Bag {
   protected static Integer capacity;
   protected Integer weight;
   protected HashSet<Collectible> items;
   
   public Bag(Integer capacity)
   {
       this.capacity = capacity;
   }

    public static Integer getCapacity() {
        return capacity;
    }

    public Integer getWeight() {
        return weight;
    }

    public static void setCapacity(Integer capacity) {
        Bag.capacity = capacity;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    
    public void push(Collectible item)
    {
       if (item.getWeight() <= this.getCapacity() - this.getWeight()) {
			this.items.add(item);
			int poids = this.getWeight() + item.getWeight();
			this.setWeight(poids);
		}	
    }
    
    public Collectible pop(Collectible item)
    {
        if (items.contains(item)) {
			items.remove(item);
			this.setWeight(this.getWeight() - item.getWeight());
			return item;
		}
		return null;
    }
    
    public boolean contains(Collectible item)
    {
        if(items.contains(item))
        {
            return true;
        }else{
            return false;
        }
    }
    
    public Collectible[] getItems()
    {
        return items.toArray(new Collectible[items.size()]);
    }
    
   public String toString() {
		String affichage = "";
		if (this.getWeight() != 0) { 
			affichage = String.format("%s [ %d items | %d/%d kg ]%s", this.getClass().getSimpleName(), this.items.size(), this.getWeight(), this.getCapacity(), System.lineSeparator());
			Iterator<Collectible> i = this.items.iterator();
			while(i.hasNext()) {
				Collectible collectible = i.next();
				affichage += String.format("%s %s [%d kg]%s", LearningSoulsGame.BULLET_POINT, collectible.toString(), collectible.getWeight(), System.lineSeparator());
			}
		}
		else {
			affichage = String.format("%s [ %d items | %d/%d kg ]%s %-15s", this.getClass().getSimpleName(), this.items.size(), this.getWeight(), this.getCapacity(), " [empty]", System.lineSeparator());
		}
		return affichage;
	}
   
//   public void transfer(Bag from, Bag into) {
//       Iterator<Collectible> i = from.items.iterator();
//       while ((into.getWeight()+ from.items.size() <= into.getCapacity()) && (i.hasNext())) {
//        into.push(from.items);
//        from.pop(from.items);
//       }
//   }
 
}
