package com.rpg.model;

public class Paladin extends Character implements Healable {
	
	public Paladin(String name, int level) {
		super(name, level);
	}
	
	@Override
	public void attack() {
		System.out.println("성기사가 둔기를 휘둘러 공격합니다!");
	}
	
	@Override
	public void heal(Character target) {
		System.out.println(this.getName() + "이(가) " + target.getName() + "을 치료합니다!");
	}

}
