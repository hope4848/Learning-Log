package com.rpg.model;
import java.util.ArrayList;

public class Wizard extends Character implements pumping {
	private int intelligence;
	
	public Wizard(String name, int level, int intelligence) {
		super(name, level);
		this.intelligence = intelligence;
	}
	
	public int getIntelligence() {return intelligence;}
	
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public void attack() {
		System.out.println("마법 화살을 발사하여 " + intelligence + "의 데미지를 입힙니다!");
	}
	
	public void teleport() {
		System.out.println("마법사가 순식간에 이동합니다!");
	}
	
	public void pumpALL(ArrayList<Character> targets) {
		System.out.println("마법사가 능력치를 올렸습니다!");
		
		for (Character c : targets) {
			if (c instanceof Warrior w) {
				System.out.println(w.getName() + "의 힘이 30 증가합니다.");
				
				int currentStr = w.getStrength();
				w.setStrength(currentStr + 30);
				
				System.out.println("현재 " + w.getName() + "의 힘: " + w.getStrength());
		} else if (c instanceof Wizard t) {
			System.out.println(t.getName() + "의 지능이 30 증가합니다.");
			int currentInt = t.getIntelligence();
			t.setIntelligence(currentInt + 30);
			
			System.out.println("현재 " + t.getName() + "의 지능: " + t.getIntelligence());
		}
		}
	} 
}
