package com.study.login;
import java.util.ArrayList;

public class LoginManager2 {
    private ArrayList<User> userStorage = new ArrayList<>();
    
    public LoginManager2() {
        userStorage.add(new User("admin", "1234", "관리자"));
    }
    
    // 회원가입: 중복 체크 후 리스트 추가
    public void register(String id, String pw, String name) {
        for (int i = 0; i < userStorage.size(); i++) { // i 선언 추가
            if (userStorage.get(i).getId().equals(id)) {
                System.out.println("이미 존재하는 아이디입니다.");
                return;
            }
        }
        userStorage.add(new User(id, pw, name));
        System.out.println("회원 가입 성공! " + name + "님 환영합니다!");
    }

    // 로그인: ID로 유저 객체를 찾아 반환 (Main에서 호출하는 핵심 로직)
    public User login(String id) {
        for (User user : userStorage) {
            if (user.getId().equals(id)) {
                return user; // 찾으면 객체 반환
            }
        }
        return null; // 없으면 null 반환
    }
}