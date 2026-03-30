package com.study.login;
import java.util.ArrayList;

public class LoginManager {
	private ArrayList<User> userStorage = new ArrayList<>();
	
	public LoginManager() {
		userStorage.add(new User("admin", "1234", "관리자"));
	}
	
	public void register(String id, String pw, String name) {
		for (int i = 0; i < userStorage.size(); i++) {
			if (userStorage.get(i).getId().equals(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				return;
			}
		}
		userStorage.add(new User(id, pw, name));
		System.out.println("회원 가입 성공!" + name + "님 환영합니다.");
	}
	
	public User login(String id) {
		for (User user : userStorage) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
}