package com.hj.cafe;
import java.util.ArrayList;

public class CafeMain {
	public static void main(String[] args) {
		ArrayList<Menu> menulist = new ArrayList<>();
	
	menulist.add(new Coffee("아메리카노", 2000));
	menulist.add(new Dessert("두쫀쿠", 5000));
	
	System.out.println("=== 카페 주문 확인 ===");
	
	
	
	int totalPrice = 0;
	for (Menu m : menulist) {
		m.showInfo();
		m.prepare();
		totalPrice += m.price;
		System.out.println("---------------------");
	}
	
	System.out.println("총 결제 금액: " + totalPrice + "원");
	
	}
}
