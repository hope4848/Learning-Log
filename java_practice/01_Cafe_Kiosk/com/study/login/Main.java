package com.study.login;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LoginManager manager = new LoginManager();
		
		
		while (true) {
			System.out.println("\n --- 보안 인증 시스템 ---");
			System.out.println("1. 로그인 2. 회원가입 3. 종료");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				System.out.print("아이디 : ");
				String id = sc.next();
				User user = manager.login(id);
				if (user!=null) {
					System.out.print("비밀번호 : ");
					String pw = sc.next();
					if (user.authenticate(pw)) {
						System.out.println("로그인 성공!" + user.getName() + "님 환영합니다.");
					} else {
						System.out.println("비번 틀림");
					}
				} else {
					System.out.println("아이디 없음");
				}
			} else if (choice == 2) {
				System.out.print("새 ID : ");
				String nid = sc.next();
				System.out.print("새 PW : ");
				String npw = sc.next();
				System.out.print("새 이름 : ");
				String nname = sc.next();
				
				manager.register(nid, npw, nname);
			} else if (choice == 3) {
				System.out.println("시스템을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		sc.close();
	}
}