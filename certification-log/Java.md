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
1. byte(1 byte = 8 bits) : -2^7 ~ 2^7-1 (-128 ~ 127)
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
- ex)
```comand
String str = "안녕하세요!"; // 문자열 리터럴
String str_2 = new String(original:"안녕하세요!"); // 생성자
String str_3 = "안녕하세요!";

if (str == str_2) {
  System.out.println("str == str_2");
  }
각각 해주면
str_2는 str,str_3랑 다름.  str이랑 str_3는 같음 ex)
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
- ex)
```comand
String str = "안녕하세요!"; // 문자열 리터럴
String str_2 = new String(original:"안녕하세요!"); // 생성자
String str_3 = "안녕하세요!";

if (str == str_2) {
  System.out.println("str == str_2");
}
각각 해주면
str_2는 str,str_3랑 다름.  str이랑 str_3는 같음

if (str.equals(str_2)) {
  System.out.println("str.equals(str_2)");
}

if (str.equals(str_3)) {
  System.out.println("str.equals(str_3)");
}

if (str_2.equals(str_3)) {
  System.out.println("str_2.equals(str_3)");
}

equals는 내용 자체를 비교하기 때문에 셋 다 같다고 나옴!!!
(값을 비교할 때는 ==보다 equals 쓴다!)
```

- 문자열 병합
```command
1. '+' 연산자
String str_1 = "Hello,";
String str_2 = "World!"; 

System.out.println(str_1 + str_2); ==> Hello,World! (띄어쓰기 안 됨->에초에 "Hello, " 공백 넣거나 str_1 + " " + str_2) 

2. StringBuilder
StringBuilder strBdr_1 = new StringBuilder("Hello,");

strBdr_1.append("World!");

String str_new = strBdr_1.toString();

System.out.println(str_new); ==> Hellow,World! (공백넣으려면 strBdr_1.append(" ");를 World!전에 넣으면 됨)
```

- 문자열 슬라이스
```command
String str_1 = "이름: 김자바";
System.out.println(str_1.indexOf("이")); ===> 0

String str_name = str_1.substring(4, 7); (김이 4이고 바가 6인데 뒤에서 미만까지 처리되므로 7)
System.out.println(str_name); ===> 김자바
```

- 문자열 대소문자 변환
```command
String str_1 = "abc";
String str_2 = "ABC";

str_1 = str_1.toUpperCase();
str_2 = str_2.LowerCase();
===>출력하면 각각 대문자, 소문자로 출력.

if (str_1.equals(str_2)) {
  System.out.println("str_1.equals(str_2)");
} ===> 출력 안됨. ABC랑 abc 달라서 근데

if (str_1.equalsIgnoreCase(str_2)) {
  System.out.println("str_1.equalsIgnoreCase(str_2)");
} ===> 대소문자 무시하므로 출력됨.
```

- 공백 제거
```command
1. 양쪽 끝 공백
String str_1 = "       Hello     ";
str_1.trim();

2. 문자열 중간 공백
String str_2 = "  Hel    lo  ";
str_2 = str_2.trim(); ===> Hel    lo (중간 공백은 안 사라짐)
str_2 = str_2.replace(target:" ", replacement:"");
===> Hello
```

- 콘솔 입출력
```command
public class ConsoleI0 {
  public static void main(String[] args) {
  
    Scanner sc = new Scanner(System.in);
    System.out.print("아이디를 입력해주세요. >>");
    String username = sc.nextLine(); (문자 데이터)

    System.out.print("생년월일을 입력해주세요. >>");
    int birthDate = sc.nextInt(); (정수 데이터)

    System.out.printf("%s %d", username, birthDate);
  }             (%s\n%d 하면 username 엔터 한 번 하고 birthDate 뜸, %s\tab%d 는 탭키)
}


(print 뒤에 ln 지우면 띄어쓰기 안되고 바로 그 자리에서 입력 값 받음!!! 꺽쇠 바로 옆으로 입력창 뜸)

