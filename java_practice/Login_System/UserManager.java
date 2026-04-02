package com.study.login;
import java.util.ArrayList;

public class UserManager {
	private ArrayList<User> userStorage = new ArrayList<>();
	
	public UserManager() {
		userStorage.add(new User("admin", "1234", "관리자", "ADMIN"));
	}
	
	
	public void register(String id, String password, String name) {
		for (int i=0; i<userStorage.size(); i++) {
			if (userStorage.get(i).getId().equals(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				return;
			}
		}
		userStorage.add(new User(id, password, name, "USER"));
		System.out.println("회원가입 성공!" + name + "님 환영합니다.");
	}
	
	public User login(String id, String password) {
		for (User user : userStorage) {
			if (user.getId().equals(id) && user.checkPassword(password)) {
				return user;
			}
			
		}
		return null;
		}
		
	public void showAllUsers() {
		if (userStorage.isEmpty()) {
			System.out.println("등록된 사용자가 없습니다.");
			return;
		}
		
		System.out.println("===전체 회원 목록 ===");
		for (User user : userStorage) {
			System.out.println(
				"ID: " + user.getId() +
				", NAME: " + user.getName() +
				", ROLE: " + user.getRole()
				);
		}
	
		
	}
}