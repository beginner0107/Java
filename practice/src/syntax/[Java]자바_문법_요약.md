# 자바 문법 요약
## 올바른 새 줄 문자 추가 방법
```java
String name = "Amumu";
int score = "27";
System.out.println("%s' s score : %d%s", name, score, System.lineSeparator());
```
- 플랫폼에 알맞은 새 줄 문자를 반환하는 메서드
- Linux: \n 반환
- Windows: \r\n 반환

## 가변 인자 
```java
public void printNames(String... name) {}
public void printNames(Object... name) {}
```
- ... 앞에 자료형을 반드시 넣어야 함
- 해당 자료형의 데이터만 인자로 전달 가능
- Object 라는 자료형을 쓸 경우 모든 자료형을 넣을 수 있음

## package
```java
package syntax;
```
- 연관된 클래스들끼리 묶는 기법
- 디스크 상의 폴더와 같은 역할

### 패키지 종류
1. 자바 기본(built-in) 패키지
  - 이름이 java로 시작하는 패키지들
  - 예) java.lang, java.util
2. 프로그래머가 직접 만든(user-defined) 패키지

### 패키지의 목적
- 이름 충돌 문제를 피할 수 있게 해 줌

### 패키지 이름 짓기
- 패키지 이름의 중복을 최소화해야 함
- 그래서 보통 회사의 도메인명을 패키지 이름에 사용
- 예: samsung.com 회사에서 패키지를 만들 경우
```java
package com.samsung.패키지이름;
```

## 빌드 및 실행
### javac 명령어
```text
javac -d <컴파일 결과물을 저장할 경로> <컴파일할 .java 파일>
```
- .java 파일이 컴파일 되면 .class 파일 나옴
  - 이름은 .java와 동일
  - .class 파일에는 바이트 코드가 들어있음
- 옵션 -d
  - .class 파일을 저장할 경로

### 실행하기
```text
java -classpath <class 파일 위치> <클래스 이름>
```
- C나 C#처럼 컴파일하면 실행파일(예:.exe)이 나오지 않음
  - 대신 바이트 코드(*.class)가 나옴
- 바이트 코드를 실행하는 명령어
- <클래스 이름>
  - 실행할 .class 파일 이름
  - 반드시 main 함수가 들어 있어야 함

### 배포하기
- 내가 만든 라이브러리나 프로그램을 배포하는 방법
- Java의 경우
  - 두 경우 모두 .jar 파일을 만듦

#### jar 명령어
```text
jar <option> <jar 파일 이름> <최상위 패키지 경로>
jar -cf ..\lib\helloword.jar syntax
```
- .jar 파일을 만드는 명령어
- 옵션: -cf
  - c: create(생성)
  - f: 만들어질 .jar 파일의 이름을 지정. f 뒤에 파일명이 와야 함

#### jar는 사실 .zip 파일
- .jar는 사실 단순히 .zip 파일에 지나지 않음
- 실제 압축 프로그램으로 압출을 풀 수도 있음
- META-INF 폴더
  - .jar 파일 내부를 보면 META-INF\MANIFEST.MF라는 파일이 있음
  - .jar를 만들 때 같이 생성되는 파일

### Manifest 파일
- manifest (명사)
  - 세관에서 사용하는 선박이나 화물에 대한 상세한 정보를 나타낸 문서
- 자바 애플리케이션의 정보를 담고 있는 메타데이터 파일
- .jar 파일을 만들 때 이 파일을 같이 넣어줄 수 있음
- .jar 파일의 시작점(메인 함수)에 대한 정보를 넣어야 함

## java.lang
- 기본 패키지
- 모든 .java 파일에 자동으로 임포트되는 패키지
- 아래와 같은 코드가 모든 파일에 자동으로 들어감
- import java.lang.*;
- System은 java.lang 안에 있는 클래스 중 하나

## Java 크로스 플랫폼
- 크로스 플랫폼(cross-platform)?
  - 특정 언어로 작성한 코드를 여러 플랫폼에서 실행할 수 있다는 의미
  - 여러 디바이스와 운영체제에서 실행가능한 소프트웨어

### 전통적인 컴파일 및 실행
- 컴파일을 하면 실행 파일이 나옴
- 실행 파일은 기계어이며 운영체제가 직접 실행하는 파일
- 각 운영체제/디바이스마다 실행파일을 따로 만들어야 함
  - 컴파일러가 소스코드를 각 운영체제/디바이스에 맞는 기계어로 바꿔줌
  - 소스 코드는 안 바꿔도 됨
  - C는 이런 관점에서 크로스 플랫폼

### 자바의 컴파일 모델
- 코드를 컴파일 한 결과는 바이트 코드
  - 실행 파일이 아님
- 바이트 코드(byte code)란?
  - 어떤 운영체제/디바이스가 이해하는 기계어가 아님
  - JVM이라는 특수한 프로그램이 이해하는 명령어
  - JVM이 실행 중에 최종 플랫폼에 맞는 명령어로 바꿔서 실행해줌
  - JVM에 맞게 최적화 됐지만 당연히 기계어보다는 느림

