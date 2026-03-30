package com.hj.cafe;

public class Coffee extends Menu {
	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public void prepare() {
		System.out.println(name + " 만드는 중!");
	}

}
