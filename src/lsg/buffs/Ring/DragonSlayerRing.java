package lsg.buffs.Ring;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggins;

public class DragonSlayerRing extends Ring{
	
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}

	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}
	
	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItems() ;
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggins) return true ;
		}
		return false ;
	}
	
}
