# 접근 제어자
## 접근 제어자가 선언되어 있지 않다면?
```java
Human adam = new Human("Adam", 20, Sex.MALE, Citizenship.KOREA);
System.out.printf("Adam age is now %d", adam.age);

adam.age = 0;
System.out.printf("Adam age is now %d", adam.age);
```
- 개체는 생성자를 통해 완성된 형태로 인스턴스를 생성하는 불변 개체여야 함
- 그러나, 접근제어자가 존재하지 않을 시에는 이렇게 변경 가능

### 개체는 자신의 상태를 스스로 책임져야 함
- 현실 속의 사람(human)
  - 시간이 지나면 저절로 나이를 먹음
  - 외부 누군가 강제로 내 나이를 바꿀 수 없음
- 즉, 개체 외부에서 개체의 상태에 직접 접근하는 것을 막아야 함
- 개체의 상태를 변경하는 주체는 개체 자신인 게 이상적
- 접근 제어자(access modifier)를 통해 이런 일을 할 수 있음

## 접근제어자 종류
- 어떤 외부자들이 개체 속에 접근할 수 있는지 정의
1. public : 누구나 접근 가능
2. protected : 자식들만 접근 가능
3. 생략할 경우 : 같은 패키지에 속한 클래스들만 접근 가능
   - default 혹은 package 접근 제어자라 부름
4. private : 외부 접근 금지


## 일반적인 접근 제어자
- 보통 다음과 같은 접근 제어자를 사용
  - 멤버 변수: private (또는 protected)
  - 메서드: public
- 멤버 변수 접근은 메서드를 통해서만!
  - 캡슐화
  - 추상화


