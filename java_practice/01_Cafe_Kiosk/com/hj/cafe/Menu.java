package com.hj.cafe;

public abstract class Menu {
	protected String name;
	protected int price;
	
	public void showInfo() {
		System.out.println(name + " : " + price + "원");
	}
	
	public abstract void prepare();

}
