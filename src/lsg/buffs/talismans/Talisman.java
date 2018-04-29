package lsg.buffs.talismans;

import java.util.Calendar;

import lsg.buffs.BuffItem;

public class Talisman extends BuffItem {
	
	private float buff ;
	private int begin, finish ;
	
	protected Talisman(String name, float buff, int begin, int finish) {
		super(name) ;
		this.buff = buff ;
		this.begin = begin ;
		this.finish = finish ;
	}

	public float computeBuffValue() {
		int actual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if(begin <= finish){
			if(actual >= begin && actual < finish) return buff ;
			else return 0f ;
		}else{
			if( (actual <= 23 && actual >= begin) || (actual >=0 && actual < finish)) return buff ;
			else return 0f ;
		}
	}
	
}
