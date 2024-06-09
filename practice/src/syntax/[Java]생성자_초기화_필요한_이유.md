# 생성자 초기화가 필요한 이유
- 왜 개체 생성 후 값을 대입하면 안 좋은 걸까
- 어떤 값을 개체 생성 직후에 바꿔주나 생성자에서 처음부터 초기화 해주나 결과는 똑같지 않나?
```java
Human adam = new Human();

adam.sex = Sex.MALE;
adam.name = "Adam";
adam.age = 20;
```

```java
Human adam = new Human("adam", 20, Sex.MALE);
```

1. 개념 상의 문제
   - 공장에서 찍어 나온 물건이 속이 비어 있다는 게 말이 될까?
   - 예: 공장에서 콜라가 나왔는데 캔만 있음

2. 후조건의 문자
   - 생성자도 함수. 따라서 선조건과 후조건이 적용
   - 생성자의 후조건: '개체의 상태는 개체 생성과 동시에 유효하다'

3. 사용자를 고려 안 한 문제
   - 사용자란?
     - 내가 만든 클래스를 사용하는 코드 혹은 프로그래머
     - 나 자신이 될 수도 남이 될 수도 있음
   - 문제: 사용자의 실수를 유발
     - 클래스에 있는 어떤 멤버 변수를 초기화해야 하는가?
     - 어떤 값으로 초기화해야 하는가?
     - 나중에 멤버 변수가 추가될 때 기존의 초기화 코드들을 업데이터 안 하면?

### 어떤 멤버 변수를 초기화해야 하는가?
1. 클래스가 저장되어 있는 파일을 열어서 봐야 함
```java
public class Human {
    public String name;
    public int age;
    public Sex sex;
}
```
- 이름이랑 나이 성별을 초기화할 수 있음

2. 어떤 멤버 변수를 초기화해줘야 하는지 모를 수도 있음
```java
public class Human {
    public String name;
    public int age;
    public Sex sex;
    Date lastUpdateDate;
    int annualIncome;
    
    public void getAnnualIncome() {
        // lastUpdateDate가 현재보다 1년 전일 때만 annualIncome을 계산
        // 계산이 느려서 매번 하지 않음
    }
}
```
- 다 초기화해야 하나?
- 아니면 안 해도 괜찮은 멤버 변수가 있나?

3. 나중에 멤버 변수가 추가되는 것에 대응하기 어려움
- 변경 전
```java
public class Human {
    public String name;
    public int age;
    public Sex sex;
}
```
- 변경 후
```java
public class Human {
    public String name;
    public int age;
    public Sex sex;
    public Citizenship citizenship;
}
```

```java
Human adam = new Human();

adam.sex = Sex.MALE;
adam.name = "Adam";
adam.age = 20;
// citizenship 코드가 없음
```

- citizenShip을 넣는 코드가 없어도 컴파일에는 문제가 없음
  - 실수할 여지가 생김

#### 어떤 값으로 초기화해줘야 하는가?
1. 그 분야를 잘 아는 사람만 알 수 있는 내용이 있음
- 예: 한국 국적의 사람일 경우, '세는 나이'를 사용할 것

```java
Human adam = new Human();

adam.sex = 사용자가 입력한 값;
adam.name = 사용자가 입력한 값;
adam.age = 사용자가 입력한 값;
adam.citizenship = 사용자가 입력한 값;

if (human.citizenship == Citizenship.KOREA) { // 빼먹기 쉽고, 중복 발생
    human.age += 1;
}
```
- 잘 모르는 사람은 해당 코드를 빼먹을 수도

2. 초기화에 어떤 계산이 필요한 경우 코드가 중복됨

## 외부라이브러리를 사용하면 더 심각한 문제
- .class 파일만 제공됨
- 클래스 선언이 있는 소스파일을 열어볼 수 없음
- 뭐든 간에 여태까지 본 문제는 모두 생성자로 해결 가능

## 요약
- 멤버 변수가 추가되면 어떡하지?
- 어떤 멤버 변수를 초기화하지?
- 소스파일을 볼 수 없는 경우에는?
- 코드 중복이 미쳐 날뛰는데 어떡하지?
- 아 매번 소스파일을 열어야 하나?
- 모든 프로그래머가 다 XX 도메인을 잘 아는 것은 아닌데 해당 필수 코드를 누락하면 어떡하지?

### 결론: 생성자는 개체를 만들어주는 계약이다.
1. 함수는 블랙박스
2. 호출자와 함수의 분명한 책임 분리
   - 호출자는 함수 속이 어떻게 작동하는지 넓게 알려고 하지 말 것
   - 이 책임의 분리는 함수 시그내처, 선조건, 후조건 등으로 확실히 정의

- 호출자
  - 내가 호출한 함수의 내부를 알 필요는 없음
  - 그냥 호출
- 함수
  - 내가 뭐하는지 알고 싶으면 재 시그내처를 봐!
  - (좀 부족해서 주석도 닮)

- 즉, 외부에서 클래스 내부의 데이터를 알 필요 없음
  - 이게 바로 데이터 추상화
    - 캡슐화의 일부
  - 이 개념은 생성자뿐만 아니라 모든 메서드에도 적용
