package com.rpg.model;

public abstract class Character {
	private String name;
	private int level;
	
	public Character(String name, int level) {
		this.name = name;
		this.level = level;
	}
	
	public String getName() {return name;}
	public int getLevel() {return level;}
	
	public void levelUp() {
		System.out.println("레벨을 1 올리고 " + name + "의 레벨이 올랐습니다!");
		System.out.println("[" + name + "]의 레벨 : " + (++level));
	}
	
	public abstract void attack();

}
