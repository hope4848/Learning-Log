package com.rpg.model;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Character> clist = new ArrayList<>();
		
	clist.add(new Warrior("타락파워전사", 10, 50));
	clist.add(new Wizard("초보마법사", 15, 70));
	clist.add(new Paladin("성기사", 30));
	
	System.out.println("모험이 시작 되었습니다.");
	
	
	for (Character c : clist) {
		c.attack();
		if (c instanceof Warrior w) {
			w.shout();
		} else if (c instanceof Wizard t) {
			t.teleport();
			if (t instanceof pumping p) {
				p.pumpALL(clist);
			}
		} else if (c instanceof Healable h) {
			for (Character target : clist) {
				if (c != target) {
					h.heal(target);
				}
			}
		}
	}
	for (Character c : clist) {
	    c.levelUp(); 
	}
	
	
	

	System.out.println("모든 모험가의 정보 업데이트가 완료되었습니다.");
	}

}
