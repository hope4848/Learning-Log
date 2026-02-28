LTS(Long-Term Supoort)

장기 유지 보수 및 보안 패치 지원 버전

안정적인 프로그램 개발을 위해 사용 권장

## JVM - Java Virtual Machine
- Java 프로그램이 실행되는 가상의 공간
- 운영체제와 상관 없이 JVM이 구성되어 있다면 Java 프로그램 실행 가능

## JRE - Java Runtime Environment
- Java로 컴파일 된 프로그램을 실행
- 모든 Java 프로그램은 JVM에서 실행

## JDK - Java Development Kit
- Java 어플리케이션 개발을 위해 반드시 필요
- Java 컴파일러와 JRE포함

## 변수
1. 1개의 변수 => 1개의 값만 할당 가능
2. 변수에 저장된 값 => 재할당을 통해 변경 가능
3. 값의 형태에 맞는 자료형을 사용
4. 변수명은 소문자로 시작
5. 대소문자 구분, 공백 포함 불가능
6. 자바 예약어 사용 불가

## 정수형 
1. byte(1 byte = 8 btis) : -2^7 ~ 2^7-1 (-128 ~ 127)
2. short(2 bytes = 16 bits) : -2^15 ~ 2^15-1(-32,768 ~ 32,767)
3. int(4 bytes) : -2^31 ~ 2^31-1
4. long(8 bytes) : -2^63 ~ 2^63-1

## 실수형
1. double(8 bytes) - 소수점 15자리
2. float(4 bytes) - 소수점 7자리

## 문자형
char(2 bytes)

아스키 코드, 유니코드 다 가능.

## 논리형
boolean(1 byte) 
- ex)
  - boolean bool_1 = true;
  - boolean bool_2 = false;
  - boolean bool_3 = (100<0);
  - but! boolean bool_4 = 1; <<< 은 true로 안나옴!

## 참조형
- 참조형 데이터의 값 => 힙 메모리 영역
- 변수에 대입되는 값 => 힙 메모리 영역의 주소값
- String a = new String(original:"Hello!");
- String b = "Hello!";
- String c = "Hello1"; 라 했을 때 a랑 b,c는 주소 다름, b랑 c는 주소 같음

## 상수 (constants, final variables)
- 한 번 값이 할당 => 재할당이 불가능 <-> 변수
- 전체를 대문자로 표시, 단어간 구분은 _ 로 표시
- ex)
  - final doulbe PI = 3.14;
  - System.out.println(PI);
  - PI = 3.141592; <<< 오류 남

## 형변환
- byte < short < int < long <<< float < double
- short a = 128;
- int b = a; <<< b의 범위가 더 크므로 가능! 근데 반대면 오류나므로 *강제 형변환 필요*
- 강제 형변환
```comand
int a = 128;
short b = (short) a;
byte c = (byte) a;
System.out.println(a); >>> 128
System.out.println(b); >>> 128
System.out.println(c); >>> -128 (범위 초과) <<< 강제 형변환할 때 범위 확인 잘해라.

int m = 80;
double n = m;
Syste.out.println(m); >>> 80
System.out.println(n);  >>> 80.0 (실수형)

double c = 10.3;
float d = (float) c;
System.out.println(c); >>> 10.3
System.out.println(d); >>> 10.3

double c = 10.33124546435;
float d = (float) c;
System.out.println(c); >>> 10.33124546435
System.out.println(d); >>> 10.331245 (범위 초과라 뒤에 잘림)

int e = 10;
short f = 20;
short g = (short) (e + f); 연산을 강제 형변환 할 때 연산 식 전체에 괄호 씌우기! 
``` 

## String 
- String => 문자열 객체
- 객체 => 힙 메모리 영역
- 변수 => 힙 메모리 영역의 주소

















