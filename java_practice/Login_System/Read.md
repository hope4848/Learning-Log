# 🔐 Java 로그인 및 권한 관리 시스템

## 📌 프로젝트 개요

Java 객체지향 개념을 기반으로
회원가입, 로그인, 그리고 **권한(Role) 기반 접근 제어**를 구현한 콘솔 애플리케이션입니다.

단순 CRUD가 아닌,
**인증(Authentication)과 인가(Authorization)의 기초 구조**를 직접 설계하고 구현하는 것을 목표로 했습니다.

---

## 🎯 주요 기능

### 1. 회원가입 (Register)

* 사용자 ID 중복 검사
* 기본 권한은 `USER`로 자동 설정
* 사용자 입력으로 권한을 지정하지 못하도록 제한

### 2. 로그인 (Login)

* ID + 비밀번호 검증
* 비밀번호는 직접 노출하지 않고 `checkPassword()`로 검증

### 3. 권한 기반 접근 제어 (Authorization)

* `ADMIN` 사용자만 특정 기능 접근 가능
* 일반 사용자(`USER`)는 제한된 기능만 사용 가능

### 4. 관리자 기능

* 전체 사용자 목록 조회
* 권한에 따른 기능 분리

---

## 🧠 설계 포인트

### ✔ 캡슐화 (Encapsulation)

* 모든 필드는 `private`으로 선언
* 비밀번호는 getter를 제공하지 않고 검증 메서드로만 접근

### ✔ 역할 분리 (Separation of Concerns)

* `User` → 사용자 데이터 관리
* `UserManager` → 회원가입, 로그인, 사용자 관리
* `Main` → 입력 및 실행 흐름 제어

### ✔ 보안 관점 설계

* 권한(role)을 사용자 입력으로 받지 않고 시스템에서 강제 설정
* 관리자 계정은 별도로 생성

---

## 🏗️ 프로젝트 구조

```
User.java          → 사용자 정보 (id, password, role 등)
UserManager.java   → 회원가입 / 로그인 / 사용자 관리
Main.java          → 실행 및 사용자 인터페이스
```

---

## 🔑 핵심 코드 개념

### 비밀번호 검증 방식

```java
public boolean checkPassword(String inputPw) {
    return this.password.equals(inputPw);
}
```

→ 비밀번호 값을 직접 노출하지 않고 검증 결과만 반환

---

### 권한 분기 처리

```java
if (user.getRole().equals("ADMIN")) {
    manager.showAllUsers();
}
```

→ 역할(Role)에 따라 기능 접근 제어

---

## 🚀 실행 흐름

1. 회원가입 진행
2. 로그인 시도
3. 로그인 성공 시:

   * ADMIN → 관리자 기능 사용 가능
   * USER → 일반 사용자 기능만 사용

---

## 📈 개선 예정

* Hashing을 통한 비밀번호 암호화
* 로그인 세션 개념 도입
* 역할(Role) enum으로 개선
* 예외 처리 강화

---

## 💡 배운 점

* 객체지향 설계를 통해 기능을 분리하는 방법 이해
* 단순 기능 구현이 아닌 **보안 관점에서의 설계 중요성** 체감
* 인증(Authentication)과 인가(Authorization)의 차이를 코드로 경험

---

## 🧾 기술 스택

* Java 21
* OOP (객체지향 프로그래밍)
* ArrayList 기반 데이터 관리

---