### 자바 가상 머신(Java Virtual Machine, JVM)
- 각 운영체제에 설치하는 별도의 프로그램
  - 각 운영체제/디바이스마다 다른 버전을 설치
- Java의 바이트 코드를 실행함


### Java의 플랫폼은 JVM?
- JVM이 설치 안 되어 있다면?
  - Java 프로그램 실행 불가
  - Java의 플랫폼은 JVM이라고도 할 수 있음
  - 이런 관점에서 크로스 플랫폼이라고 하기엔 어폐가 있음
- JVM이 바이트 코드를 실제 디바이스에서 실행하는 방식은 다양
  - 과거 JVM은 인터프리터 방식으로 동작
  - 최신 JVM은 JIT(just-in-time) 컴파일을 추가
  - 여러 가지 컴파일 방식이 공존하는 형태


## Java의 String은 변경 불가(immutable)
```java
String name = "Banana";
name[0] = 'C'; // 컴파일 오류
```
- C++에서는 가능
- Java에서는 불가능
- 생성된 String 객체는 변경 불가
- 바꾸고 싶다면 새로운 문자열을 만들어야 함

## 리터럴
### 정수 리터럴
```java
int num1 = 1234;
long num2 = 1234567890L;
long num3 = 987654321l;
long num4 = 1234567890123123123123; // 컴파일 오류
```
- int의 리터럴: 없음
- long의 리터럴: L 혹은 l
  - 생략 가능
  - 하지만 int의 범위보다 큰 수일 때 생략하면 컴파일 오류

```java
int num1 = 0xFFFF;
int num3 = 0b11001010;
int num2 = 01234;
```
- 16진수 리터럴: 0x
- 2진수 리터럴: 0b
- 8진수 리터럴: 0

### 부동 소수점 리터럴
```java
float num1 = 10.0F;
float num2 = 3.14f;
double num3 = 93423.8374D;
double num4 = 1231231.323d;
double num5 = 9323.91;
```
- float의 리터럴: F 혹은 f
- double의 리터럴: D 혹은 d
  - 생략해도 무방
  - 보통 생략

### 문자, 문자열 리터럴
```java
char ch = 'a';
String helloWorld = "Hello World!";
String alphabet = "\u03b1\u03b2\u03b3";
String hello = "hello";
```
- 문자 리터럴: 작은 따옴표
- 문자열 리터럴: 큰 따옴표
- 유니코드 표현: \unnnn
- 이스케이프(escape)문자: \로 시작
- \' \" \\ \r \n \f \t \b \ddd

### 기타 리터럴
```java
String msg = null;
int num = 12_345_678;
float pi = 3.14_15F;
long hexNum = 0xFF_EC_DE_5E;
```
- null
  - 참조형에 사용 가능한 리터럴
  - 의미: 참조하는 대상이 없음(C의 널 포인터)
- _
  - 큰 숫자의 가독성을 높이기 위해 사용 (쉼표 찍듯이)
  - Java 7부터 사용 가능

## Java의 상수형 변수: final 
```java
final int MAX_VALUE = 10;
MAX_VALUE = 20; // 컴파일 오류
```
- Java는 const 대신 final 키워드를 사용
- 변수 값 변경을 금지

### final 키워드를 붙일 수 있는 곳
1. 지역변수
2. 클래스 멤버변수
3. 메서드 매개변수
4. 클래스와 메서드

## 주석
### Javadoc 주석
- 모든 설명은 /** */ 을 붙인다
```java
/**
 * Returns the sum of the arguments
 * @param op1 the first value
 * @param op2 the second value
 * @return the result
 */
public static int add(int op1, int op2) {
    return op1 + op2;
}
```
- @<태그>를 이용하여 설명을 추가할 수 있음
  - @param op1 the first value
  - @param op2 the second value
  - @return the result

## 연산자
### 비트 이동(bit shift) 연산자
```java
int op = 12;          // (비트 생략) 0000 1100

int twice = op << 1;  // (비트 생략) 0001 1000
int half = op >> 1;   // (비트 생략) 0000 0110
```
- ```<<``` 연산자: 비트를 왼쪽으로 이동
- ```>>``` 연산자: 비트를 오른쪽으로 이동
- 몇 칸을 이동하는지는 오른쪽 피연산자로 지정

#### ````>>>>```` 연산자
```java
int num1 = -125;    // 1111 1111 1111 1111 1111 1111 1000 0011
int num2 = -125;    // 1111 1111 1111 1111 1111 1111 1000 0011 : 4294967171
num1 = num1 >> 1;   // 1111 1111 1111 1111 1111 1111 1100 0001 : -63
num2 = num2 >>> 1;  // 0111 1111 1111 1111 1111 1111 1100 0001 : 2147483585
```
- 부호 없는 비트 이동 연산자
- 오른쪽으로 이동 후 남는 공간을 '0'으로 채움
- Java에는 부호 없는 자료형이 없기에 이렇게 연산자를 따로 만듦
