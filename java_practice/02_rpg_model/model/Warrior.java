package com.rpg.model;

public class Warrior extends Character {
	private int strength;
	
	public Warrior(String name, int level, int strength) {
		super(name, level);
		this.strength = strength;
	}
	
	public int getStrength() {return strength;}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@Override
	public void attack() {
		System.out.println("검을 휘둘러 " + strength + "의 데미지를 입힙니다!");
	}
	
	public void shout() {
		System.out.println("전사가 함성을 질러 사기를 높입니다!");
	}
}
