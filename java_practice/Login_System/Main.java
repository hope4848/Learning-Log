package com.study.login;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserManager manager = new UserManager();
		
		while (true) {
			System.out.println("===로그인 권한 시스템 ===");
			System.out.println("1. 로그인 2. 회원가입 3. 종료");
			int choice = sc.nextInt();
			
			if (choice==1) {
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String password = sc.next();
				User user = manager.login(id, password);
				if (user==null) {
					System.out.println("아이디 또는 비밀번호가 잘못됐습니다.");
				}
				if (user!=null) {
					System.out.println("로그인 성공! " + user.getName() + "님 환영합니다.");
					
					if (user.getRole().equals("ADMIN")) {
						System.out.println("[관리자 메뉴]");
						System.out.println("1. 전체 회원 조회");
						int adminChoice = sc.nextInt();
						
						if (adminChoice ==1) {
							manager.showAllUsers();
						}
					} else {
						System.out.println("일반 사용자입니다.");
					}
				}
			} 
			if (choice==2) {
				System.out.print("새 ID :");
				String nid = sc.next();
				System.out.print("새 PW :");
				String npw = sc.next();
				System.out.print("새 NAME :");
				String nname = sc.next();
				manager.register(nid, npw, nname);
			}
			if (choice==3) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
		sc.close();
	}
}