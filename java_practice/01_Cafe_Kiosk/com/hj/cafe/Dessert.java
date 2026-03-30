package com.hj.cafe;

public class Dessert extends Menu {
	public Dessert(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public void prepare() {
		System.out.println(name + " 냉장고에서 꺼내는 중!");
	}

}
